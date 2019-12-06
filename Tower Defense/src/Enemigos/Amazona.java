package Enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Mapa;

public class Amazona extends EnemigoCerca {

	/**
	 * Crea una amazona.
	 * @param x - La coordenada x del enemigo
	 * @param y - La coordenada y del enemigo
	 */
	public Amazona(int x, int y) {
		super(x, y, 40, 10, 12, 15);
		icon = new ImageIcon(this.getClass().getResource("/Resources/Enemigos/Amazona.png"));
		atacar = new ImageIcon(this.getClass().getResource("/Resources/Enemigos/Amazona_a.gif"));
		mover = new ImageIcon(this.getClass().getResource("/Resources/Enemigos/Amazona_c.gif"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		addLifeBar();
		addPUEffect();
	}

}
