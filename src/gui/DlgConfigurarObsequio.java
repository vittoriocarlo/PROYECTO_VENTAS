package gui;

import java.awt.BorderLayout;
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
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Graphics;
import java.awt.Cursor;
import java.awt.Dimension;

public class DlgConfigurarObsequio extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField txtObsequio;
	private JLabel lblCantidadMinima;
	private JTextField txtCantidadMinima;
	private JButton btnconfirmar;
	private JButton btnlimpiar;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panelcerrar;
	private JLabel lblNewLabel_1;
	private int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarObsequio dialog = new DlgConfigurarObsequio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarObsequio() {
		setUndecorated(true);
		setTitle("CONFIGURAR OBSEQUIO");
		setBounds(100, 100, 748, 459);
		getContentPane().setLayout(new BorderLayout());
		
		// 1. QUITAMOS EL BORDE BLANCO (TitledBorder/EtchedBorder)
		// Dejamos que FlatLaf decida el fondo y borde según el tema actual
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Tipo Obsequio:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 66, 110, 39);
		contentPanel.add(lblNewLabel);
		
		txtObsequio = new JTextField();
		txtObsequio.setBounds(158, 74, 172, 24);
		contentPanel.add(txtObsequio);
		txtObsequio.setColumns(10);
		
		lblCantidadMinima = new JLabel("Cantidad Minima");
		lblCantidadMinima.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadMinima.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblCantidadMinima.setBounds(10, 115, 110, 39);
		contentPanel.add(lblCantidadMinima);
		
		txtCantidadMinima = new JTextField();
		txtCantidadMinima.setColumns(10);
		txtCantidadMinima.setBounds(158, 120, 172, 24);
		contentPanel.add(txtCantidadMinima);
		
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
		btnconfirmar.setIcon(iconconfirmar);
		btnconfirmar.setHorizontalTextPosition(SwingConstants.RIGHT); 
	    btnconfirmar.setIconTextGap(10);
		btnconfirmar.setFont(new Font("Fira Code", Font.PLAIN, 11));
		btnconfirmar.setBounds(10, 317, 119, 39);
		contentPanel.add(btnconfirmar);
		
		btnlimpiar = new JButton("Limpiar");
		btnlimpiar.setIcon(iconlimpiar);
	    btnconfirmar.setHorizontalTextPosition(SwingConstants.RIGHT); 
        btnconfirmar.setIconTextGap(10);
		btnlimpiar.addActionListener(this);
		btnlimpiar.setFont(new Font("Fira Code", Font.PLAIN, 11));
		btnlimpiar.setBounds(211, 317, 119, 39);
		contentPanel.add(btnlimpiar);
		
		panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
		        try {
		            java.net.URL imgUrl = getClass().getResource("/IMG/obsequio.jpg");
		            if(imgUrl != null) {
		                ImageIcon icono = new ImageIcon(imgUrl);
		                g.drawImage(icono.getImage(), 0, 0, getWidth(), getHeight(), this);
		            }
		        } catch (Exception e) {
		            System.out.println("No se pudo cargar la imagen");
		        }
			}
		};
		panel.setBounds(377, 0, 371, 459);
		contentPanel.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 748, 33);
		contentPanel.add(panel_1);
		
		panelcerrar = new JPanel();
		panelcerrar.setLayout(null);
		panelcerrar.setBounds(0, 0, 54, 33);
		panel_1.add(panelcerrar);
		
		lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setBounds(0, 0, 54, 33);
		panelcerrar.add(lblNewLabel_1);
		
		// Lógica de cerrado y movimiento (Sin colores manuales para no romper FlatLaf)
		// Lógica de cerrado con estilo limpio
				lblNewLabel_1.addMouseListener(new java.awt.event.MouseAdapter() {
					@Override
					public void mouseClicked(java.awt.event.MouseEvent e) { 
						dispose(); 
					}
					@Override
					public void mouseEntered(java.awt.event.MouseEvent e) {
						// En lugar de rojo, podemos usar un color que resalte sutilmente 
						// o simplemente dejar que FlatLaf maneje el hover si fuera un botón.
						// Aquí solo cambiaremos el color del texto a blanco brillante.
						lblNewLabel_1.setForeground(Color.WHITE);
					}
					@Override
					public void mouseExited(java.awt.event.MouseEvent e) {
						// Volver al color por defecto del tema FlatLaf
						lblNewLabel_1.setForeground(null); 
					}
				});

		panel_1.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				xMouse = e.getX(); yMouse = e.getY();
			}
		});
		
		panel_1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			@Override
			public void mouseDragged(java.awt.event.MouseEvent e) {
				setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen() - yMouse);
			}
		});
		
		// Animación de entrada (opcional, si te da problemas quítala)
		Timer timer = new Timer(15, e -> {
			float opacity = getOpacity() + 0.05f;
			if (opacity > 1f) { setOpacity(1f); ((Timer)e.getSource()).stop(); }
			else { setOpacity(opacity); }
		});
		setOpacity(0f);
		timer.start();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnlimpiar) {
			actionPerformedBtnCancelar(e);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		txtObsequio.setText("");
		txtCantidadMinima.setText("");
		txtObsequio.requestFocus();
	}
}
