package org.usfirst.frc.team2335.robot.commands;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetArm extends Command
{
	int _armState;
	
    public SetArm(int armState)
    {
    	//Stores which  state the arm should be in
        _armState = armState;
        
        requires(Robot.vaccuumArm);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	//Switch case for arm states
    	switch(_armState)
    	{
	    	case 0:
	    		Robot.vaccuumArm.switchArm();
	    		break;
	    		
	    	case 1:
	    		Robot.vaccuumArm.scaleArm();
	    		break;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	Robot.vaccuumArm.groundArm();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	end();
    }
}
