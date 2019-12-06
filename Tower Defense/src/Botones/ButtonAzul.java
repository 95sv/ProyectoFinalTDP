package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Tablero.Tablero;
import Torres.Azul;

/**
 * Botón específico de la torre azul
 */
public class ButtonAzul extends ButtonComprable {
	
	/**
	 * Crea un botón comprable.
	 * @param al El ActionListener asociado al botón
	 */
	public ButtonAzul(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Resources/Torres/Azul.png")));
        setToolTipText("<html> Torre Azul <br> Daño: B <br> Velocidad: B <br> Vida: D <br> Costo: 35 </html");
	}	
	
	public void crearComprable(int x, int y) {
		Azul a = new Azul(x, y);
		if (a.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(a);
		}		
	}	
}
