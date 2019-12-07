package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Hilos.HiloTiempo;
import Objeto.Fuego;
import Tablero.Tablero;

/**
 * Bot�n espec�fico de fuego
 */
public class ButtonFuego extends ButtonComprable {

	/**
	 * Crea un bot�n comprable.
	 * @param al El ActionListener asociado al bot�n
	 */
	public ButtonFuego(ActionListener al) {
		super(al);
		setIcon(new ImageIcon(this.getClass().getResource("/Recursos/ObjetosComprables/Fuego.gif")));
		//setToolTipText("<html> Fuego <br> Obstaculo indestructible que da�a a quien lo toque <br> Da�o: C <br> Tiempo: 5 seg <br> Costo: 20 </html>");
	}

	public void crearComprable(int x, int y) {
		Fuego f = new Fuego(x, y);
		if (f.getCosto()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearObjeto(f);
			HiloTiempo ht = new HiloTiempo(f, 5);
			ht.start();
		}
	}
}
