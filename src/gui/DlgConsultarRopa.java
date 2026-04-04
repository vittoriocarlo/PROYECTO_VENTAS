package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import javax.swing.JPasswordField;
import java.awt.Cursor;

public class DlgConsultarRopa extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblPrecioS;
	private JTextField txtPrecio;
	private JButton btnlimpiar;
	private JLabel lblTalla;
	private JLabel lblStock;
	private JLabel lblDescripcin;
	private JTextField txtTalla;
	private JTextField txtStock;
	private JTextField txtDescripcion;
	private JButton btnConsultar;
	private JLabel lblColor;
	private JTextField txtcolor;
	private JSplitPane splitPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panelcerrar;
	private JLabel lblNewLabel_1;
	private int xMouse, yMouse;
	private JLabel lblProveedor;
	private JTextField textField;
	private JTextField txtcodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsultarRopa dialog = new DlgConsultarRopa();
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsultarRopa() {
		setUndecorated(true);
		setOpacity(0f);
		setResizable(false);
		setBounds(100, 100, 748, 459);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(31, 59, 70, 33);
		contentPanel.add(lblNewLabel);
		
		lblPrecioS = new JLabel("Precio S/.");
		lblPrecioS.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioS.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblPrecioS.setBounds(31, 102, 88, 33);
		contentPanel.add(lblPrecioS);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(163, 108, 125, 21);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		
		
		lblTalla = new JLabel("Talla");
		lblTalla.setHorizontalAlignment(SwingConstants.CENTER);
		lblTalla.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblTalla.setBounds(31, 145, 88, 33);
		contentPanel.add(lblTalla);
		
		lblStock = new JLabel("Stock");
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblStock.setBounds(31, 188, 88, 33);
		contentPanel.add(lblStock);
		
		lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcin.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblDescripcin.setBounds(31, 231, 88, 33);
		contentPanel.add(lblDescripcin);
		
		txtTalla = new JTextField();
		txtTalla.setEditable(false);
		txtTalla.setColumns(10);
		txtTalla.setBounds(163, 151, 125, 21);
		contentPanel.add(txtTalla);
		
		txtStock = new JTextField();
		txtStock.setEditable(false);
		txtStock.setColumns(10);
		txtStock.setBounds(163, 194, 125, 21);
		contentPanel.add(txtStock);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(163, 237, 125, 21);
		contentPanel.add(txtDescripcion);
		
		ImageIcon iconCons = null;
        ImageIcon iconLimp = null;
        try {
            // Se escala a 20x20 para que entre bien en el botón
            iconCons = new ImageIcon(new ImageIcon(getClass().getResource("/IMG/consultar.png"))
                .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
            iconLimp = new ImageIcon(new ImageIcon(getClass().getResource("/IMG/limpiar.png"))
                .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        } catch (Exception e) {
            System.out.println("Error: No se encontraron las imágenes en src/IMG/");
        }
		
        btnConsultar = new JButton("Consultar");
        btnConsultar.setIcon(iconCons);
        
        btnConsultar.setHorizontalTextPosition(SwingConstants.RIGHT); 
        btnConsultar.setIconTextGap(10);
        btnConsultar.setFont(new Font("Fira Code", Font.PLAIN, 11));
        btnConsultar.setBounds(31, 380, 124, 33); 
        contentPanel.add(btnConsultar);
		
        btnlimpiar = new JButton("Limpiar");
        btnlimpiar.setIcon(iconLimp);
        btnlimpiar.addActionListener(this);
        btnlimpiar.setHorizontalTextPosition(SwingConstants.RIGHT); 
        btnlimpiar.setIconTextGap(10);
        btnlimpiar.setFont(new Font("Fira Code", Font.PLAIN, 11));
        btnlimpiar.setBounds(190, 380, 124, 33); 
        contentPanel.add(btnlimpiar);
        
        
		lblColor = new JLabel("Color");
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		lblColor.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblColor.setBounds(31, 274, 88, 33);
		contentPanel.add(lblColor);
		
		txtcolor = new JTextField();
		txtcolor.setEditable(false);
		txtcolor.setColumns(10);
		txtcolor.setBounds(163, 280, 125, 21);
		contentPanel.add(txtcolor);
		
		panel = new JPanel() {
		    @Override
		   protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        try {
		            // El "/" busca en la carpeta src. Verifica que el nombre sea IGUAL.
		            ImageIcon icono = new ImageIcon(getClass().getResource("/IMG/bg_consultar.jpg"));
		            g.drawImage(icono.getImage(), 0, 0, getWidth(), getHeight(), this);
		        } catch (Exception e) {
		            // Si sale este mensaje en consola, es que no moviste la imagen al src
		            System.out.println("Problemas al cargar la imagen");
		        }
		    }
		};
		panel.setBounds(401, 0, 347, 459);
		contentPanel.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 738, 33);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		panelcerrar = new JPanel();
		panelcerrar.setBounds(0, 0, 54, 33);
		panel_1.add(panelcerrar);
		panelcerrar.setLayout(null);
		
		lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setPreferredSize(new Dimension(40, 40));
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(0, 0, 54, 33);
		panelcerrar.add(lblNewLabel_1);
		
		lblProveedor = new JLabel("Proveedor");
		lblProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedor.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblProveedor.setBounds(31, 317, 88, 33);
		contentPanel.add(lblProveedor);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(163, 324, 125, 21);
		contentPanel.add(textField);
		
		txtcodigo = new JTextField();
		txtcodigo.setColumns(10);
		txtcodigo.setBounds(163, 66, 125, 21);
		contentPanel.add(txtcodigo);
		
		lblNewLabel_1.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				dispose(); 
			}
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				panelcerrar.setBackground(new Color(60, 63, 65)); 
				lblNewLabel_1.setForeground(Color.WHITE); 
				lblNewLabel_1.setOpaque(false); 
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				panelcerrar.setBackground(panel_1.getBackground());
		        lblNewLabel_1.setForeground(Color.WHITE);
			}
		});

		panel_1.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		
		panel_1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			@Override
			public void mouseDragged(java.awt.event.MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);
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
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnlimpiar) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		//cboModelo.setSelectedIndex(0);
		txtPrecio.setText("");
		txtTalla.setText("");
		txtStock.setText("");
		txtDescripcion.setText("");
		txtcolor.setText("");
		txtcodigo.requestFocus();
		
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
	}
}
