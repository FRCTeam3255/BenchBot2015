package org.usfirst.frc.team3255.robot.commands;

import org.usfirst.frc.team3255.robot.OI;
import org.usfirst.frc.team3255.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class CommandBase extends Command {
	
	public static final Drivetrain drivetrain = new Drivetrain();
    public static final Telemetry telemetry = new Telemetry();
	public static OI oi;
	
    public CommandBase() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

	public static void init() {
		// TODO Auto-generated method stub
		oi = new OI();
		
	}
}
