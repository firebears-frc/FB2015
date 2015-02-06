// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.firebears.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.firebears.Robot;

/**
 *
 */
public class  DriveCommand extends Command {

    public DriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chassis);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double x = Robot.oi.getJoystickZero().getRawAxis(0);         // strafe left/right
		double y = Robot.oi.getJoystickZero().getRawAxis(1);         // forward / backwards
		double rotation = Robot.oi.getJoystickZero().getRawAxis(2);  
		double rotationMultiplier = 0.6;
//		rotationMultiplier = (1 - Robot.oi.getJoystickZero().getThrottle()) / 2.0;
//		SmartDashboard.putNumber("rotationMultiplier", rotationMultiplier);
		
		x = Math.signum(x) * x * x;
		y = Math.signum(y) * y * y;
		rotation = Math.signum(rotation) * removeDeadband(rotation * rotation, 0.2) * rotationMultiplier;
		
		Robot.chassis.mechanumDrive( x, y, rotation);	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    
    /**
     * Returns zero for all input values from -d to d.
     * 
     * @param x  Input value in the range -1.0 to 1.0.
     * @param d dead area around zero.
     * @return  Output value in the range -1.0 to 1.0;
     */
    protected double removeDeadband(double x, double d) {
    	if (x >= -1 * d && x <= d) {
    		return 0.0;
    	} else if (x > d) {
    		return (x - d) / (1 - d);
    	} else {
    		return (x + d) / (1 - d);
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}