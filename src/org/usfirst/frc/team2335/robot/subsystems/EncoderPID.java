package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class EncoderPID extends PIDSubsystem
{
	Encoder cimEncoder;
	
	//TODO: Fine tune these, currently not accurate what so ever
	private static double speed = 1.0, error = 2000;
	
	private String alliancePlacements;
	
	private final int[] encoderCounts = new int[3];
	
    public EncoderPID()
    {
    	super("Cim Encoder", (speed / error), 0.0, 0.0);
    	
    	cimEncoder = new Encoder(Robot.ENCODER_A, Robot.ENCODER_B);
    	
    	alliancePlacements = DriverStation.getInstance().getGameSpecificMessage();
    	
    	//TODO: Put correct values
    	encoderCounts[0] = 100;
    	encoderCounts[1] = 200;
    	encoderCounts[2] = 300;
    }
    
    public void setEncoderCount(char robotSide)
    {
    	for(int i = 0; i < 3; i++)
    	{
    		if(alliancePlacements.charAt(i) == robotSide)
    		{
    			setSetpoint(encoderCounts[i]);
    			break;
    		}
    	}
    	
    	DriverStation.reportError("You're fucked", true);
    	setSetpoint(encoderCounts[0]);
    }
    
    
    
    public void enable()
    {
    	enable();
    }
    
    public void disable()
    {
    	disable();
    }
    
    public void reset()
    {
    	cimEncoder.reset();
    }
    
    
    public void initDefaultCommand()
    {
    	
    }

    protected double returnPIDInput()
    {
        return cimEncoder.getDistance();
    }

    protected void usePIDOutput(double output)
    {
    	Robot.drive.drive(output, 0.0);
    }
}
