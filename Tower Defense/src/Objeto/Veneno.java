package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Enemigos.EnemigoLejos;
import Hilos.HiloVeneno;
import Tablero.Tablero;
import Visitor.Visitor;
import Visitor.VisitorVeneno;
import Mapa.Mapa;

/**
 * Objeto comprable que envenena a todos los enemigos cuando es tocado por un enemigo.
 * @author Goinza
 *
 */
public class Veneno extends ObjetoComprable {

	/**
	 * Crea un objeto comprable
	 * @param x - La coordenada x del objeto
	 * @param y - La coordenada y del objeto
	 */
	public Veneno(int x, int y) {
		super(x, y, 20);
		icon = new ImageIcon(this.getClass().getResource("/Recursos/ObjetosComprables/Veneno.png"));		
		jl = new JLabel(icon);
		jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);
		miVisitor = new VisitorVeneno(this);
	}
	
	public boolean visit(EnemigoCerca e) {
		HiloVeneno hv = new HiloVeneno();
		hv.start();
		Tablero.getInstance().eliminarObjeto(this);
		return false;
	}
	
	public boolean visit(EnemigoLejos e) {
		if (x-e.getX()<=Mapa.PIXEL) {
			HiloVeneno hv = new HiloVeneno();
			hv.start();
			Tablero.getInstance().eliminarObjeto(this);
		}
		return false;
	}
	
	public boolean visit(DisparoEnemigo e) {
		return false;
	}

	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}

}