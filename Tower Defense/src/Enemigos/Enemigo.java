package Enemigos;

import java.util.Random;
import javax.swing.Icon;
import EntidadesAbstractas.Personaje;
import Tablero.Tablero;

/**
 * Un tipo de personaje que es enemigo del jugador.
 */
public abstract class Enemigo extends Personaje {
	
	protected Icon atacar;
	protected Icon mover;
	
	/**
	 * Crea un enemigo.
	 * @param x - La coordenada x del personaje
	 * @param y - La coordenada y del personaje
	 * @param maxVida - La vida maxima. Esta es la vida con la que empieza el personaje
	 * @param daño - Daño por segundo si ataca de cerca o por disparo si ataca de lejos
	 * @param velocidad - La velocidad del personaje
	 * @param valor - El valor del personaje. Puede ser el costo de compra o la recompensa por derrotarlo o venderlo.
	 */
	public Enemigo(int x, int y, float maxVida, float daño, int velocidad, int valor) {
		super(x, y, maxVida, daño, velocidad, valor);
	}
		
	public void morir() {
		Tablero.getInstance().eliminar(this);
		//Cuando muere un enemigo, hay una posibildiad de que suelte
		//un power-up en la celda donde murio
		Random rnd = new Random();
		int r = rnd.nextInt(100);
		if (r<15) {
			Tablero.getInstance().dropPowerUp(x, y);
		}	
		x = -1; //Esto evita que trate de actualizar su posicion en el mapa
		y = -1;
	}
	
	public void visit() {
		//No hay interaccion
	}
	
}
