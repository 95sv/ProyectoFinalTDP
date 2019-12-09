package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Enemigos.EnemigoLejos;
import Objeto.Agua;
import Objeto.Barricada;
import Objeto.Fuego;
import Objeto.Piedra;
import Objeto.Trampa;
import Objeto.Veneno;
import Tablero.Tablero;
import Torres.Torre;

public class VisitorTrampa extends Visitor {
	protected Trampa t;

	public VisitorTrampa(Trampa t) {
		this.t = t;
	}

	@Override
	public boolean visit(Torre t) {
		return false;
	}

	@Override
	public boolean visit(DisparoEnemigo d) {
		return false;
	}

	@Override
	public boolean visit(DisparoAliado d) {
		return false;
	}

	@Override
	public boolean visit(EnemigoCerca e) {
		e.morir();
		Tablero.getInstance().eliminarObjeto(t);
		return false;
	}

	@Override
	public boolean visit(EnemigoLejos e) {
		/*
		 * Se activa si el enemigo esta pisando la trampa.
		 */
		if (Tablero.getInstance().getEntidad(t.getX() / 64 - 1, t.getY() / 64) == e) {
			e.morir();
			Tablero.getInstance().eliminarObjeto(t);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean visit(Piedra p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(Agua a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(Fuego f) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(Barricada b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(Veneno v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(Trampa t) {
		// TODO Auto-generated method stub
		return false;
	}

}