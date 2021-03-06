package org.firebears.subsystems;

import org.firebears.Robot;
import org.firebears.RobotMap;
import org.firebears.commands.drive.DriveCommand;
import org.firebears.sensors.sharpIRRange;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Subsystem for driving the robot.
 */
public class Chassis extends Subsystem {

	public int toteState = 0;
	public double approachSpeed = 0.0;
	public SpeedController front_left = RobotMap.chassis_front_left_controller;
	public SpeedController back_left = RobotMap.chassis_back_left_controller;
	public SpeedController front_right = RobotMap.chassis_front_right_controller;
	public SpeedController back_right = RobotMap.chassis_back_right_controller;
	boolean reversed = true;

	boolean fieldOriented = false;

	RobotDrive robot_drive = RobotMap.chassis_robot_drive;
	AnalogGyro drive_gyro = RobotMap.chassis_drive_gyro;

	public sharpIRRange leftsharpIRRange = RobotMap.leftsharpIRRange;
	public sharpIRRange rightsharpIRRange = RobotMap.rightsharpIRRange;
	public sharpIRRange leftArmsharpIRRange = RobotMap.leftArmsharpIRRange;
	public sharpIRRange rightArmsharpIRRange = RobotMap.rightArmsharpIRRange;
	
	public Chassis() {
		if (drive_gyro != null)
			drive_gyro.reset();
	}

	/**
	 * Drive the chassis mecanum wheels.
	 *
	 * @param strafe
	 *            x dimension speed, in the range -1.0 to 1.0.
	 * @param forward
	 *            y dimension movement, in the range -1.0 to 1.0.
	 * @param rotation
	 *            angular rotation, in the range -1.0 to 1.0.
	 */
	public void mechanumDrive(double strafe, double forward, double rotation) {
		double angle =
				((RobotMap.chassis_drive_gyro != null) && fieldOriented)
				? RobotMap.chassis_drive_gyro.getAngle()
				: 0.0;

		// double cosA = Math.cos(theta * (3.14159 / 180.0));
		// double sinA = Math.sin(theta * (3.14159 / 180.0));
		// strafe = strafe * cosA - forward * sinA;
		// forward = strafe * sinA + forward * cosA;

		// front_left.set(strafe + forward + rotation);
		// front_right.set((strafe + forward - rotation));
		// back_left.set(strafe - forward + rotation);
		// back_right.set((strafe - forward - rotation ));

		/*
		 * SmartDashboard.putNumber("frontLeft Talon .getEncVelocity",
		 * ((CANTalon) front_left).getEncVelocity());
		 * SmartDashboard.putNumber("backLeft Talon .getEncVelocity",
		 * ((CANTalon) back_left).getEncVelocity());
		 * SmartDashboard.putNumber("frontRight Talon .getEncVelocity",
		 * ((CANTalon) front_right).getEncVelocity());
		 * SmartDashboard.putNumber("backRight Talon .getEncVelocity",
		 * ((CANTalon) back_right).getEncVelocity());
		 */
		if (robot_drive != null)   {
			try {
				robot_drive.mecanumDrive_Cartesian(strafe,
//						(reversed ? -1 : 1) *
						forward,
						rotation,
						(reversed ? -1 : 1) * 0);
			} catch (Exception e) {
				System.err.println("ERROR: " + e);
				if (RobotMap.DEBUG)  { e.printStackTrace(); }
			}
		}
		Robot.lights.updateUnderglow(forward);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveCommand());
	}

	/**
	 * Set whether driving is oriented to the field, versus oriented to the
	 * robot. Setting this to 'true' means that we will use the gyro to
	 * determine which way is forward; forward on the joystick will always mean
	 * forward down the field.
	 */
	public void setFieldOriented(boolean b) {
		fieldOriented = b;
	}

	public boolean getFieldOriented() {
		return fieldOriented;
	}

	/**
	 * Our practice robot uses CAN Jaguars, while our competition robot uses CAN
	 * Talons. For some reason, the Talons are reversed with respect to the
	 * values inputted. This method can reverse the chassis, so the same code
	 * can run in both robots.
	 *
	 * @param b
	 *            whether the direction should be reversed.
	 */
	public void setReversed(boolean b) {
		reversed = b;
	}
}
