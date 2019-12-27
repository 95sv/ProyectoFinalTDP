package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Mapa;

/**
 * Disparo espec�fico de la torre verde
 */
public class DisparoControl extends DisparoAliado {

	
	public DisparoControl(int x, int y, float da�o, int velocidad) {
		super(x, y, da�o, velocidad);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Disparos/2.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
}
