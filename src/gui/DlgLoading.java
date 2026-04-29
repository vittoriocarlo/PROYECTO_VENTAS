package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer; // IMPORTANTE: Usar el de javax.swing

public class DlgLoading extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JProgressBar progressBar;

	public static void main(String[] args) {
		
		try {
	        
	        com.formdev.flatlaf.FlatDarkLaf.setup();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgLoading frame = new DlgLoading();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DlgLoading() {
		
		setUndecorated(true); 
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 442);
		setLocationRelativeTo(null); 
		
		Color verdeOscuro = new Color(0, 150, 100); 
		Color fondoBarra = new Color(40, 40, 40);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 30, 30)); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setFont(new Font("Fira Code", Font.BOLD, 13)); 
		progressBar.setForeground(verdeOscuro);
		progressBar.setBackground(fondoBarra);
		progressBar.setStringPainted(true);
		progressBar.setBounds(181, 209, 310, 30);
		
		progressBar.putClientProperty("FlatLaf.style", 
			    "selectionBackground: #FFFFFF; " + 
			    "selectionForeground: #1A1A1A; " + 
			    "outlineWidth: 0;"                  
			);
	
		int anchoPantalla = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int altoPantalla = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

		
		int anchoBarra = 500; 
		int altoBarra = 35;

		
		int x = (anchoPantalla - anchoBarra) / 2;
		int y = (altoPantalla - altoBarra) / 2;

		
		progressBar.setBounds(x, y, anchoBarra, altoBarra);
		
		
		ImageIcon icono = new ImageIcon(getClass().getResource("/IMG/background-loading.png"));
		final java.awt.Image imagenTienda = icono.getImage();

		
		contentPane = new JPanel() {
		    private static final long serialVersionUID = 1L;
		    @Override
		    protected void paintComponent(java.awt.Graphics g) {
		        super.paintComponent(g);
		        
		        g.drawImage(imagenTienda, 0, 0, getWidth(), getHeight(), this);
		        
		       
		        g.setColor(new Color(0, 0, 0, 130)); 
		        g.fillRect(0, 0, getWidth(), getHeight());
		    }
		};

		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	

			contentPane.add(progressBar);
		
		
		Timer t = new Timer(30, new ActionListener() {
			int cont = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				cont++;
				progressBar.setValue(cont);
				
				if (cont <= 30) progressBar.setString("Cargando módulos...");
				if (cont > 30 && cont <= 70) progressBar.setString("Conectando con inventario...");
				if (cont > 70 && cont < 100) progressBar.setString("Finalizando...");
				
				if (cont == 100) {
					((Timer)e.getSource()).stop(); 
					dispose(); 
					
					
					ventanaOperaciones principal = new ventanaOperaciones();
					principal.setVisible(true);
				}
			}
		});
		
		t.start(); 
	}
}