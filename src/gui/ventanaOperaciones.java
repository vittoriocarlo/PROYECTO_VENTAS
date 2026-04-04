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
	private JMenuBar menuBar;
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
	private JMenuItem mntmObsequi;
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
	/**
	 * Create the frame.
	 */
	public ventanaOperaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 450);
		setTitle("SISTEMA DE VENTA DE ROPA");
		
		
		
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
		
		mntmObsequi = new JMenuItem("Obsequio");
		mntmObsequi.addActionListener(this);
		mntmObsequi.setFont(new Font("Fira Code", Font.PLAIN, 12));
		mnConfiguracion.add(mntmObsequi);
		
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
		if (e.getSource() == mntmObsequi) {
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
