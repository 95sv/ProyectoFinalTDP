package Objeto;

import EntidadesAbstractas.Entidad;
import Tablero.Tablero;
import Visitor.Visitor;


 //Clase que representa cualquier objeto del mapa que no sea un enemigo o una torre. 

public abstract class Objeto extends Entidad {


	public Objeto(int x, int y) {
		super(x, y);
	}

	public abstract boolean aceptar(Visitor v);
	
	public void morir() {
		Tablero.getInstance().eliminarObjeto(this);
	}

}
