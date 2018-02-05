package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem
{	
	Victor hookMotor, climbMotor;

	public Climber()
	{
		hookMotor = new Victor(Robot.HOOK_MOTOR);
		climbMotor = new Victor(Robot.CLIMB_MOTOR);
	}
    
	public void moveHook()
	{
		hookMotor.set(1);
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

