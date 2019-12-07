package Botones;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import Objeto.Barricada;
import Tablero.Tablero;

/**
 * Botón específico de la barricada
 */
public class ButtonBarricada extends ButtonComprable {

	/**
	 * Crea un botón comprable.
	 * @param al El ActionListener asociado al botón
	 */
	public ButtonBarricada(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/ObjetosComprables/Barricada.png")));
       // setToolTipText("<html> Barricada <br> Obstaculo destructible <br> Vida: C <br> Costo: 15 </html>");
	}	
	
	public void crearComprable(int x, int y) {
		Barricada b = new Barricada(x, y);
		if (b.getCosto()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearObjeto(b);
		}	
	}	
}
