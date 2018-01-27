package org.usfirst.frc.team2335.robot;

import org.usfirst.frc.team2335.robot.commands.groups.AutoDriveCenter;
import org.usfirst.frc.team2335.robot.commands.groups.AutoDriveSide;
import org.usfirst.frc.team2335.robot.subsystems.Drive;
import org.usfirst.frc.team2335.robot.subsystems.EncoderPID;
import org.usfirst.frc.team2335.robot.subsystems.GyroPID;
import org.usfirst.frc.team2335.robot.subsystems.UltrasoundPID;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot
{
	/*** Constants ***/

	//Deadzone
	public static final double DEADZONE = 0.15;
	
	//Ultrasound constants
	public static int ULTRASOUND_PIN = 0; //TODO: set to actual values

	//Motor controller constants
	public static final int LEFT_MOTOR = 0, RIGHT_MOTOR = 1;
	
	//Controller axes
	public static final int X_AXIS = 0, Y_AXIS = 1;

	//Encoder ports
	//TODO: Sets these to real things
	public static final int ENCODER_A = 0, ENCODER_B = 1;

	//Subsystems
	public static EncoderPID encoderPID;
	public static Drive drive;
	public static UltrasoundPID ultrasoundPID;
	public static GyroPID gyroPID;
	
	public static OperatorInterface oi;

	//Controller values
	private double yVal, xVal;

	//For choosing autonomous command
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	//Used to initialize code
	@Override
	public void robotInit()
	{
		encoderPID = new EncoderPID();
		drive = new Drive();
		ultrasoundPID = new UltrasoundPID();
		gyroPID = new GyroPID();
		
		oi = new OperatorInterface(); //Initialize this last or you break everything
		
		//Adds auto commands
		chooser.addDefault("Left Side Auto", new AutoDriveSide('L'));
		chooser.addObject("Right Side Auto", new AutoDriveSide('R'));
		chooser.addObject("Center Auto", new AutoDriveCenter());
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
		yVal = oi.getAxis(Y_AXIS, 1);
		xVal = oi.getAxis(X_AXIS, 1);
			
		drive.drive(yVal, -xVal);		
		Scheduler.getInstance().run();
	}

	//This function is called periodically during test mode.
	@Override
	public void testPeriodic()
	{
		
	}
}
