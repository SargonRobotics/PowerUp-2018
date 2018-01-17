package org.usfirst.frc.team2335.robot;

import org.usfirst.frc.team2335.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot
{
	//Constants
	//Deadzone
	public static final double DEADZONE = 0.15;
	
	//Encoder ports
	//TODO: Sets these to real things
	public static final int ENCODER_A = 0, ENCODER_B = 1;
	
	//Subsystems
	public static Drive drive;
	public static OperatorInterface oi;

	//For choosing autonomous command
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	//Used to initialize code
	@Override
	public void robotInit()
	{
		drive = new Drive();
		oi = new OperatorInterface(); //Initialize this last or you break everything
		
		//Adds auto commands
		//chooser.addDefault("Default Auto", new ExampleCommand());
		//chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
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
		Scheduler.getInstance().run();
	}

	//This function is called periodically during test mode.
	@Override
	public void testPeriodic()
	{
		
	}
}
