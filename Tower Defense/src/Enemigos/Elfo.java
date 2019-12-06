package Enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoElfo;
import Mapa.Mapa;
import Tablero.Tablero;

public class Elfo extends EnemigoLejos {

	/**
	 * Crea un elfo.
	 * @param x - La coordenada x del enemigo
	 * @param y - La coordenada y del enemigo
	 */
	public Elfo(int x, int y) {
		super(x, y, 50, 10, 4, 20, 3);
		icon = new ImageIcon(this.getClass().getResource("/Resources/Enemigos/Elfo.png"));
		atacar = new ImageIcon(this.getClass().getResource("/Resources/Enemigos/Elfo_a.gif"));
		mover = new ImageIcon(this.getClass().getResource("/Resources/Enemigos/Elfo_c.gif"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		cooldown = 0;
		addLifeBar();
		addPUEffect();
	}
	
	protected void crearDisparo() {
		if (miPU!=null) {
			Tablero.getInstance().crearDisparo(new DisparoElfo(x, y, miPU.getDaño(daño), miPU.getVelocidad(velocidad*2)));
		}
		else {
			Tablero.getInstance().crearDisparo(new DisparoElfo(x, y, daño, velocidad*2));
		}
		
	}

}
