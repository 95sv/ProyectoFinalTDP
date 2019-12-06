package Mapa;

import javax.swing.Icon;
import Objeto.*;
import Torres.Torre;
import Enemigos.Enemigo;
import EntidadesAbstractas.*;


/**
 * Clase abstracta que representa un nivel, divido en celdas, donde se ubican todas las entidades del juego.
 * Cada entidad puede ocupar una celda y cada celda solo puede contener a lo sumo una entidad.
 * Cada nivel específico debe ser definidio como una sub-clase de esta clase.
 */
public abstract class Mapa {

	public static int MAX_ANCHO = 9;
	public static int MAX_ALTO = 5;
	public static int PIXEL = 64;
	
	protected Icon icon;
	protected Celda celdas[][];	
	
	/**
	 * Crea la base del mapa, que siempre es la misma sin importar el nivel.
	 */
	protected Mapa() {
		celdas = new Celda[10][6];
		//La iteracion while es para evitar que se creen menos objetos de lo que se deberian crear
		for (int i = 0; i < celdas.length; i++) {
			for (int j = 0; j < celdas[0].length; j++) {
				celdas[i][j] = new Celda(this);
			}
		}
	}
	
	/**
	 * Eliminar una entidad del mapa
	 * @param e - La entidad a eliminar
	 */
	public void eliminarEntidad(Entidad e) {
		//Al mover los enemigos, existe la posibilidad de que cambie de posicion mientras se esta muriendo y se trata de eliminar
		//la entidad en la celda incorrecta. Por eso, si la entidad no esta en la celda donde deberia estar por error, estara en la anterior (probablemente)
		if (celdas[e.getX()/PIXEL][e.getY()/PIXEL].getEntidad()==e) {
			celdas[e.getX()/PIXEL][e.getY()/PIXEL].setEntidad(null); 
		}
		if ((e.getX()/PIXEL-1>=0) && celdas[e.getX()/PIXEL-1][e.getY()/PIXEL].getEntidad()==e) {
			celdas[e.getX()/PIXEL-1][e.getY()/PIXEL].setEntidad(null); 
		}		
	}

	/**
	 * Se añade una torre al mapa.
	 * @param n - La torre a añadir 
	 */
	public void setEntidad(Torre n) {
		celdas[n.getX()/PIXEL][n.getY()/PIXEL].setEntidad(n);
	}
	
	/**
	 * Se añade un enemigo al mapa. Como los enemigos se mueven por el mapa, 
	 * esta operación también se utilizar para actualizar la celda que ocupa dentro del mapa.
	 * @param e - El enemigo a añadir o actualizar
	 */
	public void setEntidad(Enemigo e) {
		if (e.getX()/PIXEL<celdas.length && e.getX()>=0) {
			celdas[e.getX()/PIXEL][e.getY()/PIXEL].setEntidad(e);
			if (e.getX()>PIXEL && celdas[e.getX()/PIXEL-1][e.getY()/PIXEL].getEntidad()==e) {
				celdas[e.getX()/PIXEL-1][e.getY()/PIXEL].setEntidad(null);
			}			
		}	
	}
	
	/**
	 * Se añade un objeto al mapa.
	 * @param o - El objeto a añadir 
	 */
	public void setEntidad(Objeto o) {
		celdas[o.getX()/PIXEL][o.getY()/PIXEL].setEntidad(o);
	}
	
	/**
	 * Retorna la entidad de la celda ubicada en las coordenadas pasadas por parámetro.
	 * @param x - La coordenada x de la entidad
	 * @param y - La coordeanda y de la entidad
	 * @return La entidad ubicada en la celda
	 */
	public Entidad getEntidad(int x, int y) {
		return celdas[x][y].getEntidad();
	}
	
	/**
	 * Cambia de nivel o reinicia el nivel actual, dependiendo de si el usuario ganó o perdió el nivel.
	 * @param completado - True si se completó el nivel, false en caso contrario
	 * @return El nuevo nivel
	 */
	public abstract Mapa cambiarNivel(boolean completado);
	
	/**
	 * Retorna la imagen asociada al mapa.
	 * @return La imagen asociada al mapa
	 */
	public Icon getIcon() {
		return icon;
	}
	
}
