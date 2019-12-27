package Mapa;

import java.util.Random;

import javax.swing.ImageIcon;

import Hilos.HiloTiempo;
import Objeto.Agua;
import Objeto.Piedra;
import Tablero.Tablero;


 //Mapa que representa el primer nivel del juego

public class Nivel1 extends Mapa {

	
	public Nivel1() {
		super();
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Fondo1.jpg"));
		Random rnd = new Random();
		int x;
		int y;
		int lago = 0;
		int piedra = 0;
		while (lago<8) {
			x = rnd.nextInt(6) + 2; //Entre 2 y 7
			y = rnd.nextInt(6);
			if (celdas[x][y].getEntidad()==null) {				
				Agua l = new Agua(x*PIXEL, y*PIXEL);
				lago++;
				celdas[x][y].setEntidad(l);
				Tablero.getInstance().dibujarObjeto(l);
				HiloTiempo hl = new HiloTiempo(l, 30);
				hl.start();
			}			
		}
		while (piedra<3) {
			x = rnd.nextInt(6) + 2; //Entre 2 y 7
			y = rnd.nextInt(6);
			if (celdas[x][y].getEntidad()==null) {
				Piedra p = new Piedra(x*PIXEL, y*PIXEL);
				piedra++;
				celdas[x][y].setEntidad(p);
				Tablero.getInstance().dibujarObjeto(p);
			}
		}
	}
	
	public Mapa cambiarNivel(boolean completado) {
		if (completado) {
			return new Nivel2();
		}
		else {
			return new Nivel1();
		}
	}

}
