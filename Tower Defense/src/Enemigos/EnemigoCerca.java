package Enemigos;

import EntidadesAbstractas.Entidad;
import Mapa.Mapa;
import Tablero.Tablero;
import Visitor.Visitor;
import Visitor.VisitorEnemigoCerca;

 //Un tipo de enemigo que ataca de cerca. El daño que realiza es por segundo.
 
public abstract class EnemigoCerca extends Enemigo {


	public EnemigoCerca(int x, int y, float maxVida, float daño, int velocidad, int valor) {
		super(x, y, maxVida, daño, velocidad, valor);
		miVisitor = new VisitorEnemigoCerca(this);
	}
	
	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}
	
	public void accion() {
		if (x>=Mapa.PIXEL*Mapa.MAX_ANCHO) {
			Tablero.getInstance().gameOver(false);
		}
		else {
			Entidad e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL+1, y/Mapa.PIXEL); //Entidad de la celda siguiente
			if (e!=null) {
				if (e.aceptar(miVisitor)) {
					jl.setIcon(atacar);
				}
				else {
					//jl.setIcon(icon); 
					x+= velocidad;
					jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);		
					jl.setIcon(mover);
				}
			}
			else {
				if (miPU!=null) {
					x+= miPU.getVelocidad(velocidad);
				}
				else {
					x+= velocidad;
				}		
				jl.setBounds(x, y, Mapa.PIXEL, Mapa.PIXEL);		
				jl.setIcon(mover);
			}
		}		
	}	
}
