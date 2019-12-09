package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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

/**
 * Clase encargada de manejar la interfaz gráfica
 */
public class Gui extends JFrame {
	
	private JPanel contentPane;
	
	private JLabel background;
	
	private ButtonComprable torreElegida;
	
	private JLabel lblPuntaje;
	private JLabel lblMonedas;

	public static void main(String[] args) {
		Gui ventana= new Gui();
		ventana.setVisible(true);
		ventana.setTitle("Tower Defense");		
	}
	
	/**
	 * Crea la gui.
	 */
	public Gui() {		
		//Se genera el contentPane
		getContentPane().setLayout(null);
		contentPane=new JPanel();
		setContentPane(contentPane);
		setSize(670,630);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		contentPane.setSize(640, 384);
		
		background = new JLabel();		
		background.addMouseListener(new CrearEliminarComprableListener());
		contentPane.add(background);		
		
		cargarInventario();
		cargarLogica();
	}
	
	/**
	 * Crea todos los componentes gráficos del inventario, particularmente los botones para crear torres y objetos,
	 * y otra información como puntaje y monedas.
	 */
	private void cargarInventario() {
		//Se crea el panel de inventario
		JPanel inventario = new JPanel();		
		inventario.setLayout(new BorderLayout());			
		contentPane.add(inventario);
		
		//Paneles que estan en el inventario
		JPanel torres = new JPanel();
		JPanel objetos = new JPanel();
		JPanel puntaje = new JPanel();		
		
		//Panel de las torres y objetos		
		JPanel comprables = new JPanel();
		comprables.setLayout(new BorderLayout());
		comprables.add(torres, BorderLayout.NORTH);
		comprables.add(objetos, BorderLayout.SOUTH);
		
		//Se insertan los paneles al inventario
		inventario.add(comprables, BorderLayout.NORTH);
		inventario.add(puntaje, BorderLayout.CENTER);
				
		//Se crean los botones de torres y comprables
		torres.add(new BotonTorreArena(new ElegirComprableListener()));
		torres.add(new ButtonAvanzada(new ElegirComprableListener()));
		torres.add(new BotonTorreControl(new ElegirComprableListener()));
		torres.add(new BotonTorreLadrillos(new ElegirComprableListener()));
		torres.add(new BotonTorreRoca(new ElegirComprableListener()));
		torres.add(new ButtonDoble(new ElegirComprableListener()));
		objetos.add(new ButtonBarricada(new ElegirComprableListener()));
		objetos.add(new ButtonTrampa(new ElegirComprableListener()));
		objetos.add(new ButtonVeneno(new ElegirComprableListener()));		
		objetos.add(new ButtonFuego(new ElegirComprableListener()));
		
		//Puntaje y monedas
		lblPuntaje = new JLabel("Puntaje: " + Tablero.getInstance().getPuntaje());
		puntaje.add(lblPuntaje);
		lblMonedas = new JLabel("Monedas: " + Tablero.getInstance().getMonedas());
		puntaje.add(lblMonedas);	
	}
	
	/**
	 * Inicia la logica del juego.
	 */
	private void cargarLogica() {
		//Logica e hilos		
		Tablero.getInstance().setGUI(this);
		Tablero.getInstance().crearMapa();
		Tablero.getInstance().crearHilos();
	}
	
	/**
	 * Termina el nivel, mostrando un mensaje de para reiniciar o continuar al siguiente nivel, 
	 * dependiendo de si el usuario perdió o ganó respectivamente.
	 * Si el usuario completó el último nivel, el juego terminará con una ventana vacía.
	 * @param ganaste - True si el usuario completó el nivel, false en caso contrario
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
		background.add(lbl);//288160
		lbl.setBounds(230, 0, 640, 384);
		background.add(btn);
		btn.setBounds(265, 250, 100, 32);
		btn.setBorder(null);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				background.removeAll();
				if (btn.getText()=="Continuar") {
					Tablero.getInstance().cambiarNivel(true);
				}
				else {
					Tablero.getInstance().cambiarNivel(false);
				}
				repaint();
			}
		});
	}
	
	/**
	 * Cambia el fondo del mapa, para mostrar gráficamente el cambio de nivel.
	 * @param m - El nivel del cual se toma el nuevo fondo
	 */
	public void setBackground(Mapa m) {
		if (m!=null) {
			background.setIcon(m.getIcon());
		}
		else {
			contentPane.removeAll();			
		}
		repaint();
	}
	
	/**
	 * Añade el gráfico de un objeto al mapa.
	 * @param g - El objeto graficable
	 * @param capa - La capa donde se inserta el objeto. Se utiliza 1 para los objetos normales y 2 para los que deben ser visto por encima de los normales
	 */
	public void crearGrafico(Graficable g, int capa) {
		background.add(g.getLabel());
		g.getLabel().setBounds(g.getX(), g.getY(), Mapa.PIXEL, Mapa.PIXEL);
		if (capa>=0 && capa<background.getComponentCount()) {
			background.setComponentZOrder(g.getLabel(), capa);
		}		
	}
	
	/**
	 * Se elimina el gráfico de un objeto del mapa.
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
	
	/**
	 * Prepara el mapa para crear un objeto comprable y guarda que boton se apretó.
	 */
	private class ElegirComprableListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {	
			if (torreElegida!=null) {
				torreElegida.setBorder(null);
			}
			torreElegida = (ButtonComprable) e.getSource();
			torreElegida.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		}
	}
	
	/**
	 * Crea un nuevo jugador en base a las coordenadas del cursor si se hizo click izquierdo en el mapa.
	 * Si se hace click derecho, elimina el objeto graficable si es posible.
	 */
	private class CrearEliminarComprableListener extends MouseAdapter {		
		
		public void mouseClicked(MouseEvent e) {			
			if (torreElegida!=null) {
				if (e.getX()>=196 && Tablero.getInstance().getEntidad(e.getX()/Mapa.PIXEL, e.getY()/Mapa.PIXEL)==null && e.getButton()==MouseEvent.BUTTON1) {
					torreElegida.crearComprable(e.getX()/Mapa.PIXEL*Mapa.PIXEL, e.getY()/Mapa.PIXEL*Mapa.PIXEL);
					actualizarPuntaje();
				}
				torreElegida.setBorder(null);
				torreElegida = null;
			}
			else {
				if (e.getButton()==MouseEvent.BUTTON3) {	
					Entidad en = Tablero.getInstance().getEntidad(e.getX()/Mapa.PIXEL, e.getY()/Mapa.PIXEL);
					if (en!=null) {
						//en.visit();
					}
				}
			}
		}
	}
}
