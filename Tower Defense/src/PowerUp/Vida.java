package PowerUp;

import javax.swing.ImageIcon;

import Botones.LabelPowerUpInstantaneo;
import Tablero.Tablero;
import Mapa.Mapa;

/**
 * Power-up que recupera la vida de todas las torres del jugador.
 */
public class Vida extends PowerUpInstantaneo {

	/**
	 * Crea un power-up.
	 * @param x - La coordenada x del power-up
	 * @param y - La coordenada y del power-up
	 */
	public Vida(int x, int y) {
		super(x, y);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/PowerUp/Vida.png"));
		jl = new LabelPowerUpInstantaneo(this, icon);
		jl.addMouseListener(new UsarPowerUpInstantaneoListener());
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
	public void efecto() {
		Tablero.getInstance().recuperarVidaJugadores();
	}

}
