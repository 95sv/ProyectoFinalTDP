package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Objeto.Veneno;
import Tablero.Tablero;


public class ButtonVeneno extends ButtonComprable {

	/**
	 * Crea un botón comprable.
	 * @param al El ActionListener asociado al botón
	 */
	public ButtonVeneno(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/ObjetosComprables/Veneno.png")));
        setToolTipText("<html> Veneno <br> Se activa con contacto enemigo <br> Daño: C <br> Tiempo: 5 seg <br> Costo: 20 </html>");
	}	
	
	public void crearComprable(int x, int y) {
		//ACTIVARLO CUANDO ENTRA EN CONTACTO CON UN ENEMIGO O CUANDO SE PONE EN EL TABLERO??
		//Tablero.getInstance().crearObjeto(new Veneno(x, y));
		//Envenena todos los enemigos por 5 seg
		Veneno v = new Veneno(x, y);
		if (v.getCosto()<=Tablero.getInstance().getMonedas()) {
			Tablero.getInstance().crearObjeto(v);			
		}		
	}	
}
