package org.usfirst.frc.team2335.robot.commands.autonomous;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {
	
	private double _turnVal;
	private double _turnPower;

    public Turn(int turnVal) 
    {
        _turnVal = turnVal > 0 ? 90 : -90;
        
        _turnPower = turnVal > 0 ? 0.5 : -0.5;
        requires(Robot.drive);
        requires(Robot.gyroPID);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gyroPID.enable();
    	Robot.gyroPID.setSetpoint(_turnVal);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.drive(0.1, _turnPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.gyroPID.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gyroPID.disable();
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
