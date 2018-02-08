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
			public static final int xDrive = 0, yDrive = 1;
		}
		
		//Button constants
		public static class Buttons
		{
			public static final int climbButton = 0, hookUp = 1, hookDown = 2;
		}
	}
	
	public static class MotorControllers
	{
		//Drive motors
		public static final int leftDrive = 0, rightDrive = 1;
		
		//Climb motors
		public static final int hookMotor = 2, climbWinch = 3;
	}
}
