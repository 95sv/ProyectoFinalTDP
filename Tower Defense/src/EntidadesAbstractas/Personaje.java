package EntidadesAbstractas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Mapa;
import PowerUp.PowerUpTiempo;
import Visitor.Visitor;


 //Clase que representa los personajes del juego, tanto las torres puestas por el jugador como los enemigos.

 
public abstract class Personaje extends Entidad {
	
	protected float maxVida;
	protected float vida;
	protected float daño;
	protected int velocidad;	
	protected int valor;
	protected JLabel lifeBar;
	protected JLabel effect;
	protected PowerUpTiempo miPU;
	
	
	public Personaje(int x, int y, float maxVida, float daño, int velocidad, int valor) {
		super(x, y);
		this.maxVida = maxVida;
		vida = maxVida;
		this.daño = daño;
		this.velocidad = velocidad;
		this.valor = valor;
	}	
	
	
	public abstract boolean aceptar(Visitor v);
	
	public float getVida() {
		return vida;
	}
	
	
	public boolean fullVida() {
		return vida/maxVida==1;
	}
	
	
	public float getDaño() {
		if (miPU!=null) {
			return miPU.getDaño(daño);
		}
		else {
			return daño;
		}		
	}
	
	
	public int getValor() {
		return valor;
	}
	
	
	public abstract void accion();
	
	
	public void recuperarVida() {
		vida = maxVida;
		updateLifeBar();
	}
	
	
	public void recibirDaño(float daño) {
		if (miPU!=null) {
			vida -= miPU.recibirDaño(daño);
		}
		else {
			vida -= daño;
		}	
		if (vida<=0) {
			morir();
		}
		updateLifeBar();
	}


	public void setPowerUp(PowerUpTiempo pu) {
		miPU = pu;
		updateEffect(pu!=null);
	}
	
	
	protected void addLifeBar() {
		lifeBar = new JLabel(new ImageIcon(this.getClass().getResource("/Recursos/BarraVida.png")));
		jl.add(lifeBar);
		updateLifeBar();
	}
	
	
	protected void addPUEffect() {
		effect = new JLabel();
		jl.add(effect);
		effect.setBounds(0, 0, Mapa.PIXEL, Mapa.PIXEL);
	}
	
	
	protected void updateLifeBar() {
		if (lifeBar!=null) {
			lifeBar.setBounds(0, Mapa.PIXEL-8, Math.round(vida/maxVida*Mapa.PIXEL), 8);
		}		
	}
	
	
	protected void updateEffect(boolean hayPU) {
		if (effect!=null) {
			if (hayPU) {
				effect.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/PowerUpEffect.gif")));
			}
			else {
				effect.setIcon(null);
			}
		}		
	}
	
}
