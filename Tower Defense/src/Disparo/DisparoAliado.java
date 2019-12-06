package Disparo;

import EntidadesAbstractas.Entidad;
import Tablero.Tablero;
import Mapa.Mapa;

/**
 * Un tipo de disparo que solo es lanzado por las torres controlados por el jugador.
 * Estos disparos solo afectan a los enemigos del jugador
 */
public abstract class DisparoAliado extends Disparo {
	
	/**
	 * Crea un disparo aliado en la posicion dada por parámetro.
	 * @param x - La coordenada x del disparo
	 * @param y - La coordenada y del disparo
	 * @param daño - El daño del disparo
	 * @param velocidad - La velocidad de movimiento del disparo
	 */
	public DisparoAliado(int x, int y, float daño, int velocidad) {
		super(x, y, daño, velocidad);
	}
	
	public void mover() {
		Entidad e;
		if (x/Mapa.PIXEL>=0) {
			e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL, y/Mapa.PIXEL); //Entidad de la celda donde esta
		}
		else {
			if (x<-Mapa.PIXEL) {
				Tablero.getInstance().eliminar(this);
			}			
			e = null;
		}
		if (e!=null) {
			if (e.visit(this)) { //Se visita la entidad de la celda que está "pisando" el disparo
				Tablero.getInstance().eliminar(this);	
			}
			else {
				if (x/Mapa.PIXEL+1<Mapa.MAX_ANCHO) { 
					e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL, y/Mapa.PIXEL); //Entidad de la celda anterior
				}
				else {
					e = null;
				}
				if (e!=null && e.visit(this)) { //Se visita la entidad de la celda anterior en caso de que se haya pasado de largo el disparo
					Tablero.getInstance().eliminar(this); 
				}
				else {
					x-=velocidad;
					jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
				}				
			}
		}
		else {
			x-=velocidad;
			jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		}
	}
	
}
