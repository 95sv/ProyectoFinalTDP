package Torres;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoRojo;
import Mapa.Mapa;
import Tablero.Tablero;

public class Roja extends Torre {
	
	/**
	 * Crea una torre roja.
	 * @param x - La coordenada x de la torre
	 * @param y - La coordenada y de la torre
	 */
	public Roja(int x, int y) {
		super(x, y, 20, 30, 14, 50);
		icon = new ImageIcon(this.getClass().getResource("/Resources/Torres/Rojo.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		addLifeBar();
		addPUEffect();
	}
	
	protected void crearDisparo() {
		if (miPU!=null) {
			Tablero.getInstance().crearDisparo(new DisparoRojo(x, y, miPU.getDaño(daño), miPU.getVelocidad(velocidad)));
		}
		else {
			Tablero.getInstance().crearDisparo(new DisparoRojo(x, y, daño, velocidad));
		}	
	}

}
