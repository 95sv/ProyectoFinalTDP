package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Tablero.Tablero;
import Torres.Roja;

/**
 * Botón específico de la torre roja
 */
public class ButtonRoja extends ButtonComprable { 
	
	/**
	 * Crea un botón comprable.
	 * @param al El ActionListener asociado al botón
	 */
	public ButtonRoja(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/Rojo.png")));
        setToolTipText("<html> Torre Roja <br> Daño: A+ <br> Velocidad: A <br> Vida: D <br> Costo: 50 </html");
	}
	
	public void crearComprable(int x, int y) {
		Roja r = new Roja(x, y);
		if (r.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(r);
		}
		
	}
}
