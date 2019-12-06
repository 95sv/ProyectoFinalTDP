package Torres;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoAzul;
import Mapa.Mapa;
import Tablero.Tablero;

public class Azul extends Torre {

	/**
	 * Crea una torre azul.
	 * @param x - La coordenada x de la torre
	 * @param y - La coordenada y de la torre
	 */
	public Azul(int x, int y) {
		super(x, y, 30, 15, 10, 35);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Torres/Azul.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		addLifeBar();
		addPUEffect();
	}
	
	protected void crearDisparo() {
		if (miPU!=null) {
			Tablero.getInstance().crearDisparo(new DisparoAzul(x, y, miPU.getDaño(daño), miPU.getVelocidad(velocidad)));
		}
		else {
			Tablero.getInstance().crearDisparo(new DisparoAzul(x, y, daño, velocidad));
		}		
	}

}
