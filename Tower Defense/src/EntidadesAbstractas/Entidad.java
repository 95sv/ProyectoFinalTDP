package EntidadesAbstractas;

import Disparo.DisparoAliado;

import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Enemigos.EnemigoLejos;
import Torres.Torre;

/**
 * Clase que engloba todos los objetos que ocupan un espacio en las celdas del mapa.
 */
public abstract class Entidad extends Graficable{
	
	/**
	 * Crea una entidad.
	 * @param x - La coordenada x del objeto
	 * @param y - La coordenada y del objeto
	 */
	public Entidad(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Recibe una visita de un disparo aliado.
	 * @param d - El disparo aliado que lo visita
	 * @return True si el disparo impactó, false en caso contrario
	 */
	public abstract boolean visit(DisparoAliado d);
	
	/**
	 * Recibe una visita de un disparo enemigo.
	 * @param d - El disparo enemigo que lo visita
	 * @return True si el disparo impactó, false en caso contrario
	 */
	public abstract boolean visit(DisparoEnemigo d);
	
	/**
	 * Recibe una visita de un enemigo que ataca de cerca.
	 * @param e - El enemigo que lo visita
	 * @return True si el enemigo puede atacar, false en caso contrario
	 */
	public abstract boolean visit(EnemigoCerca e);
	
	/**
	 * Recibe una visita de un enemigo que ataca de lejos.
	 * @param e - El enemigo que lo visita
	 * @return True si el enemigo puede dispara, false en caso contrario
	 */
	public abstract boolean visit(EnemigoLejos e);
	
	/**
	 * Recibe una visita de la gui para determinar si esta entidad puede ser vendida o no.
	 */
	public abstract void visit();
	
	/**
	 * Recibe una visita de un jugador.
	 * @param j - El jugador que lo visita
	 * @return True si el jugador puede disparar, false en caso contrario
	 */
	public abstract boolean visit(Torre j);
	
	/**
	 * La entidad es eliminada del tablero.
	 */
	public abstract void morir();
}
