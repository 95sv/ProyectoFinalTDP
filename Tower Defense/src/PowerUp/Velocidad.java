package PowerUp;

import javax.swing.ImageIcon;

import Botones.LabelPowerUpTiempo;
import Mapa.Mapa;


 //Power-up que hace a un personaje m�s r�pido el movimiento y/o la velocida de su disparo.
 
public class Velocidad extends PowerUpTiempo {


	public Velocidad(int x, int y) {
		super(x, y);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/PowerUp/Velocidad.png"));
		jl = new LabelPowerUpTiempo(this, icon);
		jl.addMouseListener(new UsarPowerUpTiempoListener());
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
	public float getDa�o(float da�o) {
		return da�o;
	}

	public int getVelocidad(int vel) {
		return vel*2;
	}

	public float recibirDa�o(float da�o) {
		return da�o;
	}
	
}
