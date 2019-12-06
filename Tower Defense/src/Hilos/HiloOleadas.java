package Hilos;

import Tablero.Tablero;

/**
 * Hilo que controla las oleadas de enemigos
 */
public class HiloOleadas extends Thread {

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
		int contador = 0;
		int oleada = 1;
		while(!gameOver) {
			try {
				if (frozen>0) {
					Thread.sleep(1000);
					frozen--;
				}
				else {
					Thread.sleep(3000/oleada);				
					contador += 3000/oleada/1000;
					Tablero.getInstance().crearEnemigo();				
					if (contador>=30) {
						Thread.sleep(10000);					
						contador = 0;
						oleada++;
						if (oleada>3) {
							while (Tablero.getInstance().hayEnemigos()) {
								
							}	
							Tablero.getInstance().gameOver(true);
						}					
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
	
}
