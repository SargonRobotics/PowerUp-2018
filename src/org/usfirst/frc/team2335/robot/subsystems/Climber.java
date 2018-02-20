package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem
{	
	Victor hookMotor, climbMotor;

	public Climber()
	{
		hookMotor = new Victor(RobotMap.MotorControllers.hookMotor);
		climbMotor = new Victor(RobotMap.MotorControllers.climbWinch);
	}
    
	public void moveHook(double speed)
	{
		hookMotor.set(speed);
	}
	
	public void stopHook()
	{
		hookMotor.stopMotor();
	}
	
	public void climb()
	{
		climbMotor.set(1);
	}
	
	public void stopClimb()
	{
		climbMotor.stopMotor();
	}

    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

