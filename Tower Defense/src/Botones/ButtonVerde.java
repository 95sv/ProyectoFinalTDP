package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Tablero.Tablero;
import Torres.Verde;

/**
 * Bot�n espec�fico de la torre verde.
 */
public class ButtonVerde extends ButtonComprable {
	
	/**
	 * Crea un bot�n comprable.
	 * @param al El ActionListener asociado al bot�n
	 */
	public ButtonVerde(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/Verde.png")));
        setToolTipText("<html> Torre Verde <br> Da�o: B <br> Velocidad: B <br> Vida: B <br> Costo: 45 </html");
	}

	public void crearComprable(int x, int y) {
		Verde v = new Verde(x, y);
		if (v.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(new Verde(x, y));
		}		
	}
}
