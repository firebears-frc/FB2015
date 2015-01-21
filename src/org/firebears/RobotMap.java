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
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.can.*;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon chassis_front_left;
    public static CANTalon chassis_back_left;
    public static CANTalon chassis_front_right;
    public static CANTalon chassis_back_right;
    public static RobotDrive chassis_robot_drive;
    public static Gyro chassis_drive_gyro;
    public static AnalogPotentiometer liftpot;
    public static SpeedController lifttalon;
    public static Solenoid grabbersolenoid_left;
    public static Compressor grabbercompressor;
    public static Solenoid grabbersolenoid_right;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassis_front_left = new CANTalon(5);
        
        
        chassis_back_left = new CANTalon(3);
        
        
        chassis_front_right = new CANTalon(4);
        
        
        chassis_back_right = new CANTalon(2);
        
        
        chassis_robot_drive = new RobotDrive(chassis_front_left, chassis_back_left,
              chassis_front_right, chassis_back_right);
        
        chassis_robot_drive.setSafetyEnabled(true);
        chassis_robot_drive.setExpiration(0.1);
        chassis_robot_drive.setSensitivity(0.5);
        chassis_robot_drive.setMaxOutput(1.0);

        chassis_drive_gyro = new Gyro(1);
        LiveWindow.addSensor("Chassis", "drive_gyro", chassis_drive_gyro);
        chassis_drive_gyro.setSensitivity(0.007);
        liftpot = new AnalogPotentiometer(0, 1.0, 0.0);
        LiveWindow.addSensor("Lift", "pot", liftpot);
        
        lifttalon = new Talon(0);
        LiveWindow.addActuator("Lift", "talon", (Talon) lifttalon);
        
        grabbersolenoid_left = new Solenoid(0, 0);
        LiveWindow.addActuator("Grabber", "solenoid_left", grabbersolenoid_left);
        
        grabbercompressor = new Compressor(0);
        
        
        grabbersolenoid_right = new Solenoid(0, 1);
        LiveWindow.addActuator("Grabber", "solenoid_right", grabbersolenoid_right);
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
