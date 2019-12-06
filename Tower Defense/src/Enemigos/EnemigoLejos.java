package Enemigos;

import EntidadesAbstractas.Entidad;
import Mapa.Mapa;
import Tablero.Tablero;

/**
 * Un tipo de enemigo que ataca de lejos. El da�o que realiza es por disparo.
 */
public abstract class EnemigoLejos extends Enemigo {

	protected int alcance;
	protected float cooldown;
	
	/**
	 * Crea un enemigo.
	 * @param x - La coordenada x del personaje
	 * @param y - La coordenada y del personaje
	 * @param maxVida - La vida maxima. Esta es la vida con la que empieza el personaje
	 * @param da�o - Da�o por disparo
	 * @param velocidad - La velocidad del personaje
	 * @param valor - El valor del personaje. Puede ser el costo de compra o la recompensa por derrotarlo o venderlo.
	 * @param alcance - El alcance del personaje, es decir, hasta cuantas celdas puede disparar.
	 */
	public EnemigoLejos(int x, int y, float maxVida, float da�o, int velocidad, int valor, int alcance) {
		super(x, y, maxVida, da�o, velocidad, valor);
		this.alcance = alcance;
	}
	
	public void accion() {
		if (x>=Mapa.PIXEL*Mapa.MAX_ANCHO) {
			Tablero.getInstance().gameOver(false);
		}
		else {
			if (cooldown<=0) {
				Entidad e = null;
				boolean encontre = false;
				int i = 1;
				while (!encontre && i<=alcance && (x/Mapa.PIXEL+i<=Mapa.MAX_ANCHO) && (x/Mapa.PIXEL+i>=0)) {
					e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL+i, y/Mapa.PIXEL);
					if (e!=null) {
						encontre = e.visit(this);
					}	
					i++;
				}
				//Dispara si hay enemigo, sino camina en caso de que la siguiente celda este vacia
				if (encontre && x>0) {
					crearDisparo();
					cooldown = 10;
					jl.setIcon(atacar);
				}
				else {
					e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL+1, y/Mapa.PIXEL); //Entidad de la celda siguiente
					if (e==null) {
						if (miPU!=null) {
							x+= miPU.getVelocidad(velocidad);
						}
						else {
							x+= velocidad;
						}			
						jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);	
						jl.setIcon(mover);
					}	
					else {
						jl.setIcon(icon);
					}
				}
			}
			else {
				cooldown -= 1;
			}
		}		
	}
	
	/**
	 * Crea un disparo. El tipo de disparo que cree depende del tipo de enemigo que lance dicho disparo.
	 */
	protected abstract void crearDisparo();
	
}
