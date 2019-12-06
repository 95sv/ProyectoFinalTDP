package PowerUp;

import javax.swing.ImageIcon;

import Botones.LabelPowerUpTiempo;
import Mapa.Mapa;

/**
 * Power-up que hace invulnerable al peronsaje que lo afecta.
 */
public class Escudo extends PowerUpTiempo {
	
	/**
	 * Crea un power-up.
	 * @param x - La coordenada x del power-up
	 * @param y - La coordenada y del power-up
	 */
	public Escudo(int x, int y) {
		super(x, y);
		icon = new ImageIcon(this.getClass().getResource("/Resources/PowerUps/Escudo.png"));
		jl = new LabelPowerUpTiempo(this, icon);
		jl.addMouseListener(new UsarPowerUpTiempoListener());
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}

	public float getDaño(float daño) {
		return daño;
	}

	public int getVelocidad(int vel) {
		return vel;
	}

	public float recibirDaño(float daño) {
		return 0;
	}

}
