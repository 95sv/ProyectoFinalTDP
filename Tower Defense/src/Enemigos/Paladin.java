package Enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Mapa;

public class Paladin extends EnemigoCerca {	
	
	/**
	 * Crea un paladín.
	 * @param x - La coordenada x del enemigo
	 * @param y - La coordenada y del enemigo
	 */
	public Paladin(int x, int y) {
		super(x, y, 50, 10, 4, 20);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Paladin.png"));
		atacar = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Paladin_a.gif"));
		mover = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Paladin_c.gif"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		addLifeBar();
		addPUEffect();
	}
}
