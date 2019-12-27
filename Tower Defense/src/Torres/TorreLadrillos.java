package Torres;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoLadrillo;
import Mapa.Mapa;
import Tablero.Tablero;
import Visitor.Visitor;

public class TorreLadrillos extends Torre {
	
	//Crea una Torre Ladrillo
	
	public TorreLadrillos(int x, int y) {
		super(x, y, 20, 30, 14, 50);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Torres/TorreLadrillos.png"));
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
		if (miPU!=null) {
			Tablero.getInstance().crearDisparo(new DisparoLadrillo(x, y, miPU.getDaño(daño), miPU.getVelocidad(velocidad)));
		}
		else {
			Tablero.getInstance().crearDisparo(new DisparoLadrillo(x, y, daño, velocidad));
		}	
	}
	
	public class torreListener extends MouseAdapter{
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
