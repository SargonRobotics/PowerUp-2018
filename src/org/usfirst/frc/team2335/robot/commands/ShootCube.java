package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootCube extends Command
{
    public ShootCube()
    {
        requires(Robot.vacuumArm);
        
        //TODO: Find correct time
        setTimeout(3); //Stops the command after 3 seconds
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	Robot.vacuumArm.launchCube();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	Robot.vacuumArm.resetLaunch();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	end();
    }
}
