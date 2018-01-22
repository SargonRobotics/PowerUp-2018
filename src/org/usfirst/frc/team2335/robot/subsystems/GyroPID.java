package org.usfirst.frc.team2335.robot.subsystems;

import edu.wpi.first.wpilibj.ADXL362;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class GyroPID extends PIDSubsystem
{
	ADXL362 accelerometer;
	ADXRS450_Gyro gyro;

	static double error = 2.5, speed = 0.1;
	
    // Initialize your subsystem here
    public GyroPID()
    {
    	super("Gyro", (speed / error), 0.0, 0.0);
        
    	gyro = new ADXRS450_Gyro();
    }

    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput()
    {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return gyro.getAngle();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
