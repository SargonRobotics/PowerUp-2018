package org.usfirst.frc.team2335.robot.commands.teleop;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveHook extends Command
{
	final double absoluteSpeed = 1.0;
	double speed = 0;
	
    public MoveHook(boolean movingUp)
    {
    	this.speed = movingUp ? absoluteSpeed : absoluteSpeed * -1;
        requires(Robot.climber);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	Robot.climber.moveHook(this.speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.climber.stopHook();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
