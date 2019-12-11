package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Enemigos.EnemigoLejos;
import Tablero.Tablero;
import Visitor.Visitor;
import Visitor.VisitorTrampa;
import Mapa.Mapa;

/**
 * Objeto comprable que destruye el primer enemigo que lo toca.
 */
public class Trampa extends ObjetoComprable {
	
	
	public Trampa(int x, int y) {
		super(x, y, 60);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/ObjetosComprables/Trampa.png"));		
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		miVisitor = new VisitorTrampa(this);
	}
	
	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}
	


}
