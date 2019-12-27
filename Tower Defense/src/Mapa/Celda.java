package Mapa;
import EntidadesAbstractas.Entidad;


 //Clase usada para fraccionar el nivel. Cada espacio del mapa es definido por una celda, que puede contener a lo sumo una entidad.

public class Celda {
	
	private Mapa miMapa;
	private Entidad miEntidad;
	
	
	public Celda(Mapa m) {
		miMapa = m;
	}
	
	public Mapa getMapa() {
		return miMapa;
	}
	
	public Celda(Mapa m, Entidad en) {
		miMapa = m;
		miEntidad = en;
	}
	
	
	public Entidad getEntidad() {
		return miEntidad;
	}

	public void setEntidad(Entidad en) {
		miEntidad = en;
	}

}
