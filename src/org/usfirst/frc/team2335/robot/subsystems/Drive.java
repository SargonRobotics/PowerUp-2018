package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drive extends Subsystem
{
	Victor leftMotor, rightMotor;
	DifferentialDrive drive;
	
	//TODO: Add encoders
	Encoder rightEncoder;
		
	public Drive()
	{
		//Motor controller definitions
		leftMotor = new Victor(RobotMap.MotorControllers.leftDrive);
		rightMotor = new Victor(RobotMap.MotorControllers.rightDrive);

		//Drive controller definition
		drive = new DifferentialDrive(leftMotor, rightMotor);
		
		//Disables errors
		drive.setSafetyEnabled(false);
		
		//Encoders
		rightEncoder = new Encoder(RobotMap.Sensors.rightEncoderA, RobotMap.Sensors.rightEncoderB);
	}
	
	public void drive(double moveVal, double rotateVal)
	{		
		//Function that drives the robot
		//Turning is inverted, so I'm inverting in the code
		drive.arcadeDrive(-moveVal, -rotateVal);
	}
	
	public void stop()
	{
		drive.stopMotor();
	}
	
	public int getEncoderVal()
	{
		return rightEncoder.get();
	}
	
    public void initDefaultCommand()
    {
     
    }
}

