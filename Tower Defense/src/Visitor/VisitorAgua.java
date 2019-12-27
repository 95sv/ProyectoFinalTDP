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

public class VisitorAgua extends Visitor {
	protected Agua a;

	public VisitorAgua(Agua a) {
		this.a = a;
	}

	
	public boolean visit(Torre t) {
		
		return false;
	}

	@Override
	public boolean visit(DisparoEnemigo d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(DisparoAliado d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(EnemigoCerca e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(EnemigoLejos e) {
		// TODO Auto-generated method stub
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
