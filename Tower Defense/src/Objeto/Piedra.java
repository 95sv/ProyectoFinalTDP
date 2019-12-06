package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Enemigos.EnemigoLejos;
import Mapa.Mapa;

/**
 * Obstáculo que impide el paso de los enemigos. Puede ser destruido por ataques.
 */
public class Piedra extends Objeto {
	
	private float vida;
	
	/**
	 * Crea un objeto
	 * @param x - La coordenada x del objeto
	 * @param y - La coordenada y del objeto
	 */
	public Piedra(int x, int y) {
		super(x, y);
		vida = 25;
		icon = new ImageIcon(this.getClass().getResource("/Resources/Objetos/Piedra.png"));		
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
	public boolean visit(EnemigoCerca e) {
		vida -= e.getDaño()/8;
		if (vida<=0) {
			morir();
		}
		return true;
	}
	
	public boolean visit(EnemigoLejos e) {
		return true;
	}
	
	public boolean visit(DisparoEnemigo e) {
		vida -= e.getDaño();
		if (vida<=0) {
			morir();
		}
		return true;
	}
}
