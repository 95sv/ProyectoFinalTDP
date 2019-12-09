package Torres;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoRojo;
import Mapa.Mapa;
import Tablero.Tablero;
import Visitor.Visitor;

public class TorreLadrillos extends Torre {
	
	/**
	 * Crea una torre roja.
	 * @param x - La coordenada x de la torre
	 * @param y - La coordenada y de la torre
	 */
	public TorreLadrillos(int x, int y) {
		super(x, y, 20, 30, 14, 50);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreLadrillos.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		addLifeBar();
		addPUEffect();
	}
	

	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}
	
	protected void crearDisparo() {
		if (miPU!=null) {
			Tablero.getInstance().crearDisparo(new DisparoRojo(x, y, miPU.getDaño(daño), miPU.getVelocidad(velocidad)));
		}
		else {
			Tablero.getInstance().crearDisparo(new DisparoRojo(x, y, daño, velocidad));
		}	
	}

}
