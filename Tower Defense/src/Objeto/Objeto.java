package Objeto;

import Disparo.DisparoAliado;
import Enemigos.Enemigo;
import EntidadesAbstractas.Entidad;
import Tablero.Tablero;
import Torres.Torre;

/**
 * Clase que representa cualquier objeto del mapa que no sea un enemigo o una torre. 
 * Todos estos objetos son obstaculos que benefician de alguna manera al jugador.
 */
public abstract class Objeto extends Entidad {	
		
	/**
	 * Crea un objeto
	 * @param x - La coordenada x del objeto
	 * @param y - La coordenada y del objeto
	 */
	public Objeto(int x, int y) {
		super(x, y);
	}
	
	public boolean visit(Torre j) {
		return false;
	}
	
	public boolean visit(DisparoAliado d) {
		return false;
	}	
	
	
	public void morir() {
		Tablero.getInstance().eliminarObjeto(this);
	}
	
	
	public void visit() {
		//No hay interaccion
	}
}
