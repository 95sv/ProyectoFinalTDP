package Torres;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import EntidadesAbstractas.Entidad;
import EntidadesAbstractas.Personaje;
import Mapa.Mapa;
import Tablero.Tablero;
import Visitor.Visitor;
import Visitor.VisitorTorre;

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
	 * @param daño - Daño por segundo si ataca de cerca o por disparo si ataca de lejos
	 * @param velocidad - La velocidad del personaje
	 * @param valor - El valor del personaje. Puede ser el costo de compra o la recompensa por derrotarlo o venderlo.
	 */
	public Torre(int x, int y, float maxVida, float daño, int velocidad, int valor) {
		super(x, y, maxVida, daño, velocidad, valor);
		alcance = Mapa.MAX_ANCHO;
		miVisitor = new VisitorTorre(this);
	}
	
	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}
	
	public void accion() {
		Entidad e = null;
		boolean encontre = false;
		int i = 1;
		while (!encontre && i<=alcance && (x/Mapa.PIXEL-i>=0)) {
			e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL-i, y/Mapa.PIXEL);
			if (e!=null) {
				encontre = e.aceptar(miVisitor);
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
	 * Crea un disparo. El tipo de disparo depende de la implementación de la subclase.
	 */
	protected abstract void crearDisparo();
		
	
}
