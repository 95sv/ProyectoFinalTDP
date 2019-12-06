package Hilos;

import Objeto.Objeto;
import Tablero.Tablero;

/**
 * Hilo que controla la duración de un objeto que existe temporalmente.
 */
public class HiloTiempo extends Thread {

	private Objeto obj;
	private int segundos;
	
	/**
	 * Crea el hilo asociado al objeto.
	 * @param o - Objeto asociado al hilo
	 * @param seg - Duración del objeto
	 */
	public HiloTiempo(Objeto o, int seg) {
		obj = o;
		this.segundos = seg;
	}
	
	public void run() {
		int contador = 0;
		while (contador<segundos) {
			try {
				Thread.sleep(1000);
				contador++;				
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Tablero.getInstance().eliminarObjeto(obj);
	}
	
}
