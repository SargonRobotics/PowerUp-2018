package org.usfirst.frc.team2335.robot;

public class RobotMap
{
	//Deadzone constant
	public static final double deadzone = 0.15;
	
	//Controller constants
	public static class Controller
	{
		//Controller axes constants
		//Axes constants
		public static class Axes
		{
			public static final int xDrive = 0, yDrive = 1;
		}

		//Button constants
		public static class Buttons
		{
			public static final int climbButton = 1, hookUp = 2, hookDown = 3;
		}
	}
	
	//Motor controller constants
	public static class MotorControllers
	{
		//Drive motors
		public static final int leftDrive = 0, rightDrive = 1;
		
		//Climb motors
		public static final int hookMotor = 5, climbWinch = 4;
	}
}
