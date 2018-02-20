package org.usfirst.frc.team2335.robot;

import org.usfirst.frc.team2335.robot.commands.ShootCube;
import org.usfirst.frc.team2335.robot.commands.teleop.Climb;
import org.usfirst.frc.team2335.robot.commands.teleop.MoveHook;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OperatorInterface
{
	Joystick mainDrive, coDrive;
	JoystickButton climbButton, hookUp, hookDown;
	
	//Vaccuum Buttons
	JoystickButton toggleVacuum, quickRelease;
	
	//Pneumatics Buttons
	JoystickButton pushCubeButton, aimLow, aimHigh;
		
	public OperatorInterface()
	{
		mainDrive = new Joystick(0);
		coDrive = new Joystick(1);
		
		//JoystickButton definitions
		toggleVacuum = new JoystickButton(mainDrive, RobotMap.Controller.Buttons.vaccuumToggle);
		pushCubeButton = new JoystickButton(mainDrive, RobotMap.Controller.Buttons.shoot);
		aimLow = new JoystickButton(mainDrive, RobotMap.Controller.Buttons.armAimLow);
		aimHigh = new JoystickButton(mainDrive, RobotMap.Controller.Buttons.armAimHigh);
		
		climbButton = new JoystickButton(coDrive, RobotMap.Controller.Buttons.climbButton);
		hookUp = new JoystickButton(coDrive, RobotMap.Controller.Buttons.hookUp);
		hookDown = new JoystickButton(coDrive, RobotMap.Controller.Buttons.hookDown);
		
		
		//Linking buttons to commands
		pushCubeButton.whenPressed(new ShootCube());
		
		climbButton.whileHeld(new Climb());
		hookUp.whileHeld(new MoveHook(true));
		hookDown.whileHeld(new MoveHook(false));
	}
	
	public double getAxis(int axis, double max)
	{
		return deadzone(mainDrive.getRawAxis(axis), max);
	}
	
	public boolean getButton(int controller, int button)
	{
		return controller == 0 ? mainDrive.getRawButton(button) : coDrive.getRawButton(button);
	}
	
	public boolean getButtonPressed(int controller, int button)
	{
		return controller == 0 ? mainDrive.getRawButtonPressed(button) : coDrive.getRawButtonPressed(button);
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
