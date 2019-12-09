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

public class VisitorDisparoAliado extends Visitor{
	protected DisparoAliado d;
	
	public VisitorDisparoAliado(DisparoAliado d) {
		this.d = d;
	}
	@Override
	public boolean visit(Torre t) {
		// TODO Auto-generated method stub
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
		e.recibirDaño(d.getDaño());
		return true;
	}

	@Override
	public boolean visit(EnemigoLejos e) {
		e.recibirDaño(d.getDaño());
		return true;
	}

	@Override
	public boolean visit(Piedra p) {
		return true;
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
