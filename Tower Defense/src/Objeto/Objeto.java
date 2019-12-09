package Objeto;

import EntidadesAbstractas.Entidad;
import Tablero.Tablero;
import Visitor.Visitor;

/**
 * Clase que representa cualquier objeto del mapa que no sea un enemigo o una
 * torre. Todos estos objetos son obstaculos que benefician de alguna manera al
 * jugador.
 */
public abstract class Objeto extends Entidad {

	/**
	 * Crea un objeto
	 * 
	 * @param x - La coordenada x del objeto
	 * @param y - La coordenada y del objeto
	 */
	public Objeto(int x, int y) {
		super(x, y);
	}

	public abstract boolean aceptar(Visitor v);
	
	public void morir() {
		Tablero.getInstance().eliminarObjeto(this);
	}

}
