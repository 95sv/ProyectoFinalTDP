package Torres;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Mapa;
import Visitor.Visitor;

/**
 * Parte superior de la torre doble. La referencia de la otra mitad debe ser la parte inferior de la torre.
 */
public class DobleA extends Doble {	

	
	public DobleA(int x, int y) {
		super(x, y, 50, 10, 8, 30);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreDobleA.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		
	}
	
	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}

}
