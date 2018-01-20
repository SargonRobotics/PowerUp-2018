package org.usfirst.frc.team2335.robot.subsystems;

import java.text.DecimalFormat;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Ultrasound extends Subsystem
{	
	AnalogInput sensor;
	
	private final double scaleFactor = 3.43;
	
	public Ultrasound()
	{
		sensor = new AnalogInput(Robot.ULTRASOUND_PIN);
	}
	
	public double getDistance()
	{
		double currentUltraVal = Math.round(sensor.getAverageVoltage() * scaleFactor * 10);
		currentUltraVal /= 10;
		
		return currentUltraVal;
	}
	
    public void initDefaultCommand()
    {
    	
    }
}