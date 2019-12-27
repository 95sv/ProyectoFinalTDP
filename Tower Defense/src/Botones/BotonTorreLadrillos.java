package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Tablero.Tablero;
import Torres.TorreLadrillos;


public class BotonTorreLadrillos extends BotonComprable { 
	
	//Boton para comprar TorreLadrillos
	
	public BotonTorreLadrillos(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreLadrillos.png")));
        
	}
	
	public void crearComprable(int x, int y) {
		TorreLadrillos r = new TorreLadrillos(x, y);
		if (r.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(r);
		}
		
	}
}
