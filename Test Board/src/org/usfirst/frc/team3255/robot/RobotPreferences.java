package org.usfirst.frc.team3255.robot;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {
	
	public static double shiftHi(){
		return Preferences.getInstance().getDouble("ShiftHigh", 5.0);
	}
	
	public static double shiftLo(){
		return Preferences.getInstance().getDouble("ShiftLow", 3.0);
	}
	
	public static double driveSensitivity(){
		return Preferences.getInstance().getDouble("DriveSensitivity", 1.0);
	}

	public static double p() {
		return Preferences.getInstance().getDouble("P", 0.0);
	}

	public static double i() {
		return Preferences.getInstance().getDouble("I", 0.0);
	}

	public static double d() {
		return Preferences.getInstance().getDouble("D", 0.0);
	}

	public static double setPoint() {
		return Preferences.getInstance().getDouble("SetPoint", 0.0);
	}

	public static double PIDRatio() {
		return Preferences.getInstance().getDouble("PIDRatio", 1.0);
	}

	public static double distancePerPulse() {
		return Preferences.getInstance().getDouble("DistancePerPulse", 0.1);
	}
}
