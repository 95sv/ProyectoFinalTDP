package Hilos;

import Tablero.Tablero;


 // Hilo que controla las acciones de las torres.
 
public class HiloTorres extends Thread {

	private boolean gameOver;

	
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
