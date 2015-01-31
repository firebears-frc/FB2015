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

import org.firebears.Robot;
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

	// top of the grabbers
	private final double INCHES_GRABBER_TOP = 7.0;
	private final double INCHES_TOTE_PICKUP = 8.5 - INCHES_GRABBER_TOP;
	private final double INCHES_TOTE_PICKUP_1 = 21.5 - INCHES_GRABBER_TOP;
	private final double INCHES_TOTE_PICKUP_2 = 33.5 - INCHES_GRABBER_TOP;
	private final double INCHES_TOTE_PICKUP_3 = 46.0 - INCHES_GRABBER_TOP;

	private final double INCHES_TOTE_PUTDOWN = (INCHES_TOTE_PICKUP + 3.0)
			- INCHES_GRABBER_TOP;
	private final double INCHES_TOTE_PUTDOWN_1 = (INCHES_TOTE_PICKUP_1 + 3.0)
			- INCHES_GRABBER_TOP;
	private final double INCHES_TOTE_PUTDOWN_2 = (INCHES_TOTE_PICKUP_2 + 3.0)
			- INCHES_GRABBER_TOP;
	private final double INCHES_TOTE_PUTDOWN_3 = (INCHES_TOTE_PICKUP_3 + 3.0)
			- INCHES_GRABBER_TOP;

	public double addStep = 0;

	public boolean enable_motor = true;

	private static double m_P = 1.0;
	private static double m_I = 0.0;
	private static double m_D = 0.0;

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
		// set pid to pickup height
		// set to inches above "ground height"

		boolean picking_up = Robot.grabber.isOpen();
		// as opposed to droping
		if (picking_up) {
			if (setpoint.equals("Lift_Pickup")) {

				// addStep will be 0 or 6, depending on if the switch is flicked
				setSetpoint(INCHES_TOTE_PICKUP + addStep);
			} else if (setpoint.equals("Lift_Tote_0")) {
				setSetpoint(INCHES_TOTE_PICKUP + addStep);
			} else if (setpoint.equals("Lift_Tote_1")) {
				setSetpoint(INCHES_TOTE_PICKUP_1 + addStep);
			} else if (setpoint.equals("Lift_Tote_2")) {
				setSetpoint(INCHES_TOTE_PICKUP_2 + addStep);
			} else if (setpoint.equals("Lift_Tote_3")) {
				setSetpoint(INCHES_TOTE_PICKUP_3 + addStep);
			}
		} else {
			if (setpoint.equals("Lift_Pickup")) {
				setSetpoint(INCHES_TOTE_PUTDOWN + addStep);
			} else if (setpoint.equals("Lift_Tote_0")) {
				setSetpoint(INCHES_TOTE_PUTDOWN + addStep);
			} else if (setpoint.equals("Lift_Tote_1")) {
				setSetpoint(INCHES_TOTE_PUTDOWN_1 + addStep);
			} else if (setpoint.equals("Lift_Tote_2")) {
				setSetpoint(INCHES_TOTE_PUTDOWN_2 + addStep);
			} else if (setpoint.equals("Lift_Tote_3")) {
				setSetpoint(INCHES_TOTE_PUTDOWN_3 + addStep);
			}
		}
	}

	public void setMotor(boolean enable) {
		// switches motor to be off if on, or on if off
		enable_motor = enable;
	}
}
