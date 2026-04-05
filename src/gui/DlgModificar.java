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
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Cursor;
import java.awt.Dimension;

public class DlgModificar extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblPrecios;
	private JTextField txtPrecio;
	private JLabel lblStockActual;
	private JTextField txttalla;
	private JButton btnGuardar;
	private JLabel lblProveedor;
	private JTextField txtstock;
	private JButton btnlimpiar;
	private JLabel lblDescripcin;
	private JTextField txtdescripcion;
	private JLabel lblTalla;
	private JTextField txtcolor;
	private JPanel panel;
	private JPanel panelcerrar;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private int xMouse, yMouse;
	private JTextField txtcodigo;
	private JLabel lblColor;
	private JTextField txtproveedor;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModificar dialog = new DlgModificar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModificar() {
		setUndecorated(true);
		setBounds(100, 100, 735, 485);
		getContentPane().setLayout(new BorderLayout());
		
		// Quitamos el borde para evitar líneas blancas
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblNewLabel.setBounds(49, 72, 95, 28);
		contentPanel.add(lblNewLabel);
		
		lblPrecios = new JLabel("Precio S/.");
		lblPrecios.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecios.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblPrecios.setBounds(49, 112, 95, 28);
		contentPanel.add(lblPrecios);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(199, 116, 125, 21);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblStockActual = new JLabel("Talla");
		lblStockActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblStockActual.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblStockActual.setBounds(49, 150, 95, 28);
		contentPanel.add(lblStockActual);
		
		txttalla = new JTextField();
		txttalla.setColumns(10);
		txttalla.setBounds(199, 154, 125, 21);
		contentPanel.add(txttalla);
		
		ImageIcon iconCons = null;
		ImageIcon iconModi = null;
        ImageIcon iconLimp = null;
        try {
        	iconCons = new ImageIcon(new ImageIcon(getClass().getResource("/IMG/consultar.png"))
                    .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
            
            iconModi = new ImageIcon(new ImageIcon(getClass().getResource("/IMG/guardar.png"))
                .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
            iconLimp = new ImageIcon(new ImageIcon(getClass().getResource("/IMG/limpiar.png"))
                .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        } catch (Exception e) {
            System.out.println("Error: No se encontraron las imágenes en src/IMG/");
        }
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(iconModi);
        btnGuardar.setHorizontalTextPosition(SwingConstants.RIGHT); 
        btnGuardar.setIconTextGap(10);
		btnGuardar.setFont(new Font("Fira Code", Font.PLAIN, 11));
		btnGuardar.setBounds(154, 377, 107, 38);
		contentPanel.add(btnGuardar);
		
		btnlimpiar = new JButton("Limpiar");
		btnlimpiar.setIcon(iconLimp);
		btnlimpiar.addActionListener(this);
		btnlimpiar.setHorizontalTextPosition(SwingConstants.RIGHT); 
        btnlimpiar.setIconTextGap(10);
		btnlimpiar.setFont(new Font("Fira Code", Font.PLAIN, 11));
		btnlimpiar.setBounds(271, 377, 107, 38);
		contentPanel.add(btnlimpiar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(iconCons);
		btnConsultar.addActionListener(this);
		btnConsultar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnConsultar.setIconTextGap(10);
		btnConsultar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnConsultar.setFont(new Font("Fira Code", Font.PLAIN, 11));
		btnConsultar.setBounds(24, 377, 120, 36);
		contentPanel.add(btnConsultar);
		
		lblProveedor = new JLabel("Stock");
		lblProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedor.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblProveedor.setBounds(49, 188, 95, 28);
		contentPanel.add(lblProveedor);
		
		txtstock = new JTextField();
		txtstock.setColumns(10);
		txtstock.setBounds(199, 192, 125, 21);
		contentPanel.add(txtstock);
		
		
		lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcin.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblDescripcin.setBounds(49, 226, 95, 28);
		contentPanel.add(lblDescripcin);
		
		txtdescripcion = new JTextField();
		txtdescripcion.setColumns(10);
		txtdescripcion.setBounds(199, 230, 125, 21);
		contentPanel.add(txtdescripcion);
		
		lblTalla = new JLabel("Color");
		lblTalla.setHorizontalAlignment(SwingConstants.CENTER);
		lblTalla.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblTalla.setBounds(49, 264, 95, 28);
		contentPanel.add(lblTalla);
		
		txtcolor = new JTextField();
		txtcolor.setColumns(10);
		txtcolor.setBounds(199, 268, 125, 21);
		contentPanel.add(txtcolor);

		
		panel_1 = new JPanel() {
			private static final long serialVersionUID = 1L;
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					java.net.URL url = getClass().getResource("/IMG/modificar.jpg");
					if (url != null) {
						ImageIcon icono = new ImageIcon(url);
						g.drawImage(icono.getImage(), 0, 0, getWidth(), getHeight(), this);
					}
				} catch (Exception e) {
					System.out.println("Error al cargar la imagen");
				}
			}
		};
		panel_1.setBounds(388, 0, 347, 485); 
		contentPanel.add(panel_1);
		
		
		panel = new JPanel();
		panel.setOpaque(false); 
		panel.setLayout(null);
		panel.setBounds(0, 0, 735, 33);
		contentPanel.add(panel);
		
		panelcerrar = new JPanel();
		panelcerrar.setOpaque(false); 
		panelcerrar.setLayout(null);
		panelcerrar.setBounds(0, 0, 54, 33);
		panel.add(panelcerrar);
		
		lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setBounds(0, 0, 54, 33);
		panelcerrar.add(lblNewLabel_1);
		
		txtcodigo = new JTextField();
		txtcodigo.setColumns(10);
		txtcodigo.setBounds(199, 76, 125, 21);
		contentPanel.add(txtcodigo);
		
		lblColor = new JLabel("Proveedor");
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		lblColor.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblColor.setBounds(56, 302, 88, 33);
		contentPanel.add(lblColor);
		
		txtproveedor = new JTextField();
		txtproveedor.setColumns(10);
		txtproveedor.setBounds(199, 309, 125, 21);
		contentPanel.add(txtproveedor);
		
		
		
		
		lblNewLabel_1.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) { dispose(); }
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) { 
				lblNewLabel_1.setForeground(Color.WHITE); 
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) { 
				lblNewLabel_1.setForeground(null); 
			}
		});

		
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				xMouse = e.getX(); yMouse = e.getY();
			}
		});
		panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			@Override
			public void mouseDragged(java.awt.event.MouseEvent e) {
				setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen() - yMouse);
			}
		});
		
		
		setOpacity(0f);
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
		if (e.getSource() == btnlimpiar) {
			actionPerformedBtnlimpiar(e);
		}
	}
	protected void actionPerformedBtnlimpiar(ActionEvent e) {
		//cboModelo.setSelectedIndex(0);
		txtPrecio.setText("");
		txttalla.setText("");
		txtstock.setText("");
		txtcodigo.requestFocus();
		txtPrecio.requestFocus();
	}
}
