package org.firebears.commands.lights;

import edu.wpi.first.wpilibj.command.Command;
import org.firebears.Robot;

/**
 * Command For Changing A Strip (p_which) to a different animation (p_anim)
 */
public class LightChangeCommand extends Command {

	String which;
	String anim;

	public LightChangeCommand(String p_which, String p_anim) {
		requires(Robot.lights);
		which = p_which;
		anim = p_anim;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.lights.setStrip(which, anim);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

}
