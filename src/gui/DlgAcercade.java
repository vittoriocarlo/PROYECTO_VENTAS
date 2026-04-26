package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DlgAcercade extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	//private final JPanel contentPanel = new JPanel();
	private final PanelConFondo contentPanel = new PanelConFondo();
	private JLabel lblNewLabel;
	private JLabel lblCibertecCiclo;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JPanel panelcerrar;
	private JLabel lblNewLabel_2;
	private JLabel lblDesarrolladoPor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAcercade dialog = new DlgAcercade();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAcercade() {
		setUndecorated(true);
		setTitle("Acerca de la tienda");
		setBounds(100, 100, 764, 483);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Sistema de Venta de Ropa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Fira Code", Font.BOLD, 30));
		lblNewLabel.setBounds(142, 58, 466, 42);
		contentPanel.add(lblNewLabel);
		
		lblCibertecCiclo = new JLabel("Cibertec - Ciclo 1");
		lblCibertecCiclo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCibertecCiclo.setFont(new Font("Fira Code", Font.PLAIN, 19));
		lblCibertecCiclo.setBounds(261, 124, 225, 42);
		contentPanel.add(lblCibertecCiclo);
		
		lblNewLabel_1 = new JLabel("2026");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Fira Code", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(282, 270, 180, 42);
		contentPanel.add(lblNewLabel_1);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 764, 33);
		contentPanel.add(panel);
		
		panelcerrar = new JPanel();
		panelcerrar.setLayout(null);
		panelcerrar.setBounds(0, 0, 764, 33);
		panel.add(panelcerrar);
		
		lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.setBounds(710, 0, 54, 33);
		panelcerrar.add(lblNewLabel_2);
		lblNewLabel_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setPreferredSize(new Dimension(40, 40));
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblNewLabel_2.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent e) {
		        dispose(); 
		    }
		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		        
		        lblNewLabel_2.setForeground(java.awt.Color.WHITE);
		    }
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent e) {
		        
		        lblNewLabel_2.setForeground(java.awt.Color.WHITE);
		    }
		});
		
		lblDesarrolladoPor = new JLabel("Ingeniería de Sistemas Informática");
		lblDesarrolladoPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesarrolladoPor.setFont(new Font("Fira Code", Font.PLAIN, 18));
		lblDesarrolladoPor.setBounds(177, 191, 400, 42);
		contentPanel.add(lblDesarrolladoPor);
		
		Timer timer = new Timer(15, new ActionListener() {
	        float opacity = 0f;
	        public void actionPerformed(ActionEvent e) {
	            opacity += 0.05f;
	            if (opacity > 1f) {
	                setOpacity(1f);
	                ((Timer)e.getSource()).stop();
	            } else {
	                setOpacity(opacity);
	            }
	        }
	    });
	    timer.start();
	}
	public void actionPerformed(ActionEvent e) {
	}
	
	

    
	class PanelConFondo extends JPanel {
	    private Image imagen;

	    public PanelConFondo() {
	        setLayout(null); 
	        try {
	            
	            java.net.URL imgUrl = getClass().getResource("/IMG/acercade.png");
	            if (imgUrl != null) {
	                imagen = new ImageIcon(imgUrl).getImage();
	            }
	        } catch (Exception e) {
	            System.err.println("Imagen no encontrada");
	        }
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;
	        if (imagen != null) {
	            g2d.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
	            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
	            g2d.setColor(Color.BLACK);
	            g2d.fillRect(0, 0, getWidth(), getHeight());
	            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
	        }
	    }
	}
} 

