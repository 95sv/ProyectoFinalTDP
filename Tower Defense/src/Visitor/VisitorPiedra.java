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

public class VisitorPiedra extends Visitor{
	protected Piedra p;
	
	public VisitorPiedra(Piedra p) {
		this.p = p;
	}
	@Override
	public boolean visit(Torre t) {
		return false;
	}

	@Override
	public boolean visit(DisparoEnemigo d) {
		float vida = p.getVida();
		vida -= d.getDaño();
		if(vida<=0) {
			p.morir();
		}
		return true;
	}

	@Override
	public boolean visit(DisparoAliado d) {
		return false;
	}

	@Override
	public boolean visit(EnemigoCerca e) {
		float vida = p.getVida();
		vida -= e.getDaño();
		if(vida<=0) {
			p.morir();
		}
		return true;
	}

	@Override
	public boolean visit(EnemigoLejos e) {
		
		return true;
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