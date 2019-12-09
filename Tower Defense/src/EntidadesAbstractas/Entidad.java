package EntidadesAbstractas;

import Visitor.Visitor;

/**
 * Clase que engloba todos los objetos que ocupan un espacio en las celdas del mapa.
 */
public abstract class Entidad extends Graficable{
	protected Visitor miVisitor;
	/**
	 * Crea una entidad.
	 * @param x - La coordenada x del objeto
	 * @param y - La coordenada y del objeto
	 */
	public Entidad(int x, int y) {
		super(x, y);
	}
	

	/**
	 * La entidad es eliminada del tablero.
	 */
	public abstract void morir();

	public abstract boolean aceptar(Visitor v);
}
