package org.usfirst.frc.team2335.robot;

import org.usfirst.frc.team2335.robot.commands.Auto;
import org.usfirst.frc.team2335.robot.commands.ResetShootingArm;
import org.usfirst.frc.team2335.robot.subsystems.Climber;
import org.usfirst.frc.team2335.robot.subsystems.Drive;
import org.usfirst.frc.team2335.robot.subsystems.VacuumArm;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot
{
	//Subsystems
	public static Climber climber;
	public static Drive drive;
	public static VacuumArm vacuumArm;
	public static OperatorInterface oi;


	//Controller values
	private double yVal, xVal;
	private boolean vacuumState;
	private int armState, prevArmState;

	//For choosing autonomous command
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	@Override //Used to initialize code
	public void robotInit()
	{
		climber = new Climber();
		drive = new Drive();
		vacuumArm = new VacuumArm();
		oi = new OperatorInterface(); //Initialize this last or you break everything
		
		vacuumState = false;
		armState = RobotMap.States.Arm.aimSwitch;
		prevArmState = armState;
		
		chooser.addDefault("Auto", new Auto());
		chooser.addObject("No Auto", null);
		
		//Adds auto commands
		SmartDashboard.putData("Auto mode", chooser);
		
		//Reset solenoids
		SmartDashboard.putData("ResetPosition", new ResetShootingArm());
		
		//Vacuum indicator
		SmartDashboard.putBoolean("Vacuum", vacuumState);
	}

	@Override
	public void disabledInit()
	{

	}

	@Override
	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}
	
	//Runs once autonomous starts, used to set the autonomous command
	@Override
	public void autonomousInit()
	{
		autonomousCommand = chooser.getSelected();

		//Schedule the autonomous command (example)
		if (autonomousCommand != null)
		{
			autonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}
	
	//Runs at the start of teleop
	@Override
	public void teleopInit()
	{
		//Stops the auto command if it's still running
		if (autonomousCommand != null)
		{
			autonomousCommand.cancel();
		}
	}

	//Runs at a 20ms loop during teleop
	@Override
	public void teleopPeriodic()
	{
		//Gets axis values from the controller
		yVal = oi.getAxis(RobotMap.Controller.Axes.yDrive, 1);
		xVal = oi.getAxis(RobotMap.Controller.Axes.xDrive, 0.75);
			
		//Drives robot (woah didn't know that one)
		drive.drive(yVal, xVal);
		
		//Changes vacuum state once the vacuum button is pressed
		vacuumState = oi.getButtonPressed(0, RobotMap.Controller.Buttons.vaccuumToggle) ? !vacuumState : vacuumState;
		
		//Changes the arm state on a button pressed
		
		//Once the lower arm button pressed, if the arm isn't already in the low aim state, set it there
		//Same thing with the high aim state
		if(oi.getButtonPressed(0, RobotMap.Controller.Buttons.armAimLow))
		{
			armState = (armState == RobotMap.States.Arm.aimSwitch ? RobotMap.States.Arm.aimGround : RobotMap.States.Arm.aimSwitch);
		}
		else if(oi.getButtonPressed(0, RobotMap.Controller.Buttons.armAimHigh))
		{
			armState = (armState == RobotMap.States.Arm.aimScale ? RobotMap.States.Arm.aimGround : RobotMap.States.Arm.aimScale);
		}
		
		//If the vacuum state is set to on, run the vacuum, otherwise stop it
		if(vacuumState)
		{
			vacuumArm.startVaccuum();
		}
		else
		{
			vacuumArm.stopVaccuum();
		}
		
		//If the arm state has changed, change the pistons accordingly
		if(armState != prevArmState)
		{
			if(armState == RobotMap.States.Arm.aimSwitch)
			{
				vacuumArm.switchArm();
			}
			else if(armState == RobotMap.States.Arm.aimScale)
			{
				vacuumArm.scaleArm();
			}
			else if(armState == RobotMap.States.Arm.aimGround)
			{
				vacuumArm.groundArm();
			}
			
			System.out.println(armState);
		}
		
		//Set previous arm state
		prevArmState = armState;
		
		//Update vacuum indicator
		SmartDashboard.putBoolean("Vacuum", vacuumState);
						
		Scheduler.getInstance().run();
	}

	//This function is called periodically during test mode.
	@Override
	public void testPeriodic()
	{
		
	}
}
