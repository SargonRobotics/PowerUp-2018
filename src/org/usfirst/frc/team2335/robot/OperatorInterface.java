package org.usfirst.frc.team2335.robot;

import org.usfirst.frc.team2335.robot.commands.QuickRelease;
import org.usfirst.frc.team2335.robot.commands.ToggleVaccuum;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OperatorInterface
{
	Joystick xbox;
	JoystickButton toggleVaccuum, quickRelease;
	
	public OperatorInterface()
	{
		xbox = new Joystick(0);
		
		toggleVaccuum = new JoystickButton(xbox, Robot.VACCUUM_BUTTON);
		quickRelease = new JoystickButton(xbox, Robot.RELEASE_BUTTON);
		
		toggleVaccuum.toggleWhenPressed(new ToggleVaccuum());
		quickRelease.whenPressed(new QuickRelease());
	}
	
	public double getAxis(int axis, double max)
	{
		return deadzone(xbox.getRawAxis(axis), max);
	}
	
	private double deadzone(double amount, double max) //Creates a deadzone for the axes of the controller
	{
    	//If the value from the controller is less than the deadzone value then it zeros out
    	//If not it subtracts the deadzone from the controller value
		amount = -(Math.abs(amount) <= Robot.DEADZONE ? 0 : (amount = (amount < 0) ? amount : amount));
		
		//Multiplies the controller value by the slope made from (y2 - y1) / (x2 - x1)
		return ((max - 0) / ((1 - Robot.DEADZONE) - 0) * (amount - 0));
	}
}
