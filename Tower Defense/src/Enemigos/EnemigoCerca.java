package Enemigos;

import EntidadesAbstractas.Entidad;
import Mapa.Mapa;
import Tablero.Tablero;

/**
 * Un tipo de enemigo que ataca de cerca. El daño que realiza es por segundo.
 */
public abstract class EnemigoCerca extends Enemigo {

	/**
	 * Crea un enemigo.
	 * @param x - La coordenada x del personaje
	 * @param y - La coordenada y del personaje
	 * @param maxVida - La vida maxima. Esta es la vida con la que empieza el personaje
	 * @param daño - Daño por segundo
	 * @param velocidad - La velocidad del personaje
	 * @param valor - El valor del personaje. Puede ser el costo de compra o la recompensa por derrotarlo o venderlo.
	 */
	public EnemigoCerca(int x, int y, float maxVida, float daño, int velocidad, int valor) {
		super(x, y, maxVida, daño, velocidad, valor);
	}
	
	public void accion() {
		if (x>=Mapa.PIXEL*Mapa.MAX_ANCHO) {
			Tablero.getInstance().gameOver(false);
		}
		else {
			Entidad e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL+1, y/Mapa.PIXEL); //Entidad de la celda siguiente
			if (e!=null) {
				if (e.visit(this)) {
					jl.setIcon(atacar);
				}
				else {
					jl.setIcon(icon);
				}
			}
			else {
				if (miPU!=null) {
					x+= miPU.getVelocidad(velocidad);
				}
				else {
					x+= velocidad;
				}		
				jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);		
				jl.setIcon(mover);
			}
		}		
	}	
}
