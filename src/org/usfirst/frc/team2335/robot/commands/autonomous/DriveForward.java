package org.usfirst.frc.team2335.robot.commands.autonomous;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {

    public DriveForward(char side)
    {	
        requires(Robot.encoderPID);
        Robot.encoderPID.setEncoderCount(side);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	 Robot.encoderPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.encoderPID.onTarget();
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	Robot.encoderPID.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
