package org.usfirst.frc.team2335.robot.commands.groups;

import org.usfirst.frc.team2335.robot.commands.autonomous.DriveForward;
import org.usfirst.frc.team2335.robot.commands.autonomous.DriveTo;
import org.usfirst.frc.team2335.robot.commands.autonomous.Turn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveSide extends CommandGroup
{
    public AutoDriveSide(char robotSide)
    {	
    	//Determines direction of turn depending on robot side(left = -1, right = 1)
    	int turn = robotSide == 'L' ? -1 : 1;

    	addSequential(new DriveForward(robotSide));
    	addSequential(new Turn(turn));
    	addSequential(new DriveTo());
    	
    	// Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
