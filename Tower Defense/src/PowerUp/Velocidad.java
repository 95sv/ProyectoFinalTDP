package PowerUp;

import javax.swing.ImageIcon;

import Botones.LabelPowerUpTiempo;
import Mapa.Mapa;


 //Power-up que hace a un personaje más rápido el movimiento y/o la velocida de su disparo.
 
public class Velocidad extends PowerUpTiempo {


	public Velocidad(int x, int y) {
		super(x, y);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/PowerUp/Velocidad.png"));
		jl = new LabelPowerUpTiempo(this, icon);
		jl.addMouseListener(new UsarPowerUpTiempoListener());
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
	public float getDaño(float daño) {
		return daño;
	}

	public int getVelocidad(int vel) {
		return vel*2;
	}

	public float recibirDaño(float daño) {
		return daño;
	}
	
}
