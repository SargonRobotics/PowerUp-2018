package org.usfirst.frc.team2335.robot.auto;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class AutoDrive extends PIDCommand
{
	private int _encoderCount;
	
	private static double distance = 100, speed = 0.4;
	
	private static double kP = (speed / distance), kI = 0.0, kD = 0.0;
	
    public AutoDrive()
    {
        super("EncoderPID", kP, kI, kD);
        
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}
}
