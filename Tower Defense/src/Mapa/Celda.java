package Mapa;
import EntidadesAbstractas.Entidad;

/**
 * Clase usada para fraccionar el nivel. Cada espacio del mapa es definido por una celda, que puede contener a lo sumo una entidad.
 */
public class Celda {
	
	private Mapa miMapa;
	private Entidad miEntidad;
	
	/**
	 * Crea una celda vacía
	 * @param m - El mapa que contiene esta celda
	 */
	public Celda(Mapa m) {
		miMapa = m;
	}
	
	public Mapa getMapa() {
		return miMapa;
	}
	
	/**
	 * Crea una celda con una entidad
	 * @param m - El mapa que contiene esta celda
	 * @param en - La entidad ubicada en este celda
	 */
	public Celda(Mapa m, Entidad en) {
		miMapa = m;
		miEntidad = en;
	}
	
	/**
	 * Retorna la entidad ubicada en esta celda.
	 * @return La entidad ubicada en esta celda
	 */
	public Entidad getEntidad() {
		return miEntidad;
	}

	/**
	 * Inserta una entidad en esta celda. Si existía una entidad anteriormente en esta celda, es reemplazada.
	 * @param en - La entidad a insertar
	 */
	public void setEntidad(Entidad en) {
		miEntidad = en;
	}

}
