package Botones;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import Tablero.Tablero;
import Torres.TorreArena;


public class BotonTorreArena extends ButtonComprable {
	/**
	 * Crea un botón comprable.
	 * @param al El ActionListener asociado al botón
	 */
	public BotonTorreArena(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreArena.png")));
        //setToolTipText("<html>Torre Basica <br> Daño: C <br> Velocidad: C <br> Vida: C <br> Costo: 30</html>");
	}
	
	public void crearComprable(int x, int y) {
		TorreArena b = new TorreArena(x, y);
		if (b.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(b);
		}		
	}
}