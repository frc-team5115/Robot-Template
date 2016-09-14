package com.team5115.robot;

import com.team5115.Constants;

import edu.wpi.first.wpilibj.Joystick;

public class InputManager {
	
	static Joystick joy = new Joystick(0);
	
	public static double getX() {
		return treatAxis(joy.getRawAxis(Constants.AXIS_X));
	}
	
	public static double getY() {
		return treatAxis(joy.getRawAxis(Constants.AXIS_Y));
	}
	
	public static double getThrottle() {
		// Joystick give 1 to -1 but we need 0 to 1
		return (1 - joy.getThrottle()) / 2;
	}

	public static boolean quickTurn() {
		return joy.getRawButton(Constants.BUTTON_QUICK_TURN);
	}
	
	// Handles squaring and deadband
	public static double treatAxis(double val) {
		if (val > 0)
			val = Math.pow(val, 2);
		else
			val = -Math.pow(val, 2);

		if (Math.abs(val) < Constants.JOYSTICK_DEADBAND)
			val = 0;

		return val;
	}

}
