package Enemigos;

import java.util.Random;
import javax.swing.Icon;
import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import EntidadesAbstractas.Personaje;
import Objeto.Agua;
import Objeto.Objeto;
import Tablero.Tablero;
import Torres.Torre;

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
	 * @param da�o - Da�o por segundo si ataca de cerca o por disparo si ataca de lejos
	 * @param velocidad - La velocidad del personaje
	 * @param valor - El valor del personaje. Puede ser el costo de compra o la recompensa por derrotarlo o venderlo.
	 */
	public Enemigo(int x, int y, float maxVida, float da�o, int velocidad, int valor) {
		super(x, y, maxVida, da�o, velocidad, valor);
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

	public boolean visit(EnemigoCerca e) {
		return false;
	}
	
	
	public boolean visit(EnemigoLejos e) {
		return false;
	}
	
	public boolean visit(DisparoEnemigo e) {
		return false;
	}
	
	public boolean visit(Objeto o) {
		System.out.println("entre visit enemigo ");
		return false;
	}
	
	public boolean visit(DisparoAliado d) {
		recibirDa�o(d.getDa�o());
		return true;
	}
	
	public void visit() {
		//No hay interaccion
	}
	
	public boolean visit(Torre j) {
		return true;
	}
	
}
