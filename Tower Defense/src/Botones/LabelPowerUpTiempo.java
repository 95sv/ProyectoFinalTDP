package Botones;

import javax.swing.Icon;
import javax.swing.JLabel;

import PowerUp.PowerUpTiempo;


@SuppressWarnings("serial")
public class LabelPowerUpTiempo extends JLabel {
	
	protected PowerUpTiempo miPU;
	
	
	public LabelPowerUpTiempo(PowerUpTiempo pu, Icon i) {
		super(i);
		miPU = pu;
	}
	
	public PowerUpTiempo getPU() {
		return miPU;
	}

}
