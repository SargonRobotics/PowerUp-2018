package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.Robot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class Drive extends Subsystem
{
	Victor frontLeft, backLeft, frontRight, backRight;
	
	MecanumDrive drive;
	
	public Drive()
	{
		//Motor controller definitions
		frontLeft = new Victor(Robot.FRONT_LEFT_MOTOR);
		backLeft = new Victor(Robot.BACK_LEFT_MOTOR);
		frontRight = new Victor(Robot.FRONT_RIGHT_MOTOR);
		backRight = new Victor(Robot.BACK_RIGHT_MOTOR);
		
		//Drive controller definition
		drive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
	}
	
	public void drive(double y, double x, double z)
	{
		drive.driveCartesian(y, x, z);
	}
	
    public void initDefaultCommand()
    {
     
    }
}

