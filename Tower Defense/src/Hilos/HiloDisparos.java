package Hilos;

import Tablero.Tablero;


 // Hilo que controla el movimiento de los disparos
 
public class HiloDisparos extends Thread {
	
	private boolean gameOver;
		
	
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
