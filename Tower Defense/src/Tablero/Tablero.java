package Tablero;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;

import Disparo.*;
import Enemigos.*;
import EntidadesAbstractas.Entidad;
import EntidadesAbstractas.Personaje;
import Gui.Gui;
import Hilos.*;
import Mapa.*;
import Objeto.Objeto;
import Objeto.ObjetoComprable;
import PowerUp.*;
import Torres.Torre;

/**
 * Clase que maneja toda la lógica del juego.
 * Debido a que aplica el patron Singleton, solo puede existir una instancia de tablero.
 * Particularmente, maneja la creación y eliminación de entidades, además del movimiento de personajes y disparos.
 * Las entidades las guarda en un mapa para que sea mas fácil manejar la colisión entre ellas.
 */
public class Tablero {
	
	private static Tablero instance;
	private static int MONEDAS_INCIAL = 2000;
	
	private Mapa mapa;
	private Collection<Torre> jugadores; 
	private Collection<Enemigo> enemigos;
	private Collection<Disparo> disparos;
	private Gui gui;
	
	private PowerUpTiempo puActual;
	
	private int puntaje;
	private int monedas;
	
	private HiloTorres hj;
	private HiloEnemigos he;
	private HiloDisparos hd;
	private HiloOleadas ho;
	
	/**
	 * Crea el tablero
	 */
	private Tablero() {
		jugadores = new ConcurrentLinkedDeque<Torre>();
		enemigos = new ConcurrentLinkedDeque<Enemigo>();
		disparos = new ConcurrentLinkedDeque<Disparo>();		
		
		monedas = MONEDAS_INCIAL;
	}
	
	/**
	 * Retorna la instancia del tablero. En caso de que la instancia sea nula, se crea un tablero y lo retorna.
	 * @return la instancia del tablero
	 */
	public static Tablero getInstance() {
		if (instance==null) {
			instance = new Tablero();
		}
		return instance;
	}
	
	/**
	 * Crea el mapa del primer nivel.
	 */
	public void crearMapa() {
		mapa = new Nivel1();
		gui.setBackground(mapa);
	}
	
	/**
	 * Crea e inicia los hilos necesarios.
	 */
	public void crearHilos() {
		hj = new HiloTorres();
		hj.start();
		he = new HiloEnemigos();	
		he.start();
		hd = new HiloDisparos();
		hd.start();	
		ho = new HiloOleadas();
		ho.start();
	}
	
	/**
	 * Establece la gui asociada al tablero
	 * @param gui - La gui del tablero
	 */
	public void setGUI(Gui gui) {
		this.gui = gui;
	}
	
	/**
	 * Cambia al siguiente nivel o repite el actual, dependiede de si el jugador ganó o perdió respectivamente.
	 * @param completado - True si el jugador completó el nivel, false en caso contrario
	 */
	public void cambiarNivel(boolean completado) {
		puntaje = 0;
		monedas = MONEDAS_INCIAL;
		gui.actualizarPuntaje();
		mapa = mapa.cambiarNivel(completado);
		gui.setBackground(mapa);
		if (mapa!=null) {
			crearHilos();
		}		
	}
	
	/**
	 * Finaliza el nivel, vacía las colecciones de personajes y disparos, detiene los hilos y propaga el mensaje a la gui
	 * @param ganaste - True si el jugador completó el nivel, false en caso contrario
	 */
	public void gameOver(boolean ganaste) {
		jugadores = new ConcurrentLinkedDeque<Torre>();
		enemigos = new ConcurrentLinkedDeque<Enemigo>();
		disparos = new ConcurrentLinkedDeque<Disparo>();
		he.gameOver();
		hj.gameOver();
		hd.gameOver();	
		ho.gameOver();
		gui.gameOver(ganaste);
		
	}
	
	/**
	 * Realiza la acción de todas las torres en el juego.
	 */
	public void moverJugadores() {
		for (Personaje j : jugadores) {
			j.accion();		
		}
	}
	
	/**
	 * Realiza la acción de todos los enemigos en el juego.
	 */
	public void moverEnemigos() {	
		for (Enemigo e : enemigos) {
			e.accion();
			mapa.setEntidad(e); //Actualiza la posicion en el mapa logico en caso de que se haya movido
		}		
	}	
	
	/**
	 * Realiza la acción de todos los disparos en el juego.
	 */
	public void moverDisparos() {
		gui.repaint();
		for (Disparo d : disparos) {
			d.mover();			
		}
	}		
	
	/**
	 * Añade al tablero, al mapa y a la gui la torre pasada por parámetro.
	 * @param j - La torre a añadir
	 */
	public void crearJugador(Torre j) {
		j.setPowerUp(puActual);
		jugadores.add(j);
		mapa.setEntidad(j);
		gui.crearGrafico(j, 1);
		monedas -= j.getValor();
	}

	/**
	 * Añade al tablero, al mapa y a la gui un enemigo creado al azar.
	 * @return El enemigo creado
	 */
	public Enemigo crearEnemigo() {
		Random rnd = new Random();
		int fila = rnd.nextInt(6);
		int r = rnd.nextInt(100);		
		Enemigo e;
		if (r>=0 && r<25) {
			e = new Corona(-Mapa.PIXEL, fila*Mapa.PIXEL);
		} else if (r>=25 && r<45) {
			e = new Hielo(-Mapa.PIXEL, fila*Mapa.PIXEL);
		} else if (r>=45 && r<65) {
			e = new Tierra(-Mapa.PIXEL, fila*Mapa.PIXEL);
		} else if (r>=65 && r<85) {
			e = new Verde(-Mapa.PIXEL, fila*Mapa.PIXEL);
		} else if (r>=85 && r<95) {
			e = new Fantasma(-Mapa.PIXEL, fila*Mapa.PIXEL);
		} else {
			e = new Magma(-Mapa.PIXEL, fila*Mapa.PIXEL);
		}
		if (rnd.nextInt(9)==0) {
			e.setPowerUp(new Escudo(-Mapa.PIXEL, fila*Mapa.PIXEL));
			HiloPowerUp hpu = new HiloPowerUp(10, e);
			hpu.start();
		}
		enemigos.add(e);
		gui.crearGrafico(e, 1);
		return e;
	}	
	
	/**
	 * Añade al tablero y a la gui el disparo pasado por parámetro
	 * @param d - El disparo a añadir
	 */
	public void crearDisparo(Disparo d) {
		disparos.add(d);
		gui.crearGrafico(d, 2);
	}
	
	/**
	 * Añade al mapa y a la gui un objeto comprado por el jugador.
	 * @param oc - Objeto comprado por el jugador
	 */
	public void crearObjeto(ObjetoComprable oc) {
		mapa.setEntidad(oc);
		gui.crearGrafico(oc, 2);
		monedas -= oc.getCosto();
	}
	
	/**
	 * Elimina una torre del juego
	 * @param j - Torre a eliminar
	 */
	public void eliminar(Torre j) {
		gui.eliminarGrafico(j);
		mapa.eliminarEntidad(j);
		jugadores.remove(j);
	}
	
	/**
	 * Elimina un enemigo del juego.
	 * @param e - Enemigo a eliminar
	 */
	public void eliminar(Enemigo e) {
		puntaje += e.getValor();
		monedas += e.getValor();
		gui.eliminarGrafico(e);
		gui.actualizarPuntaje();
		mapa.eliminarEntidad(e);
		enemigos.remove(e);
	}
	
	/**
	 * Elimina todos los enemigos que estén en una fila del mapa.
	 * @param fila - Fila que contiene los enemigos a eliminar
	 */
	public void eliminarEnemigos(int fila) {
		Enemigo [] en = new Enemigo[enemigos.size()];
		int i = 0;
		for (Enemigo e : enemigos) {
			if (e.getY()==fila) {
				en[i] = e;
				i++;
			}
		}
		i = 0;
		while (i<en.length && en[i]!=null) {
			eliminar(en[i]);
			i++;
		}
	}
		
	/**
	 * Elimina un disparo del juego.
	 * @param d - Disparo a eliminar
	 */
	public void eliminar(Disparo d) {
		disparos.remove(d);		
		gui.eliminarGrafico(d);
	}
	
	/**
	 * Añade a la gui un objeto.
	 * @param o - Objeto a añadir
	 */
	public void dibujarObjeto(Objeto o) {
		gui.crearGrafico(o, 1);
	}
	
	/**
	 * Elimina un objeto de la gui.
	 * @param o - Objeto a eliminar
	 */
	public void eliminarObjeto(Objeto o) {
		mapa.eliminarEntidad(o);
		gui.eliminarGrafico(o);
	}
	
	/**
	 * Retorna el puntaje del juego.
	 * @return El puntaje del juego
	 */
	public int getPuntaje() {
		return puntaje;		
	}
	
	/**
	 * Retorna las monedas del jugador.
	 * @return Las monedas del jugador
	 */
	public int getMonedas() {
		return monedas;
	}
	
	/**
	 * Retorna la entidad que está en la posición dada por parámetro en el mapa.
	 * @param x - Coordenada x del mapa
	 * @param y - Coordenada y del mapa
	 * @return La entidad que está en la posición (x,y) del mapa, o null si no hay entidad.
	 */
	public Entidad getEntidad(int x, int y) {
		return mapa.getEntidad(x, y);
	}
	
	/**
	 * Cambia el power-up de todas las torres del tablero.
	 * @param pu - El power-up. Si es null significa que se desactiva el power-up actual.
	 */
	public void setPowerUp(PowerUpTiempo pu) {
		puActual = pu;
		for (Personaje j : jugadores) {
			j.setPowerUp(puActual);
		}
	}
	
	/**
	 * Operación utilizada para dejar un power-up en el tablero, que el usuario puede hacer click para activarlo.
	 * @param x - Coordenada x del power-up
	 * @param y - Coordenada y del power-up
	 */
	public void dropPowerUp(int x, int y) {
		Random rnd = new Random();
		int r = rnd.nextInt(100);
		PowerUp pu;
		if (r>=0 && r<15) {
			pu = new Rapido(x, y);
		}
		else if (r>=15 && r<30) {
			pu = new Fuerte(x, y);
		}
		else if (r>=45 && r<60) {
			pu = new Bomba(x, y);
		}
		else if (r>=60 && r<75) {
			pu = new Congelar(x, y);
		}
		else if (r>=75 && r<85) {
			pu = new Vida(x, y);
		}
		else {
			pu = new Escudo(x, y);
		}
		gui.crearGrafico(pu, 2);
	}
	
	/**
	 * Elimina el gráfico del power-up que está ubicado en el mapa.
	 * Esto se hace cuando el usuario hace click en el power-up y lo activa. 
	 * @param pu - El power-up a eliminar
	 */
	public void eliminarPU(PowerUp pu) {
		gui.eliminarGrafico(pu);
	}
	
	/**
	 * Determina si hay o no un power-up activo para las torres del jugador.
	 * @return True si hay power-up, false en caso contrario
	 */
	public boolean hayPowerUpActivo() {
		return puActual!=null;
	}
	
	/**
	 * Recupera al máximo la vida de las torres del jugador.
	 */
	public void recuperarVidaJugadores() {
		for (Personaje j : jugadores) {
			j.recuperarVida();
		}
	}
	
	/**
	 * Congela a los enemigos, impidiendo el movimiento de los mismos. También evita que se creen nuevos enemigos.
	 * @param seg - Tiempo que permanece congelados
	 */
	public void congelarEnemigos(int seg) {
		he.frozen(seg);
		ho.frozen(seg);
	}
	
	/**
	 * Todos los enemigos reciben daño.
	 * @param daño - La cantidad de daño que recibe cada enemigo
	 */
	public void dañarEnemigos(float daño) {
		for (Enemigo e : enemigos) {
			e.recibirDaño(daño);
		}
	}
	
	/**
	 * Determina si hay o no enemigos en el tablero.
	 * @return True si hay enemigos, false en caso contrario
	 */
	public boolean hayEnemigos() {
		return !enemigos.isEmpty();
	}
	
	/**
	 * Vende una torre del jugador, devolviendo la cantidad de monedas adecuadas al jugador.
	 * @param j La torre a vender
	 */
	public void vender(Torre j) {
		if (j.fullVida()) {
			monedas += j.getValor();
		}
		else {
			monedas += j.getValor()/2;
		}
		gui.actualizarPuntaje();
		j.morir();
	}
}
