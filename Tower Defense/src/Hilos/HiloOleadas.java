package Hilos;

import Tablero.Tablero;


 //Hilo que controla las oleadas de enemigos
 
public class HiloOleadas extends Thread {

	private boolean gameOver;
	private int frozen;

	public void gameOver() {
		gameOver = true;
	}

	
	public void frozen(int seg) {
		frozen = seg;
	}

	public void run() {
		gameOver = false;
		int contador = 0;
		int oleada = 1;
		while (!gameOver) {
			try {
				if (frozen > 0) {
					Thread.sleep(1000);
					frozen--;
				} else {
					Thread.sleep(3000);
					contador += 3;
					Tablero.getInstance().crearEnemigo();
					if (contador >= 10) {
						Thread.sleep(10000);
						contador = 0;
						oleada++;
						if (oleada > 3) {
							if (!Tablero.getInstance().hayEnemigos()) {
								Tablero.getInstance().gameOver(true);
							}
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
