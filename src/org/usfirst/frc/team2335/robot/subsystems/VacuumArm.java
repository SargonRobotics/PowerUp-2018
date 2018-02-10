package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class VacuumArm extends Subsystem
{
	//Vaccuum control
	Talon vaccuumMotor;
	Servo quickRelease;
	
	//Pneumatics control
	Compressor airCompressor;
	Solenoid leftLaunch, rightLaunch;
	Solenoid lowerAimExtend, lowerAimRetract, upperAimExtend, upperAimRetract;
	
	public VacuumArm()
	{
		//Define motors for vaccuum
		vaccuumMotor = new Talon(RobotMap.MotorControllers.vaccuumMotor);
		quickRelease = new Servo(RobotMap.Servos.valveServo);
		
		//Define solenoids
		leftLaunch = new Solenoid(RobotMap.Solenoids.leftLaunch);
		rightLaunch = new Solenoid(RobotMap.Solenoids.rightLaunch);
		
		lowerAimExtend = new Solenoid(RobotMap.Solenoids.lowerAimExtend);
		lowerAimRetract = new Solenoid(RobotMap.Solenoids.lowerAimRetract);
		
		upperAimExtend = new Solenoid(RobotMap.Solenoids.upperAimExtend);
		upperAimRetract = new Solenoid(RobotMap.Solenoids.upperAimRetract);
	}
	
	//Sets both solenoids for the pistons to true, allowing them to contract
	public void launchCube()
	{
		leftLaunch.set(true);
		rightLaunch.set(true);
	}
	
	//Pushes the pistons back out
	public void resetLaunch()
	{
		leftLaunch.set(false);
		rightLaunch.set(false);
	}
	
	//Sets arm to ground position
	public void groundArm()
	{	
		setLowerArmExtended(true);
		setUpperArmExtended(false);
	}
	
	//Sets arm to lower aiming position
	public void switchArm()
	{		
		setLowerArmExtended(false);
		setUpperArmExtended(false);
	}
	
	//Sets arm to upper aiming position
	public void scaleArm()
	{
		setLowerArmExtended(false);
		setUpperArmExtended(true);
	}
	
	//Function to simplify solenoid logic for lower piston
	private void setLowerArmExtended(boolean isExtended)
	{
		lowerAimExtend.set(isExtended);
		lowerAimRetract.set(!isExtended);
	}
	
	//Function to simplify solenoid logic for upper piston
	private void setUpperArmExtended(boolean isExtended)
	{
		upperAimExtend.set(isExtended);
		upperAimRetract.set(!isExtended);
	}
	
	//Turns the vaccuum motor to full speed
	public void startVaccuum()
	{
		vaccuumMotor.set(1);
	}
	
	//Stops the vaccuum motor
	public void stopVaccuum()
	{
		vaccuumMotor.stopMotor();
	}
	
	//Closes the quick release valve
	public void closeValve()
	{
		//TODO: Find appropriate angle
		quickRelease.set(180);
	}
	
	//Opens the quick release valve
	public void releaseValve()
	{
		//TODO: Find appropriate angle
		quickRelease.set(140);
	}
	
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

