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

public class VisitorDisparoEnemigo extends Visitor{
	protected DisparoEnemigo d;
	
	public VisitorDisparoEnemigo(DisparoEnemigo d) {
		this.d = d;
	}
	@Override
	public boolean visit(Torre t) {
		t.recibirDaño(d.getDaño());
		return true;
	}

	
	public boolean visit(DisparoEnemigo d) {
		
		return false;
	}

	
	public boolean visit(DisparoAliado d) {
		
		return false;
	}

	
	public boolean visit(EnemigoCerca e) {
		
		return false;
	}


	public boolean visit(EnemigoLejos e) {
		
		return false;
	}

	@Override
	public boolean visit(Piedra p) {
		p.recibirDaño(d.getDaño());
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
	
		b.recibirDaño(d.getDaño());
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
