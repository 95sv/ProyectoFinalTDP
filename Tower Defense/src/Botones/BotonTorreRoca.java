package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Tablero.Tablero;
import Torres.TorreRoca;


public class BotonTorreRoca extends ButtonComprable {
	
	/**
	 * Crea un bot�n comprable.
	 * @param al El ActionListener asociado al bot�n
	 */
	public BotonTorreRoca(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreRoca.png")));
        //setToolTipText("<html> Torre Azul <br> Da�o: B <br> Velocidad: B <br> Vida: D <br> Costo: 35 </html");
	}	
	
	public void crearComprable(int x, int y) {
		TorreRoca a = new TorreRoca(x, y);
		if (a.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(a);
		}		
	}	
}
