package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Mapa;

/**
 * Disparo espec�fico de la torre Arena.
 */

public class DisparoArena extends DisparoAliado {
	
	
	public DisparoArena(int x, int y, float da�o, int velocidad) {
		super(x, y, da�o, velocidad);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Disparos/0.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
}
