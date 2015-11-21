package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Telemetry extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Telemetry() {
		super();
		// TODO Auto-generated constructor stub
		init();
	}

	public Telemetry(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		init();
	}

	public void init() {
		SmartDashboard.putData("Drive Forward", new DriveForward());
		SmartDashboard.putData("Drive Reverse", new DriveReverse());
		SmartDashboard.putData("Drive Stop", new DriveStop());
		SmartDashboard.putData("Enable PID", new EnablePID());
		SmartDashboard.putData("Disable PID", new DisablePID());
	}
	
	public void update() {
		SmartDashboard.putNumber("Accel X", CommandBase.drivetrain.getAccelX());
		SmartDashboard.putNumber("Accel Y", CommandBase.drivetrain.getAccelY());
		SmartDashboard.putNumber("Accel Z", CommandBase.drivetrain.getAccelZ());
		SmartDashboard.putNumber("Drive Speed", CommandBase.drivetrain.getSpeed());
		SmartDashboard.putNumber("Encoder Velocity", CommandBase.drivetrain.getEncoderVelocity());
		SmartDashboard.putNumber("Encoer Position", CommandBase.drivetrain.getEncoderPosition());
		SmartDashboard.putBoolean("Is Low", CommandBase.drivetrain.isLo());
		SmartDashboard.putBoolean("PID Enabled", CommandBase.drivetrain.getPIDController().isEnable());
		//SmartDashboard.getBoolean("Is Low", CommandBase.drivetrain.isLo());
		
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TelemetryUpdate());
    }
}

