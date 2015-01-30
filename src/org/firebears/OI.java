// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.firebears;

import org.firebears.commands.*;
import org.firebears.commands.drive.DriveToDistanceCommand;
import org.firebears.commands.drive.ForwardCommand;
import org.firebears.commands.drive.StrafeCommand;
import org.firebears.commands.gripper.GrabberCommand;
import org.firebears.commands.lights.LightChangeCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public Joystick joystickZero;
	public Joystick joystickLift;
	public DigitalInput scoringPlatformSensor;
	public DigitalInput autoSelect1;
	public DigitalInput autoSelect2;
	public DigitalInput autoSelect3;
	public DigitalInput autoSelect4;
    
	public JoystickButton forwardbutton;
	public JoystickButton backwardbutton;
	public JoystickButton stopbutton;
	public JoystickButton strafeleft;
	public JoystickButton straferight;

	public JoystickButton openGrabbers;
	public JoystickButton closeGrabbers;

	public OI() {
		joystickZero = new Joystick(0);
		joystickLift = new Joystick(1);

		scoringPlatformSensor = new DigitalInput(0);
		autoSelect1 = new DigitalInput(1);
		autoSelect2 = new DigitalInput(2);
		autoSelect3 = new DigitalInput(3);
		autoSelect4 = new DigitalInput(4);
		
		openGrabbers = new JoystickButton(joystickLift, 1);
		openGrabbers.whenPressed(new GrabberCommand(true));

		closeGrabbers = new JoystickButton(joystickLift, 1);
		closeGrabbers.whenPressed(new GrabberCommand(false));

		forwardbutton = new JoystickButton(joystickZero, 6);
		forwardbutton.whileHeld(new ForwardCommand(0.5));

		backwardbutton = new JoystickButton(joystickZero, 4);
		backwardbutton.whileHeld(new ForwardCommand(-0.5));

		stopbutton = new JoystickButton(joystickZero, 2);
		stopbutton.whileHeld(new ForwardCommand(0));

		strafeleft = new JoystickButton(joystickZero, 5);
		strafeleft.whileHeld(new StrafeCommand(0.5));

		straferight = new JoystickButton(joystickZero, 3);
		straferight.whileHeld(new StrafeCommand(-0.5));

		// SmartDashboard Buttons
		// SmartDashboard.putData("Autonomous Command", new
		// AutonomousCommand());
		SmartDashboard.putData("Change Lights", new LightChangeCommand(0,
				Robot.lights.RANDOM_ANIM));

	}

	public Joystick getJoystickZero() {
		return joystickZero;
	}
}