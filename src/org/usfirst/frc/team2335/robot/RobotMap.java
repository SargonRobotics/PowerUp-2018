package org.usfirst.frc.team2335.robot;

public class RobotMap
{
	//Deadzone constant
	public static final double deadzone = 0.15;
	
	public static class Camera
	{
		//Camera constants
		public static final int width = 640, height = 480;
	}
	
	//Controller constants
	public static class Controller
	{
		//Controller axes constants
		public static class Axes
		{
			public static final int xDrive = 0, yDrive = 1;
		}
	}
	
	//Motor controller constants
	public static class MotorControllers
	{
		public static final int leftDrive = 0, rightDrive = 1;
	}
}
