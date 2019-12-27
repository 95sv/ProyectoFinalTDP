package Botones;

import javax.swing.Icon;
import javax.swing.JLabel;

import PowerUp.PowerUpInstantaneo;


public class LabelPowerUpInstantaneo extends JLabel {
	
	private PowerUpInstantaneo miPU;
	
	
	public LabelPowerUpInstantaneo(PowerUpInstantaneo pu, Icon i) {
		super(i);
		miPU = pu;
	}
	
	
	public PowerUpInstantaneo getPU() {
		return miPU;
	}

}
