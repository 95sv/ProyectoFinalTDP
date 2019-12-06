package PowerUp;

import javax.swing.ImageIcon;

import Botones.LabelPowerUpInstantaneo;
import Mapa.Mapa;
import Tablero.Tablero;

/**
 * Power-up que congela por un tiempo a los enemigos.
 */
public class Hielo extends PowerUpInstantaneo {

	/**
	 * Crea un power-up.
	 * @param x - La coordenada x del power-up
	 * @param y - La coordenada y del power-up
	 */
	public Hielo(int x, int y) {
		super(x, y);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/PowerUp/Hielo.png"));
		jl = new LabelPowerUpInstantaneo(this, icon);
		jl.addMouseListener(new UsarPowerUpInstantaneoListener());
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
	public void efecto() {
		Tablero.getInstance().congelarEnemigos(5);
	}

}
