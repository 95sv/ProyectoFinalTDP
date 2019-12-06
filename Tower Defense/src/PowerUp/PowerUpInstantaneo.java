package PowerUp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Botones.LabelPowerUpInstantaneo;
import Tablero.Tablero;

/**
 * Un tipo de power-up que tiene un efecto inmediato.
 */
public abstract class PowerUpInstantaneo extends PowerUp {
	
	/**
	 * Crea un power-up.
	 * @param x - La coordenada x del power-up
	 * @param y - La coordenada y del power-up
	 */
	public PowerUpInstantaneo(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Efecto del power-up
	 */
	public abstract void efecto();
	
	/**
	 * Cuando se hace click en el power-up del mapa, se activa el efecto.
	 */
	protected class UsarPowerUpInstantaneoListener extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			LabelPowerUpInstantaneo btn = (LabelPowerUpInstantaneo) e.getSource();
			btn.getPU().efecto();
			Tablero.getInstance().eliminarPU(btn.getPU());
		}	
	}

}
