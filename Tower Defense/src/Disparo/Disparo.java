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
	
	/**
	 * Crea un disparo en la posicion dada por par�metro.
	 * @param x - La coordenada x del disparo
	 * @param y - La coordenada y del disparo
	 * @param da�o - El da�o del disparo
	 * @param velocidad - La velocidad de movimiento del disparo
	 */
	public Disparo(int x, int y, float da�o, int velocidad) {
		super(x, y);
		this.da�o = da�o;
		this.velocidad = velocidad;
	}
	
	public abstract boolean aceptar(Visitor v);
	
	/**
	 * Retorna el da�o del disparo
	 * @return El da�o del disparo
	 */
	public float getDa�o() {
		return da�o;
	}
	
	/**
	 * Mueve el disparo. En caso de impactar contra un objetivo, le hace da�o al objetivo y desaparece.
	 * Tambien desaparece en el caso de que se vaya fuera del mapa.
	 */
	public abstract void mover();
	
}
