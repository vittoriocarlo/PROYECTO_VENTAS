package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ventanaOperaciones extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	public static String historialVentas = "";
	
	public static double cuotaDiaria = 50000.00; 
	public static int contadorVentasGlobal = 0;
	public static double importeAcumuladoGeneral = 0;

	public static String codigo1 = "C001";
	public static String descripcion1 = "Casaca de Cuero Pro";
	public static double precio1 = 150.5;
	public static String talla1 = "L";
	public static int stock1 = 25;
	public static String color1 = "Negro";
	public static String proveedor1 = "Gamarra Fashion";

	public static String codigo2 = "C002";
	public static String descripcion2 = "Polo Oversize Algodón";
	public static double precio2 = 45.9;
	public static String talla2 = "M";
	public static int stock2 = 50;
	public static String color2 = "Blanco";
	public static String proveedor2 = "Textil S.A.";

	public static String codigo3 = "C003";
	public static String descripcion3 = "Jean Slim Fit";
	public static double precio3 = 89.0;
	public static String talla3 = "32";
	public static int stock3 = 40;
	public static String color3 = "Azul";
	public static String proveedor3 = "Jeans Peru";

	public static String codigo4 = "C004";
	public static String descripcion4 = "Casaca Impermeable";
	public static double precio4 = 120.0;
	public static String talla4 = "M";
	public static int stock4 = 15;
	public static String color4 = "Azul";
	public static String proveedor4 = "Textil Sur";

	public static String codigo5 = "C005";
	public static String descripcion5 = "Pantalón Jean Slim";
	public static double precio5 = 85.5;
	public static String talla5 = "32";
	public static int stock5 = 30;
	public static String color5 = "Celeste";
	public static String proveedor5 = "Jeans Peru";

	public static String codigo6 = "C006";
	public static String descripcion6 = "Polo Box Algodón";
	public static double precio6 = 35.0;
	public static String talla6 = "S";
	public static int stock6 = 45;
	public static String color6 = "Verde";
	public static String proveedor6 = "Gamarra S.A.";

	public static String codigo7 = "C007";
	public static String descripcion7 = "Chaqueta de Mezclilla";
	public static double precio7 = 110.0;
	public static String talla7 = "L";
	public static int stock7 = 10;
	public static String color7 = "Gris";
	public static String proveedor7 = "Moda Total";

	public static String codigo8 = "C008";
	public static String descripcion8 = "Short Deportivo";
	public static double precio8 = 25.9;
	public static String talla8 = "M";
	public static int stock8 = 60;
	public static String color8 = "Rojo";
	public static String proveedor8 = "Sport World";
	
	public static String fechaActual() {
	    return java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	JMenuBar menuBar;
	private JMenu mnMatenimiento;
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenu mnAyuda;
	private JMenuItem mntmConsultar;
	private JMenu mnreporte;
	private JMenuItem mntmresumen;
	private JMenuItem mntmModificar;
	private JMenuItem mntmListar;
	private JMenuItem mntmVender;
	private JMenuItem mntmDescuento;
	private JMenuItem mntmObsequiO;
	private JMenuItem mntmAcercaDe;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			com.formdev.flatlaf.FlatDarkLaf.setup();
		} catch (Exception ex) {
			System.err.println("Error al iniciar FlatLaf: " + ex.getMessage());
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaOperaciones frame = new ventanaOperaciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ventanaOperaciones() {
		
		try {
	        com.formdev.flatlaf.FlatDarkLaf.setup();
	    } catch (Exception ex) {
	        System.err.println("Error al aplicar FlatLaf en el constructor");
	    }

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 450);
		setTitle("SISTEMA DE VENTA DE ROPA");
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizar

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnreporte = new JMenu("Reporte");
		mnreporte.setFont(new Font("Fira Code", Font.PLAIN, 12));
		menuBar.add(mnreporte);

		mntmresumen = new JMenuItem("Resumen General");
		mntmresumen.addActionListener(this);
		mntmresumen.setFont(new Font("Fira Code", Font.PLAIN, 12));
		mnreporte.add(mntmresumen);

		mnMatenimiento = new JMenu("Mantenimiento");
		mnMatenimiento.setFont(new Font("Fira Code", Font.PLAIN, 12));
		menuBar.add(mnMatenimiento);

		mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.setFont(new Font("Fira Code", Font.PLAIN, 12));
		mntmConsultar.addActionListener(this);
		mnMatenimiento.add(mntmConsultar);

		mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(this);
		mntmModificar.setFont(new Font("Fira Code", Font.PLAIN, 12));
		mnMatenimiento.add(mntmModificar);

		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(this);
		mntmListar.setFont(new Font("Fira Code", Font.PLAIN, 12));
		mnMatenimiento.add(mntmListar);

		mnVentas = new JMenu("Ventas");
		mnVentas.addActionListener(this);
		mnVentas.setFont(new Font("Fira Code", Font.PLAIN, 12));
		menuBar.add(mnVentas);

		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mntmVender.setFont(new Font("Fira Code", Font.PLAIN, 12));
		mnVentas.add(mntmVender);

		mnConfiguracion = new JMenu("Configuracion");
		mnConfiguracion.setFont(new Font("Fira Code", Font.PLAIN, 12));
		menuBar.add(mnConfiguracion);

		mntmDescuento = new JMenuItem("Descuento");
		mntmDescuento.addActionListener(this);
		mntmDescuento.setFont(new Font("Fira Code", Font.PLAIN, 12));
		mnConfiguracion.add(mntmDescuento);

		mntmObsequiO = new JMenuItem("Obsequio");
		mntmObsequiO.addActionListener(this);
		mntmObsequiO.setFont(new Font("Fira Code", Font.PLAIN, 12));
		mnConfiguracion.add(mntmObsequiO);

		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Fira Code", Font.PLAIN, 12));
		menuBar.add(mnAyuda);

		mntmAcercaDe = new JMenuItem("Acerca de la tienda");
		mntmAcercaDe.addActionListener(this);
		mntmAcercaDe.setFont(new Font("Fira Code", Font.PLAIN, 12));
		mnAyuda.add(mntmAcercaDe);

		try {

			ImageIcon icono = new ImageIcon(getClass().getResource("/IMG/fondo.jpg"));

			final java.awt.Image imagenOriginal = icono.getImage();

			JPanel contentPane = new JPanel() {
				@Override
				protected void paintComponent(java.awt.Graphics g) {
					super.paintComponent(g);
					g.drawImage(imagenOriginal, 0, 0, getWidth(), getHeight(), this);
				}
			};

			contentPane.setLayout(null);
			setContentPane(contentPane);

		} catch (Exception e) {
			System.out.println("No encontré la imagen en /IMG/background.jpg");
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmresumen) {
			actionPerformedMntmresumen(e);
		}
		if (e.getSource() == mntmAcercaDe) {
			actionPerformedMntmAcercaDe(e);
		}
		if (e.getSource() == mntmObsequiO) {
			actionPerformedMntmObsequi(e);
		}
		if (e.getSource() == mntmDescuento) {
			actionPerformedMntmDescuento(e);
		}
		if (e.getSource() == mntmListar) {
			actionPerformedMntmListar(e);
		}
		if (e.getSource() == mntmModificar) {
			actionPerformedMntmModificar(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmConsultar) {
			actionPerformedMntmConsultar(e);
		}
	}

	protected void actionPerformedMntmConsultar(ActionEvent e) {
		DlgConsultarRopa d = new DlgConsultarRopa();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}

	protected void actionPerformedMntmVender(ActionEvent e) {
		DlgVender v = new DlgVender();
		v.setLocationRelativeTo(this);
		v.setVisible(true);
	}

	protected void actionPerformedMntmModificar(ActionEvent e) {
		DlgModificar m = new DlgModificar();
		m.setLocationRelativeTo(this);
		m.setVisible(true);
	}

	protected void actionPerformedMntmListar(ActionEvent e) {
		DlgListar m = new DlgListar();
		m.setLocationRelativeTo(this);
		m.setVisible(true);
	}

	protected void actionPerformedMntmDescuento(ActionEvent e) {
		DlgConfigurarDescuentos cd = new DlgConfigurarDescuentos();
		cd.setLocationRelativeTo(this);
		cd.setVisible(true);
	}

	protected void actionPerformedMntmObsequi(ActionEvent e) {
		DlgConfigurarObsequio o = new DlgConfigurarObsequio();
		o.setLocationRelativeTo(this);
		o.setVisible(true);

	}

	protected void actionPerformedMntmAcercaDe(ActionEvent e) {
		DlgAcercade ac = new DlgAcercade();
		ac.setLocationRelativeTo(this);
		ac.setVisible(true);
	}

	protected void actionPerformedMntmresumen(ActionEvent e) {
		DlgResumen re = new DlgResumen();
		re.setLocationRelativeTo(this);
		re.setVisible(true);
	}
}
