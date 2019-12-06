package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Tablero.Tablero;
import Torres.TorreBasica;

/**
 * Botón específico de la torre básica.
 */
public class ButtonBasica extends ButtonComprable {
	/**
	 * Crea un botón comprable.
	 * @param al El ActionListener asociado al botón
	 */
	public ButtonBasica(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Resources/Torres/Basica.png")));
        setToolTipText("<html>Torre Basica <br> Daño: C <br> Velocidad: C <br> Vida: C <br> Costo: 30</html>");
	}
	
	public void crearComprable(int x, int y) {
		TorreBasica b = new TorreBasica(x, y);
		if (b.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(b);
		}		
	}
}