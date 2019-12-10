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

public class VisitorEnemigoLejos extends Visitor{
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
	
	
	public boolean visit(Piedra p) {
		p.recibirDa�o(e.getDa�o());
		return true;
	}
	
	
	public boolean visit(Agua a) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean visit(Fuego f) {

		if(e.getX()+100>f.getX()) {
		   e.recibirDa�o(f.getDa�o());
		}
		return false;
	}
	
	
	public boolean visit(Barricada b) {
		return true;
	}
	
	
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
