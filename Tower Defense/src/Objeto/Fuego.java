package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Enemigos.EnemigoLejos;
import Mapa.Mapa;

/**
 * Obst�culo comprable temporal que da�a al enemigo mas cercano. 
 */
public class Fuego extends ObjetoComprable {
	
	private float da�o;

	/**
	 * Crea un objeto comprable
	 * @param x - La coordenada x del objeto
	 * @param y - La coordenada y del objeto
	 */
	public Fuego(int x, int y) {
		super(x, y, 20);
		da�o = 10;
		icon = new ImageIcon(this.getClass().getResource("/Recursos/ObjetosComprables/Fuego.png"));		
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
	public boolean visit(DisparoEnemigo d) {
		return true;
	}

	public boolean visit(EnemigoCerca e) {
		e.recibirDa�o(da�o/8);
		return false;
	}

	public boolean visit(EnemigoLejos e) {
		if (x-e.getX()<=Mapa.PIXEL) {
			e.recibirDa�o(da�o/8);
		}
		return false;
	}

}
