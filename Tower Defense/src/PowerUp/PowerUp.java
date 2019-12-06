package PowerUp;

import EntidadesAbstractas.Graficable;

/**
 * Clase que engloba todos los power-up del juego.
 */
public abstract class PowerUp extends Graficable {
	
	/**
	 * Crea un power-up.
	 * @param x - La coordenada x del power-up
	 * @param y - La coordenada y del power-up
	 */
	public PowerUp(int x, int y) {
		super(x, y);
	}

}
