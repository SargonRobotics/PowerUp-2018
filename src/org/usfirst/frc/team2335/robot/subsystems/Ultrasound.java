package org.usfirst.frc.team2335.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Ultrasound extends Subsystem
{
	Ultrasonic sensor;
	
	public Ultrasound()
	{
		sensor = new Ultrasonic(1, 0);
		
		//TODO: Test automatic mode
		sensor.setAutomaticMode(true);
	}
	
	public double getDistance()
	{
		return sensor.getRangeMM();
	}
	
    public void initDefaultCommand()
    {
    	
    }
}

