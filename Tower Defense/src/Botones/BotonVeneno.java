package Botones;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Objeto.Veneno;
import Tablero.Tablero;


@SuppressWarnings("serial")
public class BotonVeneno extends BotonComprable {

	//Boton para comprar Veneno
	
	public BotonVeneno(ActionListener al) {
		super(al);
        setIcon(new ImageIcon(this.getClass().getResource("/Recursos/ObjetosComprables/Veneno.png")));
        
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
