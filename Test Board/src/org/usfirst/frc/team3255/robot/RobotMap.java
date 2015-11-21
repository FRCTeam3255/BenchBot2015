package org.usfirst.frc.team3255.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	//Controller Inputs
	public static final int DriverStick = 1;
	public static final int Manipulator_HID = 2;
	
	//Arcade Drive
	public static final int AXIS_ARCADE_MOVE = 1;
	public static final int AXIS_ARCADE_ROTATE = 2;
	
	//Canbus IDs
	public static final int DRIVETRAIN_LEFT_TALON = 0;
	public static final int DRIVETRAIN_RIGHT_TALON = 1;
	
	//Analog Inputs
	public static final int CLAW_POT = 0;
	
	//Solenoids
	public static final int DRIVETRAIN_SHIFT_HI_SOLENOID = 0;
	public static final int DRIVETRAIN_SHIFT_LOW_SOLENOID = 1;
	
	public static final int CLAW_SOLENOID_OPEN = 0;
	public static final int CLAW_SOLENOID_CLOSE = 1;
	public static final int CLAW_LIMITSWITCH = 0;
	public static final int CLAW_GYRO = 1;
	
	//DigitialInputs
	public static final int DRIVETRAIN_ENCODER_CHANNEL_A = 0;
	public static final int DRIVETRAIN_ENCODER_CHANNEL_B = 1;
	
}
