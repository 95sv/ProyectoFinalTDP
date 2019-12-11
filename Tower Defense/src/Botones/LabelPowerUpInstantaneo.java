package Botones;

import javax.swing.Icon;
import javax.swing.JLabel;

import PowerUp.PowerUpInstantaneo;


public class LabelPowerUpInstantaneo extends JLabel {
	
	private PowerUpInstantaneo miPU;
	
	/**
	 * Crea un label de power-up.
	 * @param pu - El power-up asociado a este label
	 * @param i - Imagen del power-up
	 */
	public LabelPowerUpInstantaneo(PowerUpInstantaneo pu, Icon i) {
		super(i);
		miPU = pu;
	}
	
	/**
	 * Retorna el power-up asociado a este label.
	 * @return el power-up asociado a este label
	 */
	public PowerUpInstantaneo getPU() {
		return miPU;
	}

}
