// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.firebears.subsystems;

import org.firebears.RobotMap;
import org.firebears.commands.*;
import org.firebears.sensors.HeightSensor;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Lift extends PIDSubsystem {
	public HeightSensor heightSensor;
	SpeedController liftTalon = RobotMap.lifttalon;
	public double LIFT_PICKUP_HEIGHT;
	public double LIFT_0_HEIGHT;
	public double LIFT_1_HEIGHT;
	public double LIFT_2_HEIGHT;
	public double LIFT_3_HEIGHT;

	// hardcode these to inches wanted above "Zero" for each height
	private final double INCHES_TOTE_PICKUP = 0.0;
	private final double INCHES_TOTE_1 = 0.0;
	private final double INCHES_TOTE_2 = 0.0;
	private final double INCHES_TOTE_3 = 0.0;

	public double addStep = 0;

	public boolean enable_motor = true;

	private static double m_P = 1.0;
	private static double m_I = 1.0;
	private static double m_D = 1.0;

	// Initialize your subsystem here
	public Lift() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
		super("Lift", m_P, m_I, m_D);
		setAbsoluteTolerance(0.2);
		getPIDController().setContinuous(false);
		LiveWindow.addActuator("Lift", "PIDSubsystem Controller",
				getPIDController());
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID

		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
		heightSensor = new HeightSensor();
	}

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;

		return heightSensor.getHeight();
	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);

		// if statement to allow turning off of lift motor in smartdashboard
		if (enable_motor) {
			liftTalon.pidWrite(output);
		}
	}

	public void setSetpointInches(String setpoint) {

		if (setpoint.equals("Lift_Pickup")) {
			// set pid to pickup height
			// set to inches above "ground height"

			// addStep will be 0 or 6, depending on if the switch is flicked
			setSetpoint(INCHES_TOTE_PICKUP + addStep);
		} else if (setpoint.equals("Lift_Tote_0")) {
			setSetpoint(INCHES_TOTE_PICKUP + addStep);
		} else if (setpoint.equals("Lift_Tote_1")) {
			setSetpoint(INCHES_TOTE_1 + addStep);
		} else if (setpoint.equals("Lift_Tote_2")) {
			setSetpoint(INCHES_TOTE_2 + addStep);
		} else if (setpoint.equals("Lift_Tote_3")) {
			setSetpoint(INCHES_TOTE_3 + addStep);
		}
	}

	public void setMotor(boolean enable) {
		// switches morot to be off if on, or on if off
		enable_motor = enable;
	}
}
