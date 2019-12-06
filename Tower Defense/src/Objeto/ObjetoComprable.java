package Objeto;

/**
 * Un tipo de objeto que el jugador puede comprar y ubicar en el mapa manualmente.
 */
public abstract class ObjetoComprable extends Objeto {
	
	protected int costo;
	
	/**
	 * Crea un objeto comprable
	 * @param x - La coordenada x del objeto
	 * @param y - La coordenada y del objeto
	 * @param costo - El costo de comprar este objeto
	 */
	public ObjetoComprable(int x, int y, int costo) {
		super(x, y);
		this.costo = costo;
	}
	
	/**
	 * Retorna el costo del objeto.
	 * @return El costo del objeto
	 */
	public int getCosto() {
		return costo;
	}
	
}