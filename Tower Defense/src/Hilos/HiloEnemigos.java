package Hilos;

import Tablero.*;

/**
 * Hilo que controla las acciones de los enemigos.
 */
public class HiloEnemigos extends Thread { 
	
	private boolean gameOver;
	private int frozen;

	/**
	 * Esta operación se llama cuando se termina el juego y el hilo deber finalizar.
	 */
	public void gameOver() {
		gameOver = true;
	}
	
	/**
	 * Esta operación se llama cuando se quiere "pausar" el hilo. La operación run() sigue ejecutándose, 
	 * pero no va a realizar ninguna acción mientras el hilo esté "pausado".
	 * @param seg - Segundos que se pausa el hilo
	 */
	public void frozen(int seg) {
		frozen = seg;
	}
	
	public void run() {
		gameOver = false;
		while(!gameOver){
			try {
				if (frozen>0) {
					Thread.sleep(1000);
					frozen--;
				}
				else {
					Thread.sleep(125);
					Tablero.getInstance().moverEnemigos();
				}				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
