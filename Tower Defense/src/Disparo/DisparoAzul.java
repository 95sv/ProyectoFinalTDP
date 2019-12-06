package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Mapa;

/**
 * Disparo específco de la torre azul.
 */
public class DisparoAzul extends DisparoAliado {

	/**
	 * Crea un disparo azul en la posicion dada por parámetro.
	 * @param x - La coordenada x del disparo
	 * @param y - La coordenada y del disparo
	 * @param daño - El daño del disparo
	 * @param velocidad - La velocidad de movimiento del disparo
	 */
	public DisparoAzul(int x, int y, float daño, int velocidad) {
		super(x, y, daño, velocidad);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Disparos/4.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
}
