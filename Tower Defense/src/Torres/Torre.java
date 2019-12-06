package Torres;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Enemigos.EnemigoLejos;
import EntidadesAbstractas.Entidad;
import EntidadesAbstractas.Personaje;
import Mapa.Mapa;
import Tablero.Tablero;

/**
 * Clase que representa las torres del jugador. No pueden moverse pero pueden lanzar disparos a los enemigos de la fila.
 */
public abstract class Torre extends Personaje {
	
	protected int alcance;
	
	/**
	 * Crea una torre.
	 * @param x - La coordenada x de la torre
	 * @param y - La coordenada y de la torre
	 * @param maxVida - La vida maxima. Esta es la vida con la que empieza el personaje
	 * @param da�o - Da�o por segundo si ataca de cerca o por disparo si ataca de lejos
	 * @param velocidad - La velocidad del personaje
	 * @param valor - El valor del personaje. Puede ser el costo de compra o la recompensa por derrotarlo o venderlo.
	 */
	public Torre(int x, int y, float maxVida, float da�o, int velocidad, int valor) {
		super(x, y, maxVida, da�o, velocidad, valor);
		alcance = Mapa.MAX_ANCHO;
	}
	
	public void accion() {
		Entidad e = null;
		boolean encontre = false;
		int i = 1;
		while (!encontre && i<=alcance && (x/Mapa.PIXEL-i>=0)) {
			e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL-i, y/Mapa.PIXEL);
			if (e!=null) {
				encontre = e.visit(this);
			}	
			i++;
		}
		if (encontre) {
			crearDisparo();
		}
	}	
	
	public void morir() {
		Tablero.getInstance().eliminar(this);
	}
	
	/**
	 * Crea un disparo. El tipo de disparo depende de la implementaci�n de la subclase.
	 */
	protected abstract void crearDisparo();
		
	public boolean visit(EnemigoCerca e) {
		recibirDa�o(e.getDa�o()/8);
		return true;
	}
	
	public boolean visit(EnemigoLejos e) {
		return true;
	}
	
	public boolean visit(DisparoAliado d) {
		return false;
	}
	
	public boolean visit(DisparoEnemigo d) {
		recibirDa�o(d.getDa�o());
		if (vida<=0) {
			morir();
		}
		return true;
	}
	
	public void visit() {
		Tablero.getInstance().vender(this);
	}
	
	public boolean visit(Torre j) {
		return false;
	}

}