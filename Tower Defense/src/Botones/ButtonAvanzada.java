package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Tablero.Tablero;
import Torres.TorrePesada;

/**
 * Botón específico de la torre pesada.
 */
public class ButtonAvanzada extends ButtonComprable {

	/**
	 * Crea un botón comprable.
	 * @param al El ActionListener asociado al botón
	 */
	public ButtonAvanzada(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/Pesada.png")));
        //setToolTipText("<html> Torre Pesada <br> Daño: B <br> Velocidad: D <br> Vida: A+ <br> Costo: 45 </html");
	}
	
	public void crearComprable(int x, int y) {
		TorrePesada p = new TorrePesada(x,y);
		if (p.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(p);
		}		
	}
}
