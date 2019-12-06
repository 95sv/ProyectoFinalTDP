package Hilos;

import Tablero.Tablero;

/**
 * Hilo que controla las acciones de las torres.
 */
public class HiloTorres extends Thread {

	private boolean gameOver;

	/**
	 * Esta operación se llama cuando se termina el juego y el hilo deber finalizar.
	 */
	public void gameOver() {
		gameOver = true;
	}
	
	public void run() {
		gameOver = false;
		while(!gameOver){
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Tablero.getInstance().moverJugadores();
		}
	}
	
}
