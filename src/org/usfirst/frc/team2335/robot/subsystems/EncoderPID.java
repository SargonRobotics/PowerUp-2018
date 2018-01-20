package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class EncoderPID extends PIDSubsystem
{
	Encoder cimEncoder;
	
	//TODO: Fine tune these, currently not accurate what so ever
	private static double speed = 1.0, error = 2000;
	
	class EncoderCounts
	{
		//TODO: Put encoder counts for different targets
	}
	
    public EncoderPID()
    {
    	super("Cim Encoder", (speed / error), 0.0, 0.0);
    	
    	cimEncoder = new Encoder(Robot.ENCODER_A, Robot.ENCODER_B);
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
    	//TODO: Convert from encoder count to feet here and store that as a variable that can be used by the drive class
    	//Hopefully if we aren't retards we don't need to use gyro correction
    	
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
