package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.OI;
import org.usfirst.frc.team3255.robot.RobotMap;
import org.usfirst.frc.team3255.robot.RobotPreferences;
import org.usfirst.frc.team3255.robot.commands.DriveArcade;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

/**
 *
 */
public class Drivetrain extends PIDSubsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	boolean isLowGear = true;
	
	//Accelerometer
	Accelerometer accel = null;
	
	//Motor Controllers
	CANTalon leftTalon = null;
	CANTalon rightTalon = null;
	
	//Solenoids
	DoubleSolenoid shiftSolenoid = null;
	
	//Encoders
	public Encoder encoder = null;
	
	RobotDrive robotDrive = null;
	
    public Drivetrain() {
		super(1.0, 0.0, 0.0);
		
		init();
	}

	public Drivetrain(String name) {
		super(name, 1.0, 0.0, 0.0);
		
		init();
	}

	public void init() {
		
		leftTalon = new CANTalon(RobotMap.DRIVETRAIN_LEFT_TALON);
		rightTalon = new CANTalon(RobotMap.DRIVETRAIN_RIGHT_TALON);
		
		accel = new BuiltInAccelerometer();
		
		robotDrive = new RobotDrive(leftTalon, rightTalon);
		
		robotDrive.setSafetyEnabled(false);
		
		encoder = new Encoder(RobotMap.DRIVETRAIN_ENCODER_CHANNEL_A,
				RobotMap.DRIVETRAIN_ENCODER_CHANNEL_B);
		
		shiftSolenoid = new DoubleSolenoid(RobotMap.DRIVETRAIN_SHIFT_HI_SOLENOID,
				RobotMap.DRIVETRAIN_SHIFT_LOW_SOLENOID);
		shiftLo();
		
		// LiveWindow.addActuator("Drivetrain", "Left Motor", (LiveWindowSendable) leftTalon);
		LiveWindow.addSensor("Drivetrain", "Encoder", encoder);
		LiveWindow.addActuator("Drivetrain", "PID Controller", this.getPIDController());
		
		this.updatePIDParameters();
	}
	
	public void arcadeDrive() {
		// negate the drive axis so that pushing stick forward is +1
		double moveSpeed = -OI.driverStick.getRawAxis(RobotMap.AXIS_ARCADE_MOVE);
		double rotateSpeed = -OI.driverStick.getRawAxis(RobotMap.AXIS_ARCADE_ROTATE);
		robotDrive.arcadeDrive(moveSpeed, rotateSpeed);
		
		if (isLowGear && (getEncoderVelocity() > RobotPreferences.shiftHi())) {
			shiftHi();	
		}
		else if (!isLowGear && (getEncoderVelocity() < RobotPreferences.shiftLo())) {
			shiftLo();
		}
	}
	
	public double getEncoderVelocity(){
		return encoder.getRate();
	}
	
	public double getEncoderPosition(){
		return encoder.getDistance();
	}
	
	public boolean isLo() {
		return isLowGear;
	}
	
	public void shiftLo(){
		shiftSolenoid.set(DoubleSolenoid.Value.kReverse);
		isLowGear = true;
	}
	
	public void shiftHi(){
		shiftSolenoid.set(DoubleSolenoid.Value.kForward);
		isLowGear = false;
	}
	
	public void setSpeed(double s) {
		leftTalon.set(s);
		rightTalon.set(-s);
	}
	
	public double getAccelX() {
		return accel.getX();
	}
	
	public double getAccelY() {
		return accel.getY();
	}
	
	public double getAccelZ() {
		return accel.getZ();
	}
	
	public double getSpeed() {
		return leftTalon.get();
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveArcade());
    }

	public void updatePIDParameters() {
		double p = RobotPreferences.p();
		double i = RobotPreferences.i();
		double d = RobotPreferences.d();
		this.getPIDController().setPID(p, i, d);
		this.setSetpoint(RobotPreferences.setPoint());
		encoder.setDistancePerPulse(RobotPreferences.distancePerPulse());
	}
	
	@Override
	protected double returnPIDInput() {	
		return getEncoderPosition();
	}

	@Override
	protected void usePIDOutput(double output) {
		setSpeed(output * (RobotPreferences.PIDRatio()));	
	}
}

