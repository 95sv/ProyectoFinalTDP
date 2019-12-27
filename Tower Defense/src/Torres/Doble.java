package Torres;

import Disparo.DisparoArena;
import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Tablero.Tablero;

/**
 * Clase que representa una de las mitades de la torre doble.
 * Como un objeto representa la mitad de la torre, debe tener una referencia a la otra mitad 
 * para mantener la misma cantidad de vida y que ambas mitades sean destruidas al mismo tiempo.
 */
public abstract class Doble extends Torre {
	
	private Doble mitad;

	public Doble(int x, int y, float maxVida, float da�o, int velocidad, int costo) {
		super(x, y, maxVida, da�o, velocidad, costo);
	}

	protected void crearDisparo() {
		if (miPU!=null) {
			Tablero.getInstance().crearDisparo(new DisparoArena(x, y, miPU.getDa�o(da�o), miPU.getVelocidad(velocidad)));
		}
		else {
			Tablero.getInstance().crearDisparo(new DisparoArena(x, y, da�o, velocidad));
		}	
	}
	
	public void setMitad(Doble mitad) {
		this.mitad = mitad;
	}
	
	public void actualizarVida(float vida) {
		this.vida = vida;
		if (this.vida<=0) {
			morir();
		}
	}
	
	public void recibirDa�o(float da�o) {
		super.recibirDa�o(da�o);
		mitad.actualizarVida(vida);
	}
	

}
