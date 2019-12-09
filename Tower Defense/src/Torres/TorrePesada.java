package Torres;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoPesado;
import Mapa.Mapa;
import Tablero.Tablero;
import Visitor.Visitor;

public class TorrePesada extends Torre {

	/**
	 * Crea una torre pesada.
	 * 
	 * @param x - La coordenada x de la torre
	 * @param y - La coordenada y de la torre
	 */
	public TorrePesada(int x, int y) {
		super(x, y, 150, 20, 6, 45);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Torres/Pesada.png"));
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
					.crearDisparo(new DisparoPesado(x, y, miPU.getDaño(daño), miPU.getVelocidad(velocidad)));
		} else {
			Tablero.getInstance().crearDisparo(new DisparoPesado(x, y, daño, velocidad));
		}
	}
}
