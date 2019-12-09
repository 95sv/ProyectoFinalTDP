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

public abstract class Visitor {
	public abstract boolean visit(Torre t);
	
	public abstract boolean visit(DisparoEnemigo d);
	
	public abstract boolean visit(DisparoAliado d);
	
	public abstract boolean visit(EnemigoCerca e);
	
	public abstract boolean visit(EnemigoLejos e);
	
	public abstract boolean visit(Piedra p);
	
	public abstract boolean visit(Agua a);
	
	public abstract boolean visit(Fuego f);
	
	public abstract boolean visit(Barricada b);
	
	public abstract boolean visit(Trampa t);
	
	public abstract boolean visit(Veneno v);
	
	
	
}
