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
import javax.swing.JOptionPane;
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
	private int indiceActual = -1;

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
		btnGuardar.addActionListener(this);
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
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnlimpiar) {
			actionPerformedBtnlimpiar(e);
		}
	}

	private void mostrarDatos(String codigo, double precio, String talla, int stock, String descripcion, String color,
			String proveedor) {
		txtcodigo.setText(codigo);
		txtPrecio.setText(String.valueOf(precio));
		txttalla.setText(talla);
		txtstock.setText(String.valueOf(stock));
		txtdescripcion.setText(descripcion);
		txtcolor.setText(color);
		txtproveedor.setText(proveedor);
	}

	private int buscarIndicePorCodigo(String cod) {
		if (cod.equalsIgnoreCase(ventanaOperaciones.codigo1)) return 1;
		if (cod.equalsIgnoreCase(ventanaOperaciones.codigo2)) return 2;
		if (cod.equalsIgnoreCase(ventanaOperaciones.codigo3)) return 3;
		if (cod.equalsIgnoreCase(ventanaOperaciones.codigo4)) return 4;
		if (cod.equalsIgnoreCase(ventanaOperaciones.codigo5)) return 5;
		if (cod.equalsIgnoreCase(ventanaOperaciones.codigo6)) return 6;
		if (cod.equalsIgnoreCase(ventanaOperaciones.codigo7)) return 7;
		if (cod.equalsIgnoreCase(ventanaOperaciones.codigo8)) return 8;
		return -1;
	}

	private String obtenerCodigoPorIndice(int indice) {
		switch (indice) {
		case 1:
			return ventanaOperaciones.codigo1;
		case 2:
			return ventanaOperaciones.codigo2;
		case 3:
			return ventanaOperaciones.codigo3;
		case 4:
			return ventanaOperaciones.codigo4;
		case 5:
			return ventanaOperaciones.codigo5;
		case 6:
			return ventanaOperaciones.codigo6;
		case 7:
			return ventanaOperaciones.codigo7;
		case 8:
			return ventanaOperaciones.codigo8;
		default:
			return "";
		}
	}

	private boolean existeCodigoEnOtroRegistro(String nuevoCodigo, int indiceEditar) {
		for (int i = 1; i <= 8; i++) {
			if (i == indiceEditar) {
				continue;
			}
			if (nuevoCodigo.equalsIgnoreCase(obtenerCodigoPorIndice(i))) {
				return true;
			}
		}
		return false;
	}

	protected void actionPerformedBtnConsultar(ActionEvent e) {
		String cod = txtcodigo.getText().trim();

		if (cod.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingresa un código de C001 a C008.");
			txtcodigo.requestFocus();
			return;
		}

		indiceActual = buscarIndicePorCodigo(cod);
		if (indiceActual == -1) {
			JOptionPane.showMessageDialog(this, "El código " + cod + " no existe.");
			actionPerformedBtnlimpiar(null);
			return;
		}

		switch (indiceActual) {
		case 1:
			mostrarDatos(ventanaOperaciones.codigo1, ventanaOperaciones.precio1, ventanaOperaciones.talla1,
					ventanaOperaciones.stock1, ventanaOperaciones.descripcion1, ventanaOperaciones.color1,
					ventanaOperaciones.proveedor1);
			break;
		case 2:
			mostrarDatos(ventanaOperaciones.codigo2, ventanaOperaciones.precio2, ventanaOperaciones.talla2,
					ventanaOperaciones.stock2, ventanaOperaciones.descripcion2, ventanaOperaciones.color2,
					ventanaOperaciones.proveedor2);
			break;
		case 3:
			mostrarDatos(ventanaOperaciones.codigo3, ventanaOperaciones.precio3, ventanaOperaciones.talla3,
					ventanaOperaciones.stock3, ventanaOperaciones.descripcion3, ventanaOperaciones.color3,
					ventanaOperaciones.proveedor3);
			break;
		case 4:
			mostrarDatos(ventanaOperaciones.codigo4, ventanaOperaciones.precio4, ventanaOperaciones.talla4,
					ventanaOperaciones.stock4, ventanaOperaciones.descripcion4, ventanaOperaciones.color4,
					ventanaOperaciones.proveedor4);
			break;
		case 5:
			mostrarDatos(ventanaOperaciones.codigo5, ventanaOperaciones.precio5, ventanaOperaciones.talla5,
					ventanaOperaciones.stock5, ventanaOperaciones.descripcion5, ventanaOperaciones.color5,
					ventanaOperaciones.proveedor5);
			break;
		case 6:
			mostrarDatos(ventanaOperaciones.codigo6, ventanaOperaciones.precio6, ventanaOperaciones.talla6,
					ventanaOperaciones.stock6, ventanaOperaciones.descripcion6, ventanaOperaciones.color6,
					ventanaOperaciones.provedor6);
			break;
		case 7:
			mostrarDatos(ventanaOperaciones.codigo7, ventanaOperaciones.precio7, ventanaOperaciones.talla7,
					ventanaOperaciones.stock7, ventanaOperaciones.descripcion7, ventanaOperaciones.color7,
					ventanaOperaciones.proveedor7);
			break;
		case 8:
			mostrarDatos(ventanaOperaciones.codigo8, ventanaOperaciones.precio8, ventanaOperaciones.talla8,
					ventanaOperaciones.stock8, ventanaOperaciones.descripcion8, ventanaOperaciones.color8,
					ventanaOperaciones.proveedor8);
			break;
		default:
			break;
		}
	}

	protected void actionPerformedBtnGuardar(ActionEvent e) {
		if (indiceActual == -1) {
			JOptionPane.showMessageDialog(this, "Primero consulta un código para poder modificarlo.");
			txtcodigo.requestFocus();
			return;
		}

		String codigo = txtcodigo.getText().trim().toUpperCase();
		String precioTxt = txtPrecio.getText().trim();
		String talla = txttalla.getText().trim();
		String stockTxt = txtstock.getText().trim();
		String descripcion = txtdescripcion.getText().trim();
		String color = txtcolor.getText().trim();
		String proveedor = txtproveedor.getText().trim();

		if (codigo.isEmpty() || precioTxt.isEmpty() || talla.isEmpty() || stockTxt.isEmpty() || descripcion.isEmpty()
				|| color.isEmpty() || proveedor.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Completa todos los campos antes de guardar.");
			return;
		}

		double precio;
		int stock;
		try {
			precio = Double.parseDouble(precioTxt);
			stock = Integer.parseInt(stockTxt);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Precio y stock deben ser valores numéricos.");
			return;
		}

		if (precio <= 0) {
			JOptionPane.showMessageDialog(this, "El precio debe ser mayor a 0.");
			return;
		}

		if (stock < 0) {
			JOptionPane.showMessageDialog(this, "El stock no puede ser negativo.");
			return;
		}

		if (existeCodigoEnOtroRegistro(codigo, indiceActual)) {
			JOptionPane.showMessageDialog(this, "Ese código ya existe en otro registro.");
			return;
		}

		switch (indiceActual) {
		case 1:
			ventanaOperaciones.codigo1 = codigo;
			ventanaOperaciones.precio1 = precio;
			ventanaOperaciones.talla1 = talla;
			ventanaOperaciones.stock1 = stock;
			ventanaOperaciones.descripcion1 = descripcion;
			ventanaOperaciones.color1 = color;
			ventanaOperaciones.proveedor1 = proveedor;
			break;
		case 2:
			ventanaOperaciones.codigo2 = codigo;
			ventanaOperaciones.precio2 = precio;
			ventanaOperaciones.talla2 = talla;
			ventanaOperaciones.stock2 = stock;
			ventanaOperaciones.descripcion2 = descripcion;
			ventanaOperaciones.color2 = color;
			ventanaOperaciones.proveedor2 = proveedor;
			break;
		case 3:
			ventanaOperaciones.codigo3 = codigo;
			ventanaOperaciones.precio3 = precio;
			ventanaOperaciones.talla3 = talla;
			ventanaOperaciones.stock3 = stock;
			ventanaOperaciones.descripcion3 = descripcion;
			ventanaOperaciones.color3 = color;
			ventanaOperaciones.proveedor3 = proveedor;
			break;
		case 4:
			ventanaOperaciones.codigo4 = codigo;
			ventanaOperaciones.precio4 = precio;
			ventanaOperaciones.talla4 = talla;
			ventanaOperaciones.stock4 = stock;
			ventanaOperaciones.descripcion4 = descripcion;
			ventanaOperaciones.color4 = color;
			ventanaOperaciones.proveedor4 = proveedor;
			break;
		case 5:
			ventanaOperaciones.codigo5 = codigo;
			ventanaOperaciones.precio5 = precio;
			ventanaOperaciones.talla5 = talla;
			ventanaOperaciones.stock5 = stock;
			ventanaOperaciones.descripcion5 = descripcion;
			ventanaOperaciones.color5 = color;
			ventanaOperaciones.proveedor5 = proveedor;
			break;
		case 6:
			ventanaOperaciones.codigo6 = codigo;
			ventanaOperaciones.precio6 = precio;
			ventanaOperaciones.talla6 = talla;
			ventanaOperaciones.stock6 = stock;
			ventanaOperaciones.descripcion6 = descripcion;
			ventanaOperaciones.color6 = color;
			ventanaOperaciones.provedor6 = proveedor;
			break;
		case 7:
			ventanaOperaciones.codigo7 = codigo;
			ventanaOperaciones.precio7 = precio;
			ventanaOperaciones.talla7 = talla;
			ventanaOperaciones.stock7 = stock;
			ventanaOperaciones.descripcion7 = descripcion;
			ventanaOperaciones.color7 = color;
			ventanaOperaciones.proveedor7 = proveedor;
			break;
		case 8:
			ventanaOperaciones.codigo8 = codigo;
			ventanaOperaciones.precio8 = precio;
			ventanaOperaciones.talla8 = talla;
			ventanaOperaciones.stock8 = stock;
			ventanaOperaciones.descripcion8 = descripcion;
			ventanaOperaciones.color8 = color;
			ventanaOperaciones.proveedor8 = proveedor;
			break;
		default:
			break;
		}

		JOptionPane.showMessageDialog(this, "Registro modificado correctamente.");
	}

	protected void actionPerformedBtnlimpiar(ActionEvent e) {
		txtcodigo.setText("");
		txtPrecio.setText("");
		txttalla.setText("");
		txtstock.setText("");
		txtdescripcion.setText("");
		txtcolor.setText("");
		txtproveedor.setText("");
		indiceActual = -1;
		txtcodigo.requestFocus();
	}
}
