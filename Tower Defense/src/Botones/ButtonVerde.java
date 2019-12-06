package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Tablero.Tablero;
import Torres.Verde;

/**
 * Botón específico de la torre verde.
 */
public class ButtonVerde extends ButtonComprable {
	
	/**
	 * Crea un botón comprable.
	 * @param al El ActionListener asociado al botón
	 */
	public ButtonVerde(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/Verde.png")));
        setToolTipText("<html> Torre Verde <br> Daño: B <br> Velocidad: B <br> Vida: B <br> Costo: 45 </html");
	}

	public void crearComprable(int x, int y) {
		Verde v = new Verde(x, y);
		if (v.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(new Verde(x, y));
		}		
	}
}
