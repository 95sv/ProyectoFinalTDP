package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Tablero.Tablero;
import Torres.TorreLadrillos;


public class BotonTorreLadrillos extends ButtonComprable { 
	
	/**
	 * Crea un botón comprable.
	 * @param al El ActionListener asociado al botón
	 */
	public BotonTorreLadrillos(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreLadrillos.png")));
        //setToolTipText("<html> Torre Roja <br> Daño: A+ <br> Velocidad: A <br> Vida: D <br> Costo: 50 </html");
	}
	
	public void crearComprable(int x, int y) {
		TorreLadrillos r = new TorreLadrillos(x, y);
		if (r.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(r);
		}
		
	}
}
