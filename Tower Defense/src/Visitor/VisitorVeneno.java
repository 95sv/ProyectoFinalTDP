package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Enemigos.EnemigoLejos;
import Hilos.HiloVeneno;
import Objeto.Agua;
import Objeto.Barricada;
import Objeto.Fuego;
import Objeto.Piedra;
import Objeto.Trampa;
import Objeto.Veneno;
import Tablero.Tablero;
import Torres.Torre;

public class VisitorVeneno extends Visitor {
	protected Veneno v;

	public VisitorVeneno(Veneno v) {
		this.v = v;
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
		HiloVeneno hv = new HiloVeneno();
		hv.start();
		Tablero.getInstance().eliminarObjeto(v);
		return false;
	}

	@Override
	public boolean visit(EnemigoLejos e) {
		if (v.getX() <= 64) {
			HiloVeneno hv = new HiloVeneno();
			hv.start();
			Tablero.getInstance().eliminarObjeto(v);
		}
		return false;
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