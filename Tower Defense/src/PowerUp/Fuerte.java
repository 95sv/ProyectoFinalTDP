package PowerUp;

import javax.swing.ImageIcon;

import Botones.LabelPowerUpTiempo;
import Mapa.Mapa;

/**
 * Power-up que hace que el personaje afectado haga mas da�o.
 */
public class Fuerte extends PowerUpTiempo {

	/**
	 * Crea un power-up.
	 * @param x - La coordenada x del power-up
	 * @param y - La coordenada y del power-up
	 */
	public Fuerte(int x, int y) {
		super(x, y);
		icon = new ImageIcon(this.getClass().getResource("/Resources/PowerUps/Fuerza.png"));
		jl = new LabelPowerUpTiempo(this, icon);
		jl.addMouseListener(new UsarPowerUpTiempoListener());
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
	public float getDa�o(float da�o) {
		return da�o*1.5f;
	}

	public int getVelocidad(int vel) {
		return vel;
	}
	
	public float recibirDa�o(float da�o) {
		return da�o;
	}

}
