package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoEnemigo;
import Visitor.Visitor;
import Visitor.VisitorVeneno;
import Mapa.Mapa;

 //Objeto comprable que envenena a todos los enemigos cuando es tocado por un enemigo.

public class Veneno extends ObjetoComprable {

	
	public Veneno(int x, int y) {
		super(x, y, 20);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/ObjetosComprables/Veneno.png"));		
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		miVisitor = new VisitorVeneno(this);
	}
	
	
	public boolean visit(DisparoEnemigo e) {
		return false;
	}

	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}

}