package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Tablero.Tablero;
import Torres.TorreArena;

/**
 * Bot�n espec�fico de la torre b�sica.
 */
public class BotonTorreArena extends ButtonComprable {
	/**
	 * Crea un bot�n comprable.
	 * @param al El ActionListener asociado al bot�n
	 */
	public BotonTorreArena(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreArena.png")));
        //setToolTipText("<html>Torre Basica <br> Da�o: C <br> Velocidad: C <br> Vida: C <br> Costo: 30</html>");
	}
	
	public void crearComprable(int x, int y) {
		TorreArena b = new TorreArena(x, y);
		if (b.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(b);
		}		
	}
}