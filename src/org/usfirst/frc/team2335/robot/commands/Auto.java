package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

//Fuck me, no one brought the sensors we're so screwed

public class Auto extends Command
{
    public Auto()
    {
        requires(Robot.drive);
        //requires(Robot.vacuumArm);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	setTimeout(3.0);
    	//Robot.vacuumArm.startVaccuum();
    	//Robot.vacuumArm.groundArm();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	Robot.drive.drive(0.7, 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	end();
    }
}
