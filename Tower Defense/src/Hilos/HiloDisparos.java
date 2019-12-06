package Hilos;

import Tablero.Tablero;

/**
 * Hilo que controla el movimiento de los disparos
 */
public class HiloDisparos extends Thread {
	
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
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Tablero.getInstance().moverDisparos();
		}
	}
	
}
