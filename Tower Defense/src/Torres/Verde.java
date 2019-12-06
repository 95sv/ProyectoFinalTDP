package Torres;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoVerde;
import Mapa.Mapa;
import Tablero.Tablero;

public class Verde extends Torre {
	
	/**
	 * Crea una torre verde.
	 * @param x - La coordenada x de la torre
	 * @param y - La coordenada y de la torre
	 */
	public Verde(int x, int y) {
		super(x, y, 60, 15, 10, 45);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Torres/Verde.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		addLifeBar();
		addPUEffect();
	}
	
	protected void crearDisparo() {
		if (miPU!=null) {
			Tablero.getInstance().crearDisparo(new DisparoVerde(x, y, miPU.getDaño(daño), miPU.getVelocidad(velocidad)));
		}
		else {
			Tablero.getInstance().crearDisparo(new DisparoVerde(x, y, daño, velocidad));
		}	
	}

}
