package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Enemigos.EnemigoCerca;
import Enemigos.EnemigoLejos;
import Objeto.Objeto;
import Torres.Torre;

public abstract class Visitor {
	public abstract boolean visit(Torre t);
	
	public abstract boolean visit(DisparoEnemigo d);
	
	public abstract boolean visit(DisparoAliado d);
	
	public abstract boolean visit(EnemigoCerca e);
	
	public abstract boolean visit(EnemigoLejos e);
	
	public abstract boolean visit(Objeto o);
}
