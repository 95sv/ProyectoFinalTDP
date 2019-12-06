package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Enemigos.EnemigoLejos;
import Objeto.Objeto;
import Torres.Torre;

public class VisitorTorre extends Visitor{
	protected Torre miTorre;
	
	public VisitorTorre(Torre t) {
		miTorre = t;
	}
	
	@Override
	public boolean visit(Torre t) {
		return false;
	}

	@Override
	public boolean visit(DisparoEnemigo d) {
		miTorre.recibirDaño(d.getDaño());
		if(miTorre.getVida()<= 0) {
			miTorre.morir();
		}
		return true;
	}

	@Override
	public boolean visit(DisparoAliado d) {
		return false;
	}

	@Override
	public boolean visit(EnemigoCerca e) {
		miTorre.recibirDaño(e.getDaño()/8);
		return true;
	}

	@Override
	public boolean visit(EnemigoLejos e) {
		return true;
	}

	@Override
	public boolean visit(Objeto o) {
		// TODO Auto-generated method stub
		return false;
	}

}
