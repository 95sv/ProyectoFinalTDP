package Enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Mapa;

public class Corona extends EnemigoCerca {

	/**
	 * Crea un caballero.
	 * @param x - La coordenada x del enemigo
	 * @param y - La coordenada y del enemigo
	 */
	public Corona(int x, int y) {
		super(x, y, 20, 5, 8, 10);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Corona.gif"));
		atacar = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/CoronaAtaque.gif"));
		mover = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Corona.gif"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		addLifeBar();
		addPUEffect();
	}

}
