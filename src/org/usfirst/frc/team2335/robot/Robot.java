package org.usfirst.frc.team2335.robot;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team2335.robot.subsystems.Drive;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot
{	
	//Subsystems
	public static Drive drive;
	public static OperatorInterface oi;
	
	//Controller values
	private double yVal, xVal;

	//For choosing autonomous command
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	@Override //Used to initialize code
	public void robotInit()
	{
		drive = new Drive();
		oi = new OperatorInterface(); //Initialize this last or you break everything
		
		initCamera();
		
		//Adds auto commands
		//chooser.addDefault("Default Auto", new ExampleCommand());
		//chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
	}
	
	private void initCamera()
	{
		//Starts camera thread
		new Thread(() ->
		{
			UsbCamera cam = CameraServer.getInstance().startAutomaticCapture();
			cam.setResolution(RobotMap.Camera.width, RobotMap.Camera.height);
			
			CvSink sink = CameraServer.getInstance().getVideo();
			CvSource outputStream = CameraServer.getInstance().putVideo("Obsergaytion_01", RobotMap.Camera.width, RobotMap.Camera.height);
			
			Mat vidSource = new Mat();
			Mat output = new Mat();
			
			while(!Thread.interrupted())
			{
				sink.grabFrame(vidSource);
				Imgproc.cvtColor(vidSource, output, Imgproc.COLOR_BGR2RGB);
				outputStream.putFrame(output);
			}
		});
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
		yVal = oi.getAxis(RobotMap.Controller.Axes.xDrive, 1);
		xVal = oi.getAxis(RobotMap.Controller.Axes.yDrive, 1);
			
		drive.drive(yVal, -xVal);
						
		Scheduler.getInstance().run();
	}

	//This function is called periodically during test mode.
	@Override
	public void testPeriodic()
	{
		
	}
}
