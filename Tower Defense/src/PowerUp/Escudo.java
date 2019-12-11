package PowerUp;

import javax.swing.ImageIcon;

import Botones.LabelPowerUpTiempo;
import Mapa.Mapa;

/**
 * Power-up que hace invulnerable al peronsaje que lo afecta.
 */
public class Escudo extends PowerUpTiempo {
	
	
	public Escudo(int x, int y) {
		super(x, y);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/PowerUp/Escudo.png"));
		jl = new LabelPowerUpTiempo(this, icon);
		jl.addMouseListener(new UsarPowerUpTiempoListener());
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}

	public float getDa�o(float da�o) {
		return da�o;
	}

	public int getVelocidad(int vel) {
		return vel;
	}

	public float recibirDa�o(float da�o) {
		return 0;
	}

}
