package Enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoTierra;
import Mapa.Mapa;
import Tablero.Tablero;

public class Tierra extends EnemigoLejos {

	/**
	 * Crea un elfo.
	 * @param x - La coordenada x del enemigo
	 * @param y - La coordenada y del enemigo
	 */
	public Tierra(int x, int y) {
		super(x, y, 50, 10, 4, 20, 3);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Tierra.gif"));
		atacar = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/TierraAtaque.gif"));
		mover = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Tierra.gif"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		cooldown = 0;
		addLifeBar();
		addPUEffect();
	}
	
	protected void crearDisparo() {
		if (miPU!=null) {
			Tablero.getInstance().crearDisparo(new DisparoTierra(x, y, miPU.getDaño(daño), miPU.getVelocidad(velocidad*2)));
		}
		else {
			Tablero.getInstance().crearDisparo(new DisparoTierra(x, y, daño, velocidad*2));
		}
		
	}

}
