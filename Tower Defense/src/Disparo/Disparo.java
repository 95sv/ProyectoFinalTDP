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
	
	/**
	 * Crea un disparo en la posicion dada por parámetro.
	 * @param x - La coordenada x del disparo
	 * @param y - La coordenada y del disparo
	 * @param daño - El daño del disparo
	 * @param velocidad - La velocidad de movimiento del disparo
	 */
	public Disparo(int x, int y, float daño, int velocidad) {
		super(x, y);
		this.daño = daño;
		this.velocidad = velocidad;
	}
	
	public abstract boolean aceptar(Visitor v);
	
	/**
	 * Retorna el daño del disparo
	 * @return El daño del disparo
	 */
	public float getDaño() {
		return daño;
	}
	
	/**
	 * Mueve el disparo. En caso de impactar contra un objetivo, le hace daño al objetivo y desaparece.
	 * Tambien desaparece en el caso de que se vaya fuera del mapa.
	 */
	public abstract void mover();
	
}
