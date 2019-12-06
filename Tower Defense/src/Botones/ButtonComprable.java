package Botones;

import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 * Bot�n que se utiliza para crear las torres y objetos comprables.
 * Cada bot�n muestra su informaci�n usando tooltip cuando el cursor est� por encima.
 */
public abstract class ButtonComprable extends JButton {
	
	/**
	 * Crea un bot�n comprable.
	 * @param al El ActionListener asociado al bot�n
	 */
	public ButtonComprable(ActionListener al) {
		super();
		setBorder(null);
	    setContentAreaFilled(false);
	    addActionListener(al);
	    addMouseListener(new TooltipEnabler());
	}

	/**
	 * Crea el comprable asociado al bot�n.
	 * @param x - Coordenada x del objeto
	 * @param y - Coordenada y del objeto
	 */
	public abstract void crearComprable(int x, int y);	
	
	/**
	 * Clase utilizada para mostrar el tooltip cuando el cursor pase por encima del bot�n.
	 */
	private class TooltipEnabler extends MouseAdapter {
		
		//Simula Control+F1 para activar el Tooltip. Probablemente solo funcione en Windows
		public void mouseEntered(MouseEvent e) {
			KeyEvent ke = new KeyEvent(e.getComponent(), KeyEvent.KEY_PRESSED,
                    System.currentTimeMillis(), InputEvent.CTRL_MASK,
                    KeyEvent.VK_F1, KeyEvent.CHAR_UNDEFINED);
            e.getComponent().dispatchEvent(ke);
		}
		
	}	
}
