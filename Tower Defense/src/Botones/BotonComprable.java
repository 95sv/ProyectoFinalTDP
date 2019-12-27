package Botones;

import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;


@SuppressWarnings("serial")
public abstract class BotonComprable extends JButton {
	
	//Clase generica para los botones de compra
	
	public BotonComprable(ActionListener al) {
		super();
		setBorder(null);
	    setContentAreaFilled(false);
	    addActionListener(al);
	    addMouseListener(new TooltipEnabler());
	}

	
	public abstract void crearComprable(int x, int y);	
	
	private class TooltipEnabler extends MouseAdapter {
		
		public void mouseEntered(MouseEvent e) {
			KeyEvent ke = new KeyEvent(e.getComponent(), KeyEvent.KEY_PRESSED,
                    System.currentTimeMillis(), InputEvent.CTRL_MASK,
                    KeyEvent.VK_F1, KeyEvent.CHAR_UNDEFINED);
            e.getComponent().dispatchEvent(ke);
		}
		
	}	
}
