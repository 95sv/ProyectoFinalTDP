package EntidadesAbstractas;

import javax.swing.Icon;
import javax.swing.JLabel;


public abstract class Graficable {	

	protected int x;
	protected int y;
	protected JLabel jl;	
	protected Icon icon;

	
	public Graficable(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public JLabel getLabel() {
		return jl;
	}
	
	
	public int getX() {
		return x;
	}
	
	
	public int getY() {
		return y;
	}
}
