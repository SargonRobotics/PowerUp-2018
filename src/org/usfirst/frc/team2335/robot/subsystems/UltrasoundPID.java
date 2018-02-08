package org.usfirst.frc.team2335.robot.subsystems;

import org.usfirst.frc.team2335.robot.Robot;
import org.usfirst.frc.team2335.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class UltrasoundPID extends PIDSubsystem
{
	AnalogInput sensor;
	
	static double error = 3.0, speed = 0.7;
	private final double scaleFactor = 3.43;
	
    public UltrasoundPID()
    {
        super("Ultrasound", (speed / error), 0.0, 0.0);
        
        sensor = new AnalogInput(RobotMap.Sensors.ultrasoundAnalog);
        setSetpoint(0.0);
    }
    
    public void enable()
    {
    	enable();
    }
    
    public void disable()
    {
    	disable();
    }

    public void initDefaultCommand()
    {
    	
    }
    
    public double getDistance() {
    	return returnPIDInput();
    }
    
    /*
     * Returns distance to accuracy of 1.2 inches
     * 
     */
    protected double returnPIDInput()
    {
    	double currentUltraVal = Math.round(sensor.getAverageVoltage() * scaleFactor * 10);
		currentUltraVal /= 10;
		
		return currentUltraVal;
    }

    protected void usePIDOutput(double output)
    {
        Robot.drive.drive(output, 0.0);
    }
}
