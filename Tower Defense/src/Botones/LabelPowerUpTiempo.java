package Botones;

import javax.swing.Icon;
import javax.swing.JLabel;

import PowerUp.PowerUpTiempo;


public class LabelPowerUpTiempo extends JLabel {
	
	protected PowerUpTiempo miPU;
	
	/**
	 * Crea un label de power-up.
	 * @param pu - El power-up asociado a este label
	 * @param i - Imagen del power-up
	 */
	public LabelPowerUpTiempo(PowerUpTiempo pu, Icon i) {
		super(i);
		miPU = pu;
	}
	
	/**
	 * Retorna el power-up asociado a este label.
	 * @return el power-up asociado a este label
	 */
	public PowerUpTiempo getPU() {
		return miPU;
	}

}
