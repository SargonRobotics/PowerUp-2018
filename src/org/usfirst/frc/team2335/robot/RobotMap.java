package org.usfirst.frc.team2335.robot;

public class RobotMap
{
	//Deadzone constant
	public static final double deadzone = 0.15;
	
	//Sensor constants
	public static class Sensors
	{
		//Ultrasound
		public static final int ultrasoundAnalog = 0;
		
		//Encoders
		public static final int leftEncoderA = 0, leftEncoderB = 1, rightEncoderA = 2, rightEncoderB = 3;
	}
	
	//Controller constants
	public static class Controller
	{
		//Axis constants
		static class Axes
		{
			//X and Y drive
			public static final int xDrive = 0, yDrive = 1;
		}
	}
	
	//Motor controller constants
	public static class MotorControllers
	{
		//Drive controllers
		public static final int leftDrive = 0, rightDrive = 1;
	}
}
