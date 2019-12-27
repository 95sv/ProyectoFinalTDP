package Enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoTierra;
import Mapa.Mapa;
import Tablero.Tablero;
import Visitor.VisitorEnemigoLejos;

public class Verde extends EnemigoLejos{

	/**
	 * Crea un enemigo verde.
	 */
	
	public Verde(int x, int y) {
		super(x, y, 40, 10, 12, 15,3);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Verde.gif"));
		atacar = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/VerdeAtaque.gif"));
		mover = new ImageIcon(this.getClass().getResource("/Recursos/Enemigos/Verde.gif"));
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		cooldown = 0;
		addLifeBar();
		addPUEffect();
		miVisitor = new VisitorEnemigoLejos(this);
	}


	protected void crearDisparo() {
		if (miPU!=null) {
			Tablero.getInstance().crearDisparo(new DisparoTierra(x, y, miPU.getDaño(daño), miPU.getVelocidad(velocidad*2)));
		}
		else {
			Tablero.getInstance().crearDisparo(new DisparoTierra(x, y, daño, velocidad*2));
		}
		
	}

}
