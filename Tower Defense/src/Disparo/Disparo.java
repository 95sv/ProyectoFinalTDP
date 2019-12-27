package Disparo;

import EntidadesAbstractas.Graficable;
import Visitor.Visitor;

/**
 * Clase que representa el disparo de un personaje.
 * Los disparos se mueven en linea recta y desaparecen cuando impactan contra un objetivo, causandole da�o.
 */

public abstract class Disparo extends Graficable {
	protected float da�o;
	protected int velocidad;	
	protected Visitor miVisitor;
	
	
	public Disparo(int x, int y, float da�o, int velocidad) {
		super(x, y);
		this.da�o = da�o;
		this.velocidad = velocidad;
	}
	
	public abstract boolean aceptar(Visitor v);
	
	
	public float getDa�o() {
		return da�o;
	}
	
	public abstract void mover();
	
}
