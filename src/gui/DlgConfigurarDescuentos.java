package gui;

import java.awt.BorderLayout;
import javax.swing.JLayeredPane;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;

public class DlgConfigurarDescuentos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblA_1;
	private JLabel lblMasDe;
	private JTextField txtvalortotal;
	private JButton btnconfirmar;
	private JButton btnlimpiar;
	private JTextField txtdescuento;
	private JTextField txtmonto;
	private JPanel panel;
	private JPanel panelcerrar;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarDescuentos dialog = new DlgConfigurarDescuentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarDescuentos() {
	    setUndecorated(true);
	    setTitle("Configurar porcentajes de descuento");
	    setBounds(100, 100, 748, 459);
	    getContentPane().setLayout(new BorderLayout());

	    contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
	    getContentPane().add(contentPanel, BorderLayout.CENTER);
	    contentPanel.setLayout(null);

	    JPanel panelIzquierdo = new JPanel();
	    panelIzquierdo.setBounds(0, 0, 350, 459);
	    panelIzquierdo.setLayout(null);
	    panelIzquierdo.setPreferredSize(new Dimension(350, 0));
	    contentPanel.add(panelIzquierdo);

	    lblNewLabel = new JLabel("Monto");
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setFont(new Font("Fira Code Light", Font.PLAIN, 12));
	    lblNewLabel.setBounds(20, 50, 130, 30);
	    panelIzquierdo.add(lblNewLabel);

	    lblA_1 = new JLabel("Descuento");
	    lblA_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblA_1.setFont(new Font("Fira Code", Font.PLAIN, 12));
	    lblA_1.setBounds(20, 90, 130, 30);
	    panelIzquierdo.add(lblA_1);

	    lblMasDe = new JLabel("Valor total");
	    lblMasDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblMasDe.setFont(new Font("Fira Code", Font.PLAIN, 12));
	    lblMasDe.setBounds(38, 148, 112, 30);
	    panelIzquierdo.add(lblMasDe);

	    txtmonto = new JTextField();
	    txtmonto.setBounds(163, 56, 130, 19);
	    panelIzquierdo.add(txtmonto);

	    txtdescuento = new JTextField();
	    txtdescuento.setEditable(false);
	    txtdescuento.setBounds(163, 96, 130, 19);
	    panelIzquierdo.add(txtdescuento);

	    txtvalortotal = new JTextField();
	    txtvalortotal.setBounds(163, 154, 130, 19);
	    panelIzquierdo.add(txtvalortotal);
	    
	    ImageIcon iconconfirmar = null;
        ImageIcon iconlimpiar = null;
        try {
            // Se escala a 20x20 para que entre bien en el botón
            iconconfirmar = new ImageIcon(new ImageIcon(getClass().getResource("/IMG/confirmar.png"))
                .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
            iconlimpiar = new ImageIcon(new ImageIcon(getClass().getResource("/IMG/limpiar.png"))
                .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        } catch (Exception e) {
            System.out.println("Error: No se encontraron las imágenes en src/IMG/");
        }

	    btnconfirmar = new JButton("Aceptar");
	    btnconfirmar.addActionListener(this);
	    btnconfirmar.setIcon(iconconfirmar);
	    btnconfirmar.setHorizontalTextPosition(SwingConstants.RIGHT); 
        btnconfirmar.setIconTextGap(10);
	    btnconfirmar.setFont(new Font("Fira Code", Font.PLAIN, 11));
	    btnconfirmar.setBounds(30, 218, 120, 35);
	    panelIzquierdo.add(btnconfirmar);

	    btnlimpiar = new JButton("Limpiar");
	    btnlimpiar.setIcon(iconlimpiar);
	    btnconfirmar.setHorizontalTextPosition(SwingConstants.RIGHT); 
        btnconfirmar.setIconTextGap(10);
	    btnlimpiar.setFont(new Font("Fira Code", Font.PLAIN, 11));
	    btnlimpiar.addActionListener(this);
	    btnlimpiar.setBounds(184, 218, 120, 35);
	    panelIzquierdo.add(btnlimpiar);
	    
	    	 
	 lblNewLabel_1 = new JLabel("X");
	 lblNewLabel_1.setFont(new Font("Calibri Light", Font.BOLD, 20));
	 lblNewLabel_1.setForeground(Color.WHITE);
	 lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	
	 lblNewLabel_1.setBounds(10, 10, 30, 30);

	 lblNewLabel_1.addMouseListener(new java.awt.event.MouseAdapter() {
	     public void mouseClicked(java.awt.event.MouseEvent e) {
	         dispose();
	     }
	     public void mouseEntered(java.awt.event.MouseEvent e) {
	         lblNewLabel_1.setForeground(Color.WHITE);
	     }
	     public void mouseExited(java.awt.event.MouseEvent e) {
	         lblNewLabel_1.setForeground(Color.WHITE);
	     }
	 });

	 
	 panelIzquierdo.add(lblNewLabel_1);
	 panelIzquierdo.setComponentZOrder(lblNewLabel_1, 0);
	 panelIzquierdo.repaint();
	 
	
	 panelIzquierdo.addMouseListener(new java.awt.event.MouseAdapter() {
	     @Override
	     public void mousePressed(java.awt.event.MouseEvent e) {
	         xMouse = e.getX();
	         yMouse = e.getY();
	     }
	 });

	 panelIzquierdo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
	     @Override
	     public void mouseDragged(java.awt.event.MouseEvent e) {
	         int x = e.getXOnScreen();
	         int y = e.getYOnScreen();
	         setLocation(x - xMouse, y - yMouse);
	     }
	 });


	    panel_1 = new JPanel() {
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            try {
	                ImageIcon icono = new ImageIcon(getClass().getResource("/IMG/descuento.jpg"));
	                g.drawImage(icono.getImage(), 0, 0, getWidth(), getHeight(), this);
	            } catch (Exception e) {
	                System.out.println("Problemas al cargar la imagen");
	            }
	        }
	    };
	    panel_1.setBounds(388, 0, 398, 459);

	    panel_1.setLayout(null); 
	    contentPanel.add(panel_1);

	
	 panel_1.addComponentListener(new java.awt.event.ComponentAdapter() {
	     public void componentResized(java.awt.event.ComponentEvent e) {
	         int x = 10; 
	         int y = (panel_1.getHeight() / 2) - 15; 
	         lblNewLabel_1.setBounds(x, y, 40, 30);
	     }
	 });


	    
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
		if (e.getSource() == btnconfirmar) {
			actionPerformedBtnconfirmar(e);
		}
		if (e.getSource() == btnlimpiar) {
			actionPerformedBtnNewButton_1(e);
		}
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		txtmonto.setText("");
		txtdescuento.setText("");
		txtvalortotal.setText("");
		txtmonto.requestFocus();
		
		
	}
	protected void actionPerformedBtnconfirmar(ActionEvent e) {
	}
}
