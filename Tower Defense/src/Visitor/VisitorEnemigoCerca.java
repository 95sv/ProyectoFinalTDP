package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Enemigos.EnemigoLejos;
import Objeto.Objeto;
import Torres.Torre;

public class VisitorEnemigoCerca extends Visitor{
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
	@Override
	public boolean visit(Objeto o) {
		// TODO Auto-generated method stub
		return false;
	}
}
