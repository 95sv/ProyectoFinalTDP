package Disparo;

import EntidadesAbstractas.Entidad;
import Mapa.Mapa;
import Tablero.Tablero;

/**
 * Un tipo de disparo que solo es lanzado por los enemigos. 
 * Estos disparos afectan a las torres del jugador y a algunos obstáculos.
 */
public abstract class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(int x, int y, float daño, int velocidad) {
		super(x, y, daño, velocidad);
	}
	
	public void mover() {
		Entidad e;
		if (x/Mapa.PIXEL<=Mapa.MAX_ANCHO) {
			e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL, y/Mapa.PIXEL); //Entidad de la celda donde esta
		}
		else {
			if (x/Mapa.PIXEL>Mapa.MAX_ANCHO) {
				Tablero.getInstance().eliminar(this);
			}
			e = null;
		}
		if (e!=null) {
			if (e.visit(this)) { //Se visita la entidad de la celda que está "pisando" el disparo
				Tablero.getInstance().eliminar(this);	
			}
			else {
				if (x/Mapa.PIXEL-1>=0) { 
					e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL, y/Mapa.PIXEL); //Entidad de la celda anterior
				}
				else {
					e = null;
				}
				if (e!=null && e.visit(this)) { //Se visita la entidad de la celda anterior en caso de que se haya pasado de largo el disparo
					Tablero.getInstance().eliminar(this); 
				}
				else {
					x+=velocidad;
					jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
				}				
			}
		}
		else {
			x+=velocidad;
			jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		}
	}

}
