package Hilos;

import EntidadesAbstractas.Personaje;
import Tablero.Tablero;

/**
 * Hilo que controla la duraci�n de un power-up global para todas las torres o particular a un personaje, 
 * dependiendo de c�mo fue creado el hilo.
 */
public class HiloPowerUp extends Thread {
	
	private int miliseg;
	private Personaje p;
	
	/**
	 * Crea un hilo de power-up que afecta a todas las torres.
	 * @param seg - Duraci�n del hilo
	 */
	public HiloPowerUp(int seg) {
		miliseg = seg*1000;
	}
	
	/**
	 * Crea un hilo de power-up que afecta a un personaje.
	 * @param seg - Duraci�n del hilo
	 * @param p - Personaje afectado por el power-up
	 */
	public HiloPowerUp(int seg, Personaje p) {
		miliseg = seg*1000;
		this.p = p;
	}

	public void run() {
		try {
			Thread.sleep(miliseg);
			if (p!=null) {
				p.setPowerUp(null);
			}
			else {
				Tablero.getInstance().setPowerUp(null);
			}			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
