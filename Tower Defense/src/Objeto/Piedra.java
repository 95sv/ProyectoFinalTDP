package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorPiedra;

/**
 * Obstáculo que impide el paso de los enemigos. Puede ser destruido por ataques.
 */
public class Piedra extends Objeto {
	
	private float vida;
	
	/**
	 * Crea un objeto
	 * @param x - La coordenada x del objeto
	 * @param y - La coordenada y del objeto
	 */
	public Piedra(int x, int y) {
		super(x, y);
		vida = 25;
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Objetos/Piedra.png"));		
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		miVisitor = new VisitorPiedra(this);
	}
	
	public float getVida() {
		return vida;
	}
	
	public void setVida(float vida) {
		this.vida = vida;
	}
	
	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}
	
	public void recibirDaño(float daño) {
		vida -= daño;
		if (vida <= 0) {
			morir();
		}
	}

	
}
