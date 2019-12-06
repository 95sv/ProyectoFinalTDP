package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Enemigos.EnemigoLejos;
import Tablero.Tablero;
import Mapa.Mapa;

/**
 * Objeto comprable que destruye el primer enemigo que lo toca.
 */
public class Trampa extends ObjetoComprable {
	
	/**
	 * Crea un objeto comprable
	 * @param x - La coordenada x del objeto
	 * @param y - La coordenada y del objeto
	 */
	public Trampa(int x, int y) {
		super(x, y, 60);
		icon = new ImageIcon(this.getClass().getResource("/Resources/ObjetosComprables/Trampa.png"));		
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}

	public boolean visit(EnemigoCerca e) {
		e.morir();
		Tablero.getInstance().eliminarObjeto(this);
		return false;
	}
	
	public boolean visit(EnemigoLejos e) {
		//SI ESTA PISANDO LA TRAMPA, ENTONCES SE ACTIVA (TRUE), SINO SIGUE CAMINANDO (FALSE)
		if (Tablero.getInstance().getEntidad(x/Mapa.PIXEL-1, y/Mapa.PIXEL)==e) {
			e.morir();
			Tablero.getInstance().eliminarObjeto(this);
			return true;
		}
		else {
			return false;
		}		
	}
	
	public boolean visit(DisparoEnemigo e) {
		return false;
	}

}
