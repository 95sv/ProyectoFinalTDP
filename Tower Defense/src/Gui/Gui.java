package Gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Botones.*;
import EntidadesAbstractas.Entidad;
import EntidadesAbstractas.Graficable;
import Mapa.Mapa;
import Tablero.Tablero;
import Torres.Torre;

/**
 * Clase encargada de manejar la interfaz gráfica
 */
public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel background;

	private BotonComprable torreElegida;
	private Torre torreVender;
	private JButton btnVender;
	
	private JLabel lblPuntaje;
	private JLabel lblMonedas;

	public static void main(String[] args) {
		Gui ventana = new Gui();
		ventana.setVisible(true);
		ventana.setTitle("Tower Defense");
	}

	/**
	 * Crea la gui.
	 */
	public Gui() {
		// Se genera el contentPane
		getContentPane().setLayout(null);
		setSize(1050, 470);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		background = new JLabel();
		background.setLayout(null);
		background.setBounds(0, 0, 640, 384);
		background.addMouseListener(new CrearEliminarComprableListener());
		getContentPane().add(background);

		cargarInventario();
		cargarLogica();
	}

	/**
	 * Crea todos los componentes gráficos del inventario, particularmente los
	 * botones para crear torres y objetos, y otra información como puntaje y
	 * monedas.
	 */
	private void cargarInventario() {
		// Se crea el panel de inventario
		JPanel inventario = new JPanel();
		inventario.setLayout(new GridLayout(5, 2));
		inventario.setBounds(640, 0, 400, 384);
		inventario.setBackground(Color.BLACK);
		getContentPane().add(inventario);

		JPanel puntaje = new JPanel();
		puntaje.setLayout(new FlowLayout());
		puntaje.setBounds(0, 384, 1050, 50);
		puntaje.setBackground(Color.BLACK);
		getContentPane().add(puntaje);

		// Se crean los botones de torres y comprables
		inventario.add(new BotonTorreArena(new ElegirComprableListener()));
		inventario.add(new BotonTorrePesada(new ElegirComprableListener()));
		inventario.add(new BotonTorreControl(new ElegirComprableListener()));
		inventario.add(new BotonTorreLadrillos(new ElegirComprableListener()));
		inventario.add(new BotonTorreRoca(new ElegirComprableListener()));
		inventario.add(new BotonDoble(new ElegirComprableListener()));
		inventario.add(new BotonBarricada(new ElegirComprableListener()));
		inventario.add(new BotonTrampa(new ElegirComprableListener()));
		inventario.add(new BotonVeneno(new ElegirComprableListener()));
		inventario.add(new BotonFuego(new ElegirComprableListener()));

		// Puntaje y monedas
		lblPuntaje = new JLabel("Puntaje: " + Tablero.getInstance().getPuntaje());
		lblPuntaje.setForeground(Color.YELLOW);
		puntaje.add(lblPuntaje);
		lblMonedas = new JLabel("Monedas: " + Tablero.getInstance().getMonedas());
		lblMonedas.setForeground(Color.YELLOW);
		puntaje.add(lblMonedas);
		
		// Vender torre
		btnVender = new JButton("Vender");
		btnVender.setEnabled(false);
		btnVender.setSize(100,40);
		puntaje.add(btnVender);
		btnVender.addActionListener(new VenderListener());
		
	}

	/**
	 * Inicia la logica del juego.
	 */
	private void cargarLogica() {
		// Logica e hilos
		Tablero.getInstance().setGUI(this);
		Tablero.getInstance().crearMapa();
		Tablero.getInstance().crearHilos();
	}

	/**
	 * Termina el nivel, mostrando un mensaje de para reiniciar o continuar al
	 * siguiente nivel, dependiendo de si el usuario perdió o ganó respectivamente.
	 * Si el usuario completó el último nivel, el juego terminará con una ventana
	 * vacía.
	 * 
	 * @param ganaste - True si el usuario completó el nivel, false en caso
	 *                contrario
	 */
	public void gameOver(boolean ganaste) {
		repaint();
		JLabel lbl;
		JButton btn;
		background.removeAll();
		if (ganaste) {
			lbl = new JLabel("Ganaste");
			btn = new JButton("Continuar");
		} else {
			lbl = new JLabel("Perdiste");
			btn = new JButton("Reiniciar");
		}
		lbl.setFont(new Font("Serif", Font.BOLD, 48));
		background.add(lbl);
		lbl.setBounds(230, 0, 640, 384);
		background.add(btn);
		btn.setBounds(265, 250, 100, 32);
		btn.setBorder(null);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				background.removeAll();
				if (btn.getText() == "Continuar") {
					Tablero.getInstance().cambiarNivel(true);
				} else {
					Tablero.getInstance().cambiarNivel(false);
				}
				repaint();
			}
		});
	}

	/**
	 * Cambia el fondo del mapa, para mostrar gráficamente el cambio de nivel.
	 * 
	 * @param m - El nivel del cual se toma el nuevo fondo
	 */
	public void setBackground(Mapa m) {
		if (m != null) {
			background.setIcon(m.getIcon());
		} else {
			getContentPane().removeAll();
		}
		repaint();
	}

	/**
	 * Añade el gráfico de un objeto al mapa.
	 * 
	 * @param g    - El objeto graficable
	 * @param capa - La capa donde se inserta el objeto. Se utiliza 1 para los
	 *             objetos normales y 2 para los que deben ser visto por encima de
	 *             los normales
	 */
	public void crearGrafico(Graficable g, int capa) {
		background.add(g.getLabel());
		g.getLabel().setBounds(g.getX(), g.getY(), Mapa.PIXEL, Mapa.PIXEL);
		if (capa >= 0 && capa < background.getComponentCount()) {
			background.setComponentZOrder(g.getLabel(), capa);
		}
	}

	/**
	 * Se elimina el gráfico de un objeto del mapa.
	 * 
	 * @param g - El objeto graficable
	 */
	public void eliminarGrafico(Graficable g) {
		background.remove(g.getLabel());
	}

	/**
	 * Se actualiza el valor del puntaje y el de las monedas.
	 */
	public void actualizarPuntaje() {
		lblPuntaje.setText("Puntaje : " + Tablero.getInstance().getPuntaje());
		lblMonedas.setText("Monedas : " + Tablero.getInstance().getMonedas());
	}
	
	public void venderTorre(Torre t) {
		if(t != null) {
			torreVender = t;
		}
		else torreVender = null;
	}
	
	private class VenderListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(torreVender != null) {
				torreVender.morir();
				actualizarPuntaje();
			}
		}

	}
	
	/**
	 * Prepara el mapa para crear un objeto comprable y guarda que boton se apretó.
	 */
	private class ElegirComprableListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (torreElegida != null) {
				torreElegida.setBorder(null);
			}
			torreElegida = (BotonComprable) e.getSource();
			torreElegida.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		}
	}

	/**
	 * Crea un nuevo jugador en base a las coordenadas del cursor si se hizo click
	 * izquierdo en el mapa. Si se hace click derecho, elimina el objeto graficable
	 * si es posible.
	 */
	private class CrearEliminarComprableListener extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {
			if (torreElegida != null) {
				if (e.getX() >= 196
						&& Tablero.getInstance().getEntidad(e.getX() / Mapa.PIXEL, e.getY() / Mapa.PIXEL) == null
						&& e.getButton() == MouseEvent.BUTTON1) {
					torreElegida.crearComprable(e.getX() / Mapa.PIXEL * Mapa.PIXEL, e.getY() / Mapa.PIXEL * Mapa.PIXEL);
					actualizarPuntaje();
					btnVender.setEnabled(true);
				}
				torreElegida.setBorder(null);
				torreElegida = null;
			} else {
				if (e.getButton() == MouseEvent.BUTTON3) {
					Entidad en = Tablero.getInstance().getEntidad(e.getX() / Mapa.PIXEL, e.getY() / Mapa.PIXEL);
					if (en != null) {
						
					}
				}
			}
		}
	}
}
