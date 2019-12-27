package Enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Mapa;
import Visitor.VisitorEnemigoCerca;

public class Magma extends EnemigoCerca {

	 //Crea un enemigo Magma.
	
	public Magma(int x, int y) {
		super(x, y, 250, 30, 2, 70);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Magma.gif"));
		atacar = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/MagmaAtaque.gif"));
		mover = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Magma.gif"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		addLifeBar();
		addPUEffect();
		miVisitor = new VisitorEnemigoCerca(this);
	}
}
