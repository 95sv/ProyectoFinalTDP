package PowerUp;

import javax.swing.ImageIcon;

import Botones.LabelPowerUpTiempo;
import Mapa.Mapa;


 //Power-up que hace que el personaje afectado haga mas daño.
 
public class Fuerte extends PowerUpTiempo {

	
	public Fuerte(int x, int y) {
		super(x, y);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/PowerUp/Fuerza.png"));
		jl = new LabelPowerUpTiempo(this, icon);
		jl.addMouseListener(new UsarPowerUpTiempoListener());
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
	}
	
	public float getDaño(float daño) {
		return daño*1.5f;
	}

	public int getVelocidad(int vel) {
		return vel;
	}
	
	public float recibirDaño(float daño) {
		return daño;
	}

}
