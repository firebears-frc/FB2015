package org.firebears.sensors;
//made by Jacob Wiggins

import edu.wpi.first.wpilibj.AnalogInput;

public class sharpIRProx extends AnalogInput {

	public sharpIRProx(int channel) {
		super(channel);
		// TODO Auto-generated constructor stub
	}

	public boolean inRange() {
		double prox = this.getAverageVoltage();
		
		if (prox < 3) {
			return true;
		} else {
			return false;
		}
	}

}