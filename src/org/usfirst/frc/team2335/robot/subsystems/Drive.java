package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drive extends Subsystem
{
	Victor leftMotor, rightMotor;
	
	DifferentialDrive drive;
		
	public Drive()
	{
		//Motor controller definitions
		leftMotor = new Victor(RobotMap.MotorControllers.leftDrive);
		rightMotor = new Victor(RobotMap.MotorControllers.rightDrive);
		
		leftMotor.setInverted(true);
	
		
		//Drive controller definition
		drive = new DifferentialDrive(leftMotor, rightMotor);
	}
	
	public void drive(double moveVal, double rotateVal)
	{			
		drive.arcadeDrive(moveVal, -rotateVal);
	}
	
	public void stop()
	{
		drive.arcadeDrive(0,0);
	}
	
    public void initDefaultCommand()
    {
     
    }
}

