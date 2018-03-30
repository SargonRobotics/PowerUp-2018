package org.usfirst.frc.team2335.robot;

public class RobotMap
{
	//Deadzone constant
	public static final double deadzone = 0.15;
	
	public static class Sensors
	{
		public static final int rightEncoderA = 8, rightEncoderB = 9;
	}
	
	//Controller constants
	public static class Controller
	{
		//Controller axes constants
		public static class Axes
		{
			public static final int xDrive = 0, yDrive = 1;
		}

		//Button constants
		public static class Buttons
		{
			//Climb Buttons
			public static final int climbButton = 2, hookUp = 5, hookDown = 6;
			
			//Arm Buttons
			public static final int vaccuumToggle = 1, armAimLow = 3, armAimHigh = 4;
		}
	}
	
	//Motor controller constants
	public static class MotorControllers
	{
		//Drive motors
		public static final int leftDrive = 0, rightDrive = 1;
		
		//Climb motors
		public static final int hookMotor = 3, climbWinch = 4;

		//Vacuum port
		public static final int vaccuumMotor = 2;
	}

	//Solenoid constants
	public static class Solenoids
	{
		//Cube launching pistons
		public static final int leftLaunch = 0, rightLaunch = 1;
		
		//Lower aiming pistons
		public static final int lowerAimExtend = 3, lowerAimRetract = 2;
		
		//Upper aiming pistons
		public static final int upperAimExtend = 4, upperAimRetract = 5;
	}
	
	//State constants
	public static class States
	{
		public static class Arm
		{
			public static final int aimGround = 0, aimSwitch = 1, aimScale = 2;
		}
	}
}
