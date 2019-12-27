package Disparo;

import EntidadesAbstractas.Graficable;
import Visitor.Visitor;

/**
 * Clase que representa el disparo de un personaje.
 * Los disparos se mueven en linea recta y desaparecen cuando impactan contra un objetivo, causandole daño.
 */

public abstract class Disparo extends Graficable {
	protected float daño;
	protected int velocidad;	
	protected Visitor miVisitor;
	
	
	public Disparo(int x, int y, float daño, int velocidad) {
		super(x, y);
		this.daño = daño;
		this.velocidad = velocidad;
	}
	
	public abstract boolean aceptar(Visitor v);
	
	
	public float getDaño() {
		return daño;
	}
	
	public abstract void mover();
	
}
