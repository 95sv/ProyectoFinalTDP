package Enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Mapa;
import Visitor.VisitorEnemigoCerca;

public class Hielo extends EnemigoCerca {	
	
	 //Crea un enemigo Hielo.
	
	public Hielo(int x, int y) {
		super(x, y, 50, 10, 4, 20);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Hielo.gif"));
		atacar = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/HieloAtaque.gif"));
		mover = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Hielo.gif"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		addLifeBar();
		addPUEffect();
		miVisitor = new VisitorEnemigoCerca(this);
	}
}
