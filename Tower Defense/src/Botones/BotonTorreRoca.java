package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Tablero.Tablero;
import Torres.TorreRoca;


public class BotonTorreRoca extends BotonComprable {
	
	//Boton para comprar TorreRoca
	
	public BotonTorreRoca(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreRoca.png")));
  
	}	
	
	public void crearComprable(int x, int y) {
		TorreRoca a = new TorreRoca(x, y);
		if (a.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(a);
		}		
	}	
}
