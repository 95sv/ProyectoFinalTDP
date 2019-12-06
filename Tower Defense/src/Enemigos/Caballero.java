package Enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Mapa;

public class Caballero extends EnemigoCerca {

	/**
	 * Crea un caballero.
	 * @param x - La coordenada x del enemigo
	 * @param y - La coordenada y del enemigo
	 */
	public Caballero(int x, int y) {
		super(x, y, 20, 5, 8, 10);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Caballero.png"));
		atacar = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Caballero_a.gif"));
		mover = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Caballero_c.gif"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		addLifeBar();
		addPUEffect();
	}

}
