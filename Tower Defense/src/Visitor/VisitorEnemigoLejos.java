package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Enemigos.EnemigoLejos;
import Objeto.Objeto;
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
	@Override
	public boolean visit(Objeto o) {
		// TODO Auto-generated method stub
		return false;
	}

}
