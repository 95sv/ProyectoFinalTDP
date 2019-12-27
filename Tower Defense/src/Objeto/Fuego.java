package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorFuego;


  //Obst�culo comprable temporal que da�a al enemigo mas cercano. 
 
public class Fuego extends ObjetoComprable {
	
	private float da�o;

	public Fuego(int x, int y) {
		super(x, y, 20);
		da�o = 10;
		icon = new ImageIcon(this.getClass().getResource("/Recursos/ObjetosComprables/Fuego.gif"));		
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		miVisitor = new VisitorFuego(this);
	}
	
	public float getDa�o() {
		return da�o;
	}

	
	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}

}
