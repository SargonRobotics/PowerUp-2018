package org.usfirst.frc.team2335.robot;

import org.usfirst.frc.team2335.robot.commands.teleop.Climb;
import org.usfirst.frc.team2335.robot.commands.teleop.MoveHook;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OperatorInterface
{
	Joystick xbox;
	JoystickButton climbButton, hookUp, hookDown;
	
	public OperatorInterface()
	{
		xbox = new Joystick(0);
		
		climbButton = new JoystickButton(xbox, Robot.CLIMB_BUTTON);
		hookUp = new JoystickButton(xbox, Robot.HOOK_UP_BUTTON);
		hookDown = new JoystickButton(xbox, Robot.HOOK_DOWN_BUTTON);
		
		
		//Commands
		
		climbButton.whileHeld(new Climb(1.0));
		
		hookUp.whileHeld(new MoveHook(1.0));
		hookDown.whileHeld(new MoveHook(-1.0));
	}
	
	public double getAxis(int axis, double max)
	{
		return deadzone(xbox.getRawAxis(axis), max);
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
