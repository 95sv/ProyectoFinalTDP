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
import Torres.Torre;

public class VisitorEnemigoCerca extends Visitor {
	protected EnemigoCerca e;

	public VisitorEnemigoCerca(EnemigoCerca e) {
		this.e = e;
	}

	public boolean visit(Torre t) {
		t.recibirDa�o(e.getDa�o());
		return true;
	}

	public boolean visit(DisparoEnemigo d) {
		return false;
	}

	public boolean visit(DisparoAliado d) {
		e.recibirDa�o(d.getDa�o());
		return true;
	}

	public boolean visit(EnemigoCerca e) {
		return false;
	}

	public boolean visit(EnemigoLejos e) {
		return false;
	}

	public boolean visit(Piedra p) {
		p.recibirDa�o(e.getDa�o());
		return true;
	}

	public boolean visit(Agua a) {

		return false;
	}

	public boolean visit(Fuego f) {
		e.recibirDa�o(f.getDa�o());
		return false;
	}

	public boolean visit(Barricada b) {

		b.recibirDa�o(e.getDa�o());
		return true;
	}

	public boolean visit(Veneno v) {
		HiloVeneno hv = new HiloVeneno();
		hv.start();
		v.morir();
		return false;
	}

	public boolean visit(Trampa t) {
		e.morir();
		t.morir();
		return false;
	}
}
