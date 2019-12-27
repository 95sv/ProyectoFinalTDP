package Objeto;

/**
 * Un tipo de objeto que el jugador puede comprar y ubicar en el mapa manualmente.
 */
public abstract class ObjetoComprable extends Objeto {
	
	protected int costo;
	

	public ObjetoComprable(int x, int y, int costo) {
		super(x, y);
		this.costo = costo;
	}
	

	public int getCosto() {
		return costo;
	}
	
}