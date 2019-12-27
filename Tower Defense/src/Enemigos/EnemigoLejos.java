package Enemigos;

import EntidadesAbstractas.Entidad;
import Mapa.Mapa;
import Tablero.Tablero;
import Visitor.Visitor;
import Visitor.VisitorEnemigoLejos;


 // Un tipo de enemigo que ataca de lejos. El daño que realiza es por disparo.

public abstract class EnemigoLejos extends Enemigo {

	protected int alcance;
	protected float cooldown;
	

	public EnemigoLejos(int x, int y, float maxVida, float daño, int velocidad, int valor, int alcance) {
		super(x, y, maxVida, daño, velocidad, valor);
		this.alcance = alcance;
		miVisitor = new VisitorEnemigoLejos(this);
	}
	
	public boolean aceptar(Visitor v) {
		return v.visit(this);
	}
	
	public void accion() {
		if (x>=Mapa.PIXEL*Mapa.MAX_ANCHO) {
			Tablero.getInstance().gameOver(false);
		}
		else {
			if (cooldown<=0) {
				Entidad e = null;
				boolean encontre = false;
				int i = 1;
				while (!encontre && i<=alcance && (x/Mapa.PIXEL+i<=Mapa.MAX_ANCHO) && (x/Mapa.PIXEL+i>=0)) {
					e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL+i, y/Mapa.PIXEL);
					if (e!=null) {
						encontre = e.aceptar(miVisitor);
					}	
					i++;
				}
				//Dispara si hay enemigo, sino camina en caso de que la siguiente celda este vacia
				if (encontre && x>0) {
					crearDisparo();
					cooldown = 10;
					jl.setIcon(atacar);
				}
				else {
					e = Tablero.getInstance().getEntidad(x/Mapa.PIXEL+1, y/Mapa.PIXEL); //Entidad de la celda siguiente
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
			else {
				cooldown -= 1;
			}
		}		
	}
	
	/**
	 * Crea un disparo. El tipo de disparo que cree depende del tipo de enemigo que lance dicho disparo.
	 */
	protected abstract void crearDisparo();
	
}
