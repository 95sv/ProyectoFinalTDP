package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Tablero.Tablero;
import Torres.Roja;

/**
 * Bot�n espec�fico de la torre roja
 */
public class ButtonRoja extends ButtonComprable { 
	
	/**
	 * Crea un bot�n comprable.
	 * @param al El ActionListener asociado al bot�n
	 */
	public ButtonRoja(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/Rojo.png")));
        setToolTipText("<html> Torre Roja <br> Da�o: A+ <br> Velocidad: A <br> Vida: D <br> Costo: 50 </html");
	}
	
	public void crearComprable(int x, int y) {
		Roja r = new Roja(x, y);
		if (r.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(r);
		}
		
	}
}
