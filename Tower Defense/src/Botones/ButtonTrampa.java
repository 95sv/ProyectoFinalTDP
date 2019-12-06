package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Objeto.Trampa;
import Tablero.Tablero;

/**
 * Botón específico de la trampa
 */
public class ButtonTrampa extends ButtonComprable {

	/**
	 * Crea un botón comprable.
	 * @param al El ActionListener asociado al botón
	 */
	public ButtonTrampa(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/ObjetosComprables/Trampa.png")));
        setToolTipText("<html> Trampa <br> Mata a quien lo toque <br> Costo: 60 </html>");        
	}	
	
	public void crearComprable(int x, int y) {
		Trampa t = new Trampa(x, y);
		if (t.getCosto()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearObjeto(new Trampa(x, y));	
		}			
	}
}
