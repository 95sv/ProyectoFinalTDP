package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Mapa.Mapa;
import Tablero.Tablero;
import Torres.Doble;
import Torres.DobleA;
import Torres.DobleB;


@SuppressWarnings("serial")
public class BotonDoble extends BotonComprable {

	//Boton para comprar TorreDoble
	
	public BotonDoble(ActionListener al) {
		super(al);
		setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/Doble.png")));
		
	}

	public void crearComprable(int x, int y) {
		Doble d1;
		Doble d2;
		if (Tablero.getInstance().getEntidad(x/64, y/64+1)==null) {
			d1 = new DobleA(x, y);
			d2 = new DobleB(x, y+Mapa.PIXEL);
			d1.setMitad(d2);
			d2.setMitad(d1);
			if (d1.getValor()<=Tablero.getInstance().getMonedas()) {
				Tablero.getInstance().crearJugador(d1);
				Tablero.getInstance().crearJugador(d2);
			}
		}
				
	}
}
