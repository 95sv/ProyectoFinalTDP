package Hilos;

import EntidadesAbstractas.Personaje;
import Tablero.Tablero;


 //Hilo que controla la duración de un power-up global para todas las torres o particular a un personaje,dependiendo de cómo fue creado el hilo.

public class HiloPowerUp extends Thread {
	
	private int miliseg;
	private Personaje p;
	
	
	public HiloPowerUp(int seg) {
		miliseg = seg*1000;
	}
	
	
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
