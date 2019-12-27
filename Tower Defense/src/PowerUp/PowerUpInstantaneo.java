package PowerUp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Botones.LabelPowerUpInstantaneo;
import Tablero.Tablero;


 // Tipo de power-up que tiene un efecto inmediato.
 
public abstract class PowerUpInstantaneo extends PowerUp {
	
	public PowerUpInstantaneo(int x, int y) {
		super(x, y);
	}
	
	public abstract void efecto();
	
	
	protected class UsarPowerUpInstantaneoListener extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			LabelPowerUpInstantaneo btn = (LabelPowerUpInstantaneo) e.getSource();
			btn.getPU().efecto();
			Tablero.getInstance().eliminarPU(btn.getPU());
		}	
	}

}
