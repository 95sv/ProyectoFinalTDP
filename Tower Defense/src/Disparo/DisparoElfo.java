package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Mapa;

/**
 * Disparo espec�fico del elfo.
 */
public class DisparoElfo extends DisparoEnemigo {

	/**
	 * Crea un disparo del elfo en la posicion dada por par�metro.
	 * @param x - La coordenada x del disparo
	 * @param y - La coordenada y del disparo
	 * @param da�o - El da�o del disparo
	 * @param velocidad - La velocidad de movimiento del disparo
	 */
	public DisparoElfo(int x, int y, float da�o, int velocidad) {
		super(x, y, da�o, velocidad);
		icon = new ImageIcon(this.getClass().getResource("/Resources/Disparos/5.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
}
