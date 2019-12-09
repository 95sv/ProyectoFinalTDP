package Torres;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoBasico;
import Mapa.Mapa;
import Tablero.Tablero;
import Visitor.Visitor;

public class TorreArena extends Torre {

	/**
	 * Crea una torre básica.
	 * 
	 * @param x - La coordenada x de la torre
	 * @param y - La coordenada y de la torre
	 */
	public TorreArena(int x, int y) {
		super(x, y, 50, 10, 8, 30);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreArena.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		addLifeBar();
		addPUEffect();
	}

	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}

	protected void crearDisparo() {
		if (miPU != null) {
			Tablero.getInstance()
					.crearDisparo(new DisparoBasico(x, y, miPU.getDaño(daño), miPU.getVelocidad(velocidad)));
		} else {
			Tablero.getInstance().crearDisparo(new DisparoBasico(x, y, daño, velocidad));
		}
	}

}
