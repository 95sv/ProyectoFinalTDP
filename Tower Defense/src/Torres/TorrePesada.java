package Torres;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoPesado;
import Mapa.Mapa;
import Tablero.Tablero;
import Visitor.Visitor;

public class TorrePesada extends Torre {

	//Crea una Torre Pesada
	
	public TorrePesada(int x, int y) {
		super(x, y, 150, 20, 6, 45);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Torres/Pesada.png"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		torreListener tl = new torreListener(this);
		jl.addMouseListener(tl);
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

	public class torreListener extends MouseAdapter {
		protected Torre miTorre;

		public torreListener(Torre miTorre) {
			this.miTorre = miTorre;
		}

		public void mouseClicked(MouseEvent e) {
			miTorre.getLabel().setBorder(BorderFactory.createLineBorder(Color.RED));
			Tablero.getInstance().vender(miTorre);
		}
	}

}
