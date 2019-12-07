package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Tablero.Tablero;
import Torres.TorrePesada;

/**
 * Bot�n espec�fico de la torre pesada.
 */
public class ButtonAvanzada extends ButtonComprable {

	/**
	 * Crea un bot�n comprable.
	 * @param al El ActionListener asociado al bot�n
	 */
	public ButtonAvanzada(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/Pesada.png")));
        //setToolTipText("<html> Torre Pesada <br> Da�o: B <br> Velocidad: D <br> Vida: A+ <br> Costo: 45 </html");
	}
	
	public void crearComprable(int x, int y) {
		TorrePesada p = new TorrePesada(x,y);
		if (p.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(p);
		}		
	}
}
