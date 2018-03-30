package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class VacuumArm extends Subsystem
{
	//Vaccuum control
	Talon vaccuumMotor;
	
	//Pneumatics control
	Compressor airCompressor;
	Solenoid leftLaunch, rightLaunch;
	Solenoid lowerAimExtend, lowerAimRetract, upperAimExtend, upperAimRetract;
		
	//Iteration counter
	int loopCounts = 0;
	
	public VacuumArm()
	{
		//Compressor definition
		airCompressor = new Compressor();
		
		//Define motors for vaccuum
		vaccuumMotor = new Talon(RobotMap.MotorControllers.vaccuumMotor);
		
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
		setLowerArmExtended(false);
		setUpperArmExtended(true);
	}
	
	//Sets arm to lower aiming position
	public void switchArm()
	{		
		setLowerArmExtended(true);
		setUpperArmExtended(true);
	}
	
	//Sets arm to upper aiming position
	public void scaleArm()
	{
		setLowerArmExtended(true);
		setUpperArmExtended(false);
	}
	
	//Function to simplify solenoid logic for lower piston
	private void setLowerArmExtended(boolean isExtended)
	{
		lowerAimExtend.set(!isExtended);
		lowerAimRetract.set(isExtended);
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
		loopCounts++;
		
		double motorVal = (loopCounts <= 15) ? (loopCounts / 2) / ((loopCounts / 2) - 15) : 1;
		vaccuumMotor.set(motorVal);
	}
	
	//Stops the vaccuum motor
	public void stopVaccuum()
	{
		loopCounts = 0;
		vaccuumMotor.stopMotor();
	}
	
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

