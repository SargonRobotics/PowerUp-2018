package org.usfirst.frc.team2335.robot;

import org.usfirst.frc.team2335.robot.commands.ShootCube;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OperatorInterface
{
	Joystick xbox;
	
	//Vaccuum Buttons
	JoystickButton toggleVacuum, quickRelease;
	
	//Pneumatics Buttons
	JoystickButton pushCubeButton, aimLow, aimHigh;
		
	public OperatorInterface()
	{
		//Joystick definition
		xbox = new Joystick(0);
		
		//JoystickButton definitions
		toggleVacuum = new JoystickButton(xbox, RobotMap.Controller.Buttons.vaccuumToggle);
		pushCubeButton = new JoystickButton(xbox, RobotMap.Controller.Buttons.shoot);
		aimLow = new JoystickButton(xbox, RobotMap.Controller.Buttons.armAimLow);
		aimHigh = new JoystickButton(xbox, RobotMap.Controller.Buttons.armAimHigh);
		
		//Linking buttons to commands
		pushCubeButton.whenPressed(new ShootCube());
	}
	
	public double getAxis(int axis, double max)
	{
		return deadzone(xbox.getRawAxis(axis), max);
	}
	
	public boolean getButton(int button)
	{
		return xbox.getRawButton(button);
	}
	
	public boolean getButtonPressed(int button)
	{
		return xbox.getRawButtonPressed(button);
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
