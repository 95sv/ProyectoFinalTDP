package Enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Mapa;

public class Troll extends EnemigoCerca {

	/**
	 * Crea un troll.
	 * @param x - La coordenada x del enemigo
	 * @param y - La coordenada y del enemigo
	 */
	public Troll(int x, int y) {
		super(x, y, 250, 30, 2, 70);
		icon = new ImageIcon(this.getClass().getResource("/Resources/Enemigos/Troll.png"));
		atacar = new ImageIcon(this.getClass().getResource("/Resources/Enemigos/Troll_a.gif"));
		mover = new ImageIcon(this.getClass().getResource("/Resources/Enemigos/Troll_c.gif"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		addLifeBar();
		addPUEffect();
	}
}
