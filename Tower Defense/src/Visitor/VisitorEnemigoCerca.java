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
import Torres.Torre;

public class VisitorEnemigoCerca extends Visitor {
	protected EnemigoCerca e;

	public VisitorEnemigoCerca(EnemigoCerca e) {
		this.e = e;
	}

	public boolean visit(Torre t) {
		return true;
	}

	@Override
	public boolean visit(DisparoEnemigo d) {
		return false;
	}

	@Override
	public boolean visit(DisparoAliado d) {
		e.recibirDa�o(d.getDa�o());
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

	@Override
	public boolean visit(Piedra p) {
		p.recibirDa�o(e.getDa�o());
		return true;
	}

	@Override
	public boolean visit(Agua a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(Fuego f) {
		e.recibirDa�o(f.getDa�o());
		return false;
	}

	@Override
	public boolean visit(Barricada b) {
		
		b.recibirDa�o(e.getDa�o());
		return true;
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
