package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Ultrasound extends Subsystem
{	
	Ultrasonic sensor;
	
	public Ultrasound()
	{
		sensor = new Ultrasonic(Robot.PULSE_PIN, Robot.ECHO_PIN);
		
		//TODO: Test automatic mode
		sensor.setAutomaticMode(true);
	}
	
	public double getDistance()
	{
		return sensor.getRangeInches() / 12;
	}
	
    public void initDefaultCommand()
    {
    	
    }
}

