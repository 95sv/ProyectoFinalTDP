package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Enemigos.EnemigoLejos;

/**
 * Objeto temporal que impide el paso a los enemigos.
 */
public class Lago extends Objeto {

	/**
	 * Crea un objeto
	 * @param x - La coordenada x del objeto
	 * @param y - La coordenada y del objeto
	 */
	public Lago(int x, int y) {
		super(x, y);
		icon = new ImageIcon(this.getClass().getResource("/Resources/Objetos/Lago.png"));
		jl = new JLabel(icon);		
	}
	
	public boolean visit(EnemigoCerca e) {
		return false;
	}
	
	public boolean visit(EnemigoLejos e) {
		return false;
	}
	
	public boolean visit(DisparoEnemigo e) {
		return false;
	}
}
