package Botones;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import Tablero.Tablero;
import Torres.TorreControl;


public class BotonTorreControl extends ButtonComprable {
	
	/**
	 * Crea un botón comprable.
	 * @param al El ActionListener asociado al botón
	 */
	public BotonTorreControl(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreControl.png")));
        //setToolTipText("<html> Torre Verde <br> Daño: B <br> Velocidad: B <br> Vida: B <br> Costo: 45 </html");
	}

	public void crearComprable(int x, int y) {
		TorreControl v = new TorreControl(x, y);
		if (v.getValor()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearJugador(new TorreControl(x, y));
		}		
	}
}
