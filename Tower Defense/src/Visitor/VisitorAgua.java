package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Enemigos.EnemigoLejos;
import Objeto.Objeto;
import Torres.Torre;

public class VisitorAgua extends Visitor {
	protected Objeto o;

	protected VisitorAgua(Objeto o) {
		this.o = o;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(EnemigoLejos e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(Objeto o) {
		// TODO Auto-generated method stub
		return false;
	}

}
