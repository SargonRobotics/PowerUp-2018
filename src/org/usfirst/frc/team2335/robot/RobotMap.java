package org.usfirst.frc.team2335.robot;

public class RobotMap
{
	//Deadzone constant
	public static final double deadzone = 0.15;
	
	//Controller constants
	public static class Controller
	{
		//Axes constants
		public static class Axes
		{
			//Drive axes
			public static final int xDrive = 0, yDrive = 1;
		}
		
		//Button constants
		public static class Buttons
		{
			//Vacuum buttons
			public static final int vaccuumToggle = 1, toggleValve = 2;
		}
	}
	
	//Motor controller constants
	public static class MotorControllers
	{
		//Drive ports
		public static final int leftDrive = 0, rightDrive = 1;
		
		//Vaccuum port
		public static final int vacuumMotor = 2;
	}
	
	//Servo constants
	public static class Servos
	{
		//Valve servo
		public static final int valveServo = 9;
	}

	//Solenoid constants
	public static class Solenoids
	{
		//Cube launching pistons
		public static final int leftLaunch = 0, rightLaunch = 1;
		
		//Lower aiming pistons
		public static final int lowerAimExtend = 2, lowerAimRetract = 3;
		
		//Upper aiming pistons
		public static final int upperAimExtend = 4, upperAimRetract = 5;
	}
}
