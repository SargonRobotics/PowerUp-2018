package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Ultrasound extends Subsystem
{	
	Ultrasonic sensor;
	
	private String allianceSides;
	private int objectsPassed = 0;
	private double previousUltraVal = 0, currentUltraVal = 0;
	
	private int objectsToPass = 0;
	private char frontSide = ' ';
	
	private char autoSide = ' ';
	
	public Ultrasound()
	{
		sensor = new Ultrasonic(Robot.PULSE_PIN, Robot.ECHO_PIN);
		sensor.setAutomaticMode(true);
		
		allianceSides = DriverStation.getInstance().getGameSpecificMessage();
	}
	
	public double getDistance()
	{
		currentUltraVal = sensor.getRangeInches() / 12;
		
		if(currentUltraVal - previousUltraVal > 3.0)
		{
			objectsPassed++;
		}
		
		previousUltraVal = currentUltraVal;
		
		return currentUltraVal;
	}
	
	public void setAutoSide(char side)
	{
		autoSide = side;
	}
	
	public void getDestination()
	{
		//If it's in the center
		if(autoSide == 'C')
		{
			//Returns first character of color placement string
			frontSide = allianceSides.charAt(0);
		}
		else //If it's on the left or right
		{	
			for(int i = 0; i < allianceSides.length(); i++)
			{
				//Checks if it's on the correct side
				if(allianceSides.charAt(i) == autoSide)
				{
					objectsToPass = (i + 1);
					break;
				}
			}
		}
	}
	
	public boolean isAtTarget()
	{
		if(autoSide == 'C')
		{
			//TODO: Thing here
			return false;
		}
		else
		{
			return (objectsPassed == objectsToPass);
		}
	}
	
    public void initDefaultCommand()
    {
    	
    }
}

