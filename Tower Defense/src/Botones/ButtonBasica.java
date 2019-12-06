package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Tablero.Tablero;
import Torres.TorreBasica;

/**
 * Bot�n espec�fico de la torre b�sica.
 */
public class ButtonBasica extends ButtonComprable {
	/**
	 * Crea un bot�n comprable.
	 * @param al El ActionListener asociado al bot�n
	 */
	public ButtonBasica(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Resources/Torres/Basica.png")));
        setToolTipText("<html>Torre Basica <br> Da�o: C <br> Velocidad: C <br> Vida: C <br> Costo: 30</html>");
	}
	
	public void crearComprable(int x, int y) {
		TorreBasica b = new TorreBasica(x, y);
		if (b.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(b);
		}		
	}
}