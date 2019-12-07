package Enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Mapa;

public class Fantasma extends EnemigoCerca {

	/**
	 * Crea un orco.
	 * @param x - La coordenada x del enemigo
	 * @param y - La coordenada y del enemigo
	 */
	public Fantasma(int x, int y) {
		super(x, y, 100, 20, 4, 50);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Fantasma.gif"));
		atacar = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/FantasmaAtaque.gif"));
		mover = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Fantasma.gif"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		addLifeBar();
		addPUEffect();
	}
}
