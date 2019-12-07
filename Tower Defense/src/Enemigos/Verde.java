package Enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Mapa;

public class Verde extends EnemigoCerca {

	/**
	 * Crea una amazona.
	 * @param x - La coordenada x del enemigo
	 * @param y - La coordenada y del enemigo
	 */
	public Verde(int x, int y) {
		super(x, y, 40, 10, 12, 15);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Verde.gif"));
		atacar = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/VerdeAtaque.gif"));
		mover = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Verde.gif"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		addLifeBar();
		addPUEffect();
	}

}
