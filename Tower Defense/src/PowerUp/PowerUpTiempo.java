package PowerUp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Botones.LabelPowerUpTiempo;
import Hilos.HiloPowerUp;
import Tablero.Tablero;


 //Un tipo de power-up que tiene un efecto temporal. Cambia el estado del personaje afectado por este power-up.
 
public abstract class PowerUpTiempo extends PowerUp {
	
	
	public PowerUpTiempo(int x, int y) {
		super(x, y);
	}

	
	public abstract float getDaño(float daño);
	
	
	public abstract int getVelocidad(int vel);
	
	
	public abstract float recibirDaño(float daño);
	
	
	protected class UsarPowerUpTiempoListener extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			LabelPowerUpTiempo btn = (LabelPowerUpTiempo) e.getSource();
			Tablero.getInstance().setPowerUp(btn.getPU());
			Tablero.getInstance().eliminarPU(btn.getPU());
			new HiloPowerUp(5).start();
		}
	}
	
}
