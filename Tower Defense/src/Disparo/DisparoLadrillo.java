package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Mapa;

/**
 * Disparo específico de la torre Ladrillo
 */

public class DisparoLadrillo extends DisparoAliado {

	public DisparoLadrillo(int x, int y, float daño, int velocidad) {
		super(x, y, daño, velocidad);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Disparos/3.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
}
