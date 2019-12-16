package Torres;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Mapa;
import Visitor.Visitor;

/**
 * Parte inferior de la torre doble. La referencia de la otra mitad debe ser la parte superior de la torre.
 */
public class DobleB extends Doble {
	
	/**
	 * Crea la parte inferior de la torre doble.
	 * @param x - La coordenada x de la torre
	 * @param y - La coordenada y de la torre
	 */
	public DobleB(int x, int y) {
		super(x, y, 50, 10, 8, 0);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreDobleB.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		addLifeBar();
		addPUEffect();
	}	
	
	public boolean aceptar(Visitor v) {
		
		return v.visit(this);
	}

}
