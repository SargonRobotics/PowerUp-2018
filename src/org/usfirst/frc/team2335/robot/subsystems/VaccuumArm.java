package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class VaccuumArm extends Subsystem
{
	//Vaccuum control
	Talon vaccuumMotor;
	Servo quickRelease;
	
	//Pneumatics control
	Compressor airCompressor;
	
	//TODO: Add solenoids
	
	public VaccuumArm()
	{
		vaccuumMotor = new Talon(Robot.VACCUUM_MOTOR);
		quickRelease = new Servo(Robot.RELEASE_SERVO);
	}
	
	public void startVaccuum()
	{
		vaccuumMotor.set(1);
	}
	
	public void stopVaccuum()
	{
		vaccuumMotor.set(0);
	}
	
	public void closeValve()
	{
		//TODO: Find appropriate angle
		quickRelease.set(180);
	}
	
	public void releaseValve()
	{
		//TODO: Find appropriate angle
		quickRelease.set(140);
	}
	
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

