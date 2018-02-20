package org.usfirst.frc.team2335.robot;

import org.usfirst.frc.team2335.robot.commands.teleop.Climb;
import org.usfirst.frc.team2335.robot.commands.teleop.MoveHook;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OperatorInterface
{
	Joystick mainDrive, coDrive;
	JoystickButton climbButton, hookUp, hookDown;
	
	public OperatorInterface()
	{
		mainDrive = new Joystick(0);
		coDrive = new Joystick(1);
		
		climbButton = new JoystickButton(mainDrive, RobotMap.Controller.Buttons.climbButton);
		hookUp = new JoystickButton(mainDrive, RobotMap.Controller.Buttons.hookUp);
		hookDown = new JoystickButton(mainDrive, RobotMap.Controller.Buttons.hookDown);
		
		
		//Commands
		
		climbButton.whileHeld(new Climb());
		
		hookUp.whileHeld(new MoveHook(true));
		hookDown.whileHeld(new MoveHook(false));
	}
	
	public double getAxis(int axis, double max)
	{
		return deadzone(mainDrive.getRawAxis(axis), max);
	}
	
	private double deadzone(double amount, double max) //Creates a deadzone for the axes of the controller
	{
    	//If the value from the controller is less than the deadzone value then it zeros out
    	//If not it subtracts the deadzone from the controller value
		amount = -(Math.abs(amount) <= RobotMap.deadzone ? 0 : (amount = (amount < 0) ? amount : amount));
		
		//Multiplies the controller value by the slope made from (y2 - y1) / (x2 - x1)
		return ((max - 0) / ((1 - RobotMap.deadzone) - 0) * (amount - 0));
	}
}
