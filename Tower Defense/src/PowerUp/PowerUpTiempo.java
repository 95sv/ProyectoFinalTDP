package PowerUp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Botones.LabelPowerUpTiempo;
import Hilos.HiloPowerUp;
import Tablero.Tablero;

/**
 * Un tipo de power-up que tiene un efecto temporal.
 * Cambia el estado del personaje afectado por este power-up.
 */
public abstract class PowerUpTiempo extends PowerUp {
	
	/**
	 * Crea un power-up.
	 * @param x - La coordenada x del power-up
	 * @param y - La coordenada y del power-up
	 */
	public PowerUpTiempo(int x, int y) {
		super(x, y);
	}

	/**
	 * Retorna el da�o que realiza el personaje con este power-up.
	 * @param da�o - El da�o base del personaje
	 * @return El da�o que realiza el personaje con este power-up
	 */
	public abstract float getDa�o(float da�o);
	
	/**
	 * Retorna la velocidad del personaje con este power-up.
	 * @param vel - Velocidad base del personaje
	 * @return la velocidad del personaje con este power-up
	 */
	public abstract int getVelocidad(int vel);
	
	/**
	 * Retorna el da�o inicial que recibe el personaje
	 * @param da�o - Da�o base
	 * @return El da�o final que recibe el personaje
	 */
	public abstract float recibirDa�o(float da�o);
	
	/**
	 * Cuando se hace click en el power-up del mapa, se aplica el power-up
	 * a las torres del jugador por un tiempo limitado.
	 */
	protected class UsarPowerUpTiempoListener extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			LabelPowerUpTiempo btn = (LabelPowerUpTiempo) e.getSource();
			Tablero.getInstance().setPowerUp(btn.getPU());
			Tablero.getInstance().eliminarPU(btn.getPU());
			new HiloPowerUp(5).start();
		}
	}
	
}
