package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Visitor.Visitor;
import Visitor.VisitorAgua;

/**
 * Objeto temporal que impide el paso a los enemigos.
 */
public class Agua extends Objeto {

	/**
	 * Crea un objeto
	 * @param x - La coordenada x del objeto
	 * @param y - La coordenada y del objeto
	 */
	public Agua(int x, int y) {
		super(x, y);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Objetos/Agua.png"));
		jl = new JLabel(icon);		
		miVisitor = new VisitorAgua(this);
	}
	
	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}
	
}
