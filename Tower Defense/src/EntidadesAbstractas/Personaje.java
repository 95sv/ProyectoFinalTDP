package EntidadesAbstractas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Mapa;
import PowerUp.PowerUpTiempo;

/**
 * Clase que representa los personajes del juego, tanto las torres puestas por el jugador como los enemigos.
 * Los personajes son capaces de moverse y atacar.
 */
public abstract class Personaje extends Entidad {
	
	protected float maxVida;
	protected float vida;
	protected float da�o;
	protected int velocidad;	
	protected int valor;
	protected JLabel lifeBar;
	protected JLabel effect;
	protected PowerUpTiempo miPU;
	
	/**
	 * Crea un personaje
	 * @param x - La coordenada x del personaje
	 * @param y - La coordenada y del personaje
	 * @param maxVida - La vida maxima. Esta es la vida con la que empieza el personaje
	 * @param da�o - Da�o por segundo si ataca de cerca o por disparo si ataca de lejos
	 * @param velocidad - La velocidad del personaje
	 * @param valor - El valor del personaje. Puede ser el costo de compra o la recompensa por derrotarlo o venderlo.
	 */
	public Personaje(int x, int y, float maxVida, float da�o, int velocidad, int valor) {
		super(x, y);
		this.maxVida = maxVida;
		vida = maxVida;
		this.da�o = da�o;
		this.velocidad = velocidad;
		this.valor = valor;
	}	
	
	/**
	 * Retorna la vida actual del personaje
	 * @return La vida actual.
	 */
	public float getVida() {
		return vida;
	}
	
	/**
	 * Determina si el personaje tiene toda la vida o no.
	 * @return True si tiene la maxima vida posible, false en caso contrario
	 */
	public boolean fullVida() {
		return vida/maxVida==1;
	}
	
	/**
	 * Retorna el da�o del personaje. El da�o es por segundo si ataca de cerca o por disparo si ataca de lejos.
	 * @return EL da�o del personaje
	 */
	public float getDa�o() {
		if (miPU!=null) {
			return miPU.getDa�o(da�o);
		}
		else {
			return da�o;
		}		
	}
	
	/**
	 * Retoran el valor del personaje. Esto representa el costo de comprarlo o la recompensa que otorga al ser derrotado o vendido.
	 * @return El valor del personaje
	 */
	public int getValor() {
		return valor;
	}
	
	/**
	 * Realiza una acci�n. Esto puede ser mover o atacar, dependiendo de si tiene un objetivo a su alcance o no.
	 */
	public abstract void accion();
	
	/**
	 * Recupera su vida, volviendo al valor de cuando fue creado.
	 */
	public void recuperarVida() {
		vida = maxVida;
		updateLifeBar();
	}
	
	/**
	 * Recibe da�o. Si pierde toda la vida, es destruido del tablero.
	 * @param da�o - El da�o que recibe
	 */
	public void recibirDa�o(float da�o) {
		if (miPU!=null) {
			vida -= miPU.recibirDa�o(da�o);
		}
		else {
			vida -= da�o;
		}	
		if (vida<=0) {
			morir();
		}
		updateLifeBar();
	}

	/**
	 * Se aplica un power-up al personaje, pudiendo cambiar el da�o, velocidad y resistencia al da�o.
	 * Si el parametro es null significa que se le quita el power-up que ten�a.
	 * @param pu - El power-up.
	 */
	public void setPowerUp(PowerUpTiempo pu) {
		miPU = pu;
		updateEffect(pu!=null);
	}
	
	/**
	 * Se agrega la barra de vida al personaje. Esta operaci�n se utiliza al crear el personaje.
	 */
	protected void addLifeBar() {
		lifeBar = new JLabel(new ImageIcon(this.getClass().getResource("/Resources/BarraVida.png")));
		jl.add(lifeBar);
		updateLifeBar();
	}
	
	/**
	 * Se agrega el efecto del power-up, que por defecto no tiene icono, representando el estado de no tener power-up.
	 * Esta operaci�n se utiliza la crear el personaje.
	 */
	protected void addPUEffect() {
		effect = new JLabel();
		jl.add(effect);
		effect.setBounds(0, 0, Mapa.PIXEL, Mapa.PIXEL);
	}
	
	/**
	 * Se actualiza la barra de vida para reflejar la vida actual. Debe ser llamado cada vez que la vida del personaje es cambiada.
	 */
	protected void updateLifeBar() {
		if (lifeBar!=null) {
			lifeBar.setBounds(0, Mapa.PIXEL-8, Math.round(vida/maxVida*Mapa.PIXEL), 8);
		}		
	}
	
	/**
	 * Se actualiza el efecto del power-up. Debe ser llamado cada vez que se aplica o remueve un power-up. 
	 * @param hayPU - True si hay power-up activo, false en caso contrario
	 */
	protected void updateEffect(boolean hayPU) {
		if (effect!=null) {
			if (hayPU) {
				effect.setIcon(new ImageIcon(this.getClass().getResource("/Resources/PowerUpEffect.gif")));
			}
			else {
				effect.setIcon(null);
			}
		}		
	}
	
}
