package Hilos;

import Tablero.Tablero;


 //Hilo específico para el efecto del objeto Veneno.
 
public class HiloVeneno extends Thread {
		
	public void run() {
		int contador = 0;
		while(contador<5){
			try {
				Thread.sleep(1000);
				contador++;
				Tablero.getInstance().dañarEnemigos(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Tablero.getInstance().moverDisparos();
		}
	}
	
}
