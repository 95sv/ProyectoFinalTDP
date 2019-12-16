package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Enemigos.EnemigoLejos;
import Hilos.HiloVeneno;
import Mapa.Mapa;
import Objeto.Agua;
import Objeto.Barricada;
import Objeto.Fuego;
import Objeto.Piedra;
import Objeto.Trampa;
import Objeto.Veneno;
import Torres.Torre;

public class VisitorEnemigoLejos extends Visitor {
	protected EnemigoLejos e;

	public VisitorEnemigoLejos(EnemigoLejos e) {
		this.e = e;
	}

	@Override
	public boolean visit(Torre t) {
		return true;
	}

	@Override
	public boolean visit(DisparoEnemigo d) {
		return false;
	}

	@Override
	public boolean visit(DisparoAliado d) {
		e.recibirDaño(d.getDaño());
		return true;
	}

	@Override
	public boolean visit(EnemigoCerca e) {
		return false;
	}

	@Override
	public boolean visit(EnemigoLejos e) {
		return false;
	}

	public boolean visit(Piedra p) {
		p.recibirDaño(e.getDaño());
		return true;
	}

	public boolean visit(Agua a) {

		return false;
	}

	public boolean visit(Fuego f) {

		if (f.getX() - e.getX() <= Mapa.PIXEL) {
			e.recibirDaño(f.getDaño());
		}
		return false;
	}

	public boolean visit(Barricada b) {
		return true;
	}

	public boolean visit(Veneno v) {
		if (v.getX() - e.getX() <= Mapa.PIXEL) {
			HiloVeneno hv = new HiloVeneno();
			hv.start();
			v.morir();
			;
		}
		return false;
	}

	public boolean visit(Trampa t) {
		if (t.getX() - e.getX() <= Mapa.PIXEL) {
			e.morir();
			t.morir();
		}
		return false;
	}

}
