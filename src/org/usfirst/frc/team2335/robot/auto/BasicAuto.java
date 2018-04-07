package org.usfirst.frc.team2335.robot.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BasicAuto extends CommandGroup
{
    public BasicAuto()
    {
    	addSequential(new VacuumDelay());
    	addSequential(new AutoSimpleDrive());
    }
}
