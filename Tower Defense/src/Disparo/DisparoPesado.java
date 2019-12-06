package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Mapa;

/**
 * Disparo específico de la torre pesada.
 */
public class DisparoPesado extends DisparoAliado {

	/**
	 * Crea un disparo pesado en la posicion dada por parámetro.
	 * @param x - La coordenada x del disparo
	 * @param y - La coordenada y del disparo
	 * @param daño - El daño del disparo
	 * @param velocidad - La velocidad de movimiento del disparo
	 */
	public DisparoPesado(int x, int y, float daño, int velocidad) {
		super(x, y, daño, velocidad);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Disparos/1.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}	
}
