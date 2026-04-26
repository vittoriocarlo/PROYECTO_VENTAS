package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Dimension;

public class DlgVender extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtprecio;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnlimpiar;
	private JButton btnprocesar;
	private JLabel lblNombreCliente;
	private JTextField txtcantidad;
	private JLabel lblPrecioUnitario;
	private JTextField txtnombrecliente;
	private JLabel lblStockActual;
	private JTextField txtstock;
	private JLabel lblDescripcin;
	private JTextField txtdescripcion;
	private JPanel panel;
	private JPanel panelcerrar;
	private JLabel lblNewLabel_1;
	private JTextField txtcodigo;
	private int xMouse, yMouse;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	
	private String codigo, descripcion, nombreCliente, obsequio, pDesc;
	private double precio, importeCompra, importeDescuento, importePagar;
	private int stock, cantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgVender dialog = new DlgVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgVender() {
		setUndecorated(true);
		setBounds(100, 100, 720, 468);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Codigo");
			lblNewLabel.setFont(new Font("Fira Code", Font.PLAIN, 12));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(30, 60, 92, 29);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblCantidad = new JLabel("Cantidad");
			lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
			lblCantidad.setFont(new Font("Fira Code", Font.PLAIN, 12));
			lblCantidad.setBounds(41, 138, 92, 29);
			contentPanel.add(lblCantidad);
		}
		{
			txtprecio = new JTextField();
			txtprecio.setEditable(false);
			txtprecio.setBounds(153, 100, 137, 21);
			contentPanel.add(txtprecio);
			txtprecio.setColumns(10);
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 245, 628, 196);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setColumnHeaderView(txtS);
		txtS.setEditable(false);
		
		ImageIcon iconlimpiar = null;
		ImageIcon iconprocesar = null;
		
		
		try {
            // Se escala a 20x20 para que entre bien en el botón
            iconprocesar = new ImageIcon(new ImageIcon(getClass().getResource("/IMG/procesar.png"))
                .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
            iconlimpiar = new ImageIcon(new ImageIcon(getClass().getResource("/IMG/limpiar.png"))
                .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        } catch (Exception e) {
            System.out.println("Error: No se encontraron las imágenes en src/IMG/");
        }
		{
			btnprocesar = new JButton("Procesar");
			btnprocesar.setIcon(iconprocesar);
			btnprocesar.addActionListener(this);
			btnprocesar.setIconTextGap(10);
	        btnprocesar.setFont(new Font("Fira Code", Font.PLAIN, 11));
			btnprocesar.setBounds(41, 188, 120, 34);
			contentPanel.add(btnprocesar);
		}
		
		btnlimpiar = new JButton("Limpiar");
		btnlimpiar.setIcon(iconlimpiar);
		btnlimpiar.addActionListener(this);
		btnlimpiar.setHorizontalTextPosition(SwingConstants.RIGHT); 
        btnlimpiar.setIconTextGap(10);
		btnlimpiar.setFont(new Font("Fira Code", Font.PLAIN, 11));
		btnlimpiar.setBounds(168, 188, 120, 34);
		contentPanel.add(btnlimpiar);
		
		
		lblNombreCliente = new JLabel("Nombre cliente");
		lblNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCliente.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblNombreCliente.setBounds(349, 60, 113, 29);
		contentPanel.add(lblNombreCliente);
		
		txtcantidad = new JTextField();
		txtcantidad.setColumns(10);
		txtcantidad.setBounds(153, 142, 137, 21);
		contentPanel.add(txtcantidad);
		
		lblPrecioUnitario = new JLabel("Precio S/.");
		lblPrecioUnitario.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioUnitario.setFont(new Font("Fira Code", Font.PLAIN, 11));
		lblPrecioUnitario.setBounds(30, 99, 113, 29);
		contentPanel.add(lblPrecioUnitario);
		
		txtnombrecliente = new JTextField();
		txtnombrecliente.setColumns(10);
		txtnombrecliente.setBounds(472, 64, 137, 21);
		contentPanel.add(txtnombrecliente);
		
		lblStockActual = new JLabel("Stock");
		lblStockActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblStockActual.setFont(new Font("Fira Code", Font.PLAIN, 11));
		lblStockActual.setBounds(349, 96, 113, 29);
		contentPanel.add(lblStockActual);
		
		txtstock = new JTextField();
		txtstock.setEditable(false);
		txtstock.setColumns(10);
		txtstock.setBounds(472, 100, 137, 21);
		contentPanel.add(txtstock);
		
		lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcin.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblDescripcin.setBounds(349, 138, 113, 29);
		contentPanel.add(lblDescripcin);
		
		txtdescripcion = new JTextField();
		txtdescripcion.setEditable(false);
		txtdescripcion.setColumns(10);
		txtdescripcion.setBounds(472, 142, 137, 21);
		contentPanel.add(txtdescripcion);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 720, 33);
		contentPanel.add(panel);
		
		panelcerrar = new JPanel();
		panelcerrar.setLayout(null);
		panelcerrar.setBounds(0, 0, 54, 33);
		panel.add(panelcerrar);
		
		lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setPreferredSize(new Dimension(40, 40));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setBounds(0, 0, 54, 33);
		
		lblNewLabel_1.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent e) {
		        dispose(); 
		    }
		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		        
		        lblNewLabel_1.setForeground(java.awt.Color.WHITE);
		    }
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent e) {
		        
		        lblNewLabel_1.setForeground(java.awt.Color.BLACK);
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
		panelcerrar.add(lblNewLabel_1);
		
		txtcodigo = new JTextField();
		txtcodigo.setColumns(10);
		txtcodigo.setBounds(151, 64, 137, 21);
		txtcodigo.addActionListener(this);
		contentPanel.add(txtcodigo);
		
		
		ImageIcon iconDescuentoEscalado = new ImageIcon(new ImageIcon("src/IMG/icondescuento.png")
		    .getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));

		ImageIcon iconRegaloEscalado = new ImageIcon(new ImageIcon("src/IMG/iconregalo.png")
		    .getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER); 
		lblNewLabel_2.setIcon(iconDescuentoEscalado); 
		lblNewLabel_2.setBounds(343, 188, 70, 34);
		contentPanel.add(lblNewLabel_2);
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblNewLabel_2.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				DlgConfigurarDescuentos vDesc = new DlgConfigurarDescuentos();
				vDesc.setModal(true); 
				vDesc.setLocationRelativeTo(null); 
				vDesc.setVisible(true);
			}
		});

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(iconRegaloEscalado); 
		lblNewLabel_3.setBounds(438, 188, 70, 34);
		contentPanel.add(lblNewLabel_3);
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				DlgConfigurarObsequio vObs = new DlgConfigurarObsequio();
				vObs.setModal(true);
				vObs.setLocationRelativeTo(null);
				vObs.setVisible(true);
			}
		});
		
		
		
		panel.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mousePressed(java.awt.event.MouseEvent e) {
		        xMouse = e.getX(); 
		        yMouse = e.getY(); 
		    }
		});

		panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
		    @Override
		    public void mouseDragged(java.awt.event.MouseEvent e) {
		        int x = e.getXOnScreen();
		        int y = e.getYOnScreen();
		        
		        setLocation(x - xMouse, y - yMouse);
		    }
		});
		
		
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnlimpiar) {
			actionPerformedBtnlimpiar(e);
			
			
			
		}
		
		else if (e.getSource() == txtcodigo) {
	        buscarProducto();
	    }
	   
	    else if (e.getSource() == btnprocesar) {
	        actionPerformedBtnProcesar(e);
	    }
	}
	protected void actionPerformedBtnlimpiar(ActionEvent e) {
		
		txtcodigo.setText("");
		txtprecio.setText("");
		txtstock.setText("");
		txtdescripcion.setText("");
		txtcodigo.requestFocus();
		
	}
	void buscarProducto() {

		codigo = txtcodigo.getText().trim();


		if (codigo.equalsIgnoreCase("C001")) {

		descripcion = ventanaOperaciones.descripcion1;

		precio = ventanaOperaciones.precio1;

		stock = ventanaOperaciones.stock1;

		} else if (codigo.equalsIgnoreCase("C002")) {

		descripcion = ventanaOperaciones.descripcion2;

		precio = ventanaOperaciones.precio2;

		stock = ventanaOperaciones.stock2;

		} else if (codigo.equalsIgnoreCase("C003")) {

		descripcion = ventanaOperaciones.descripcion3;

		precio = ventanaOperaciones.precio3;

		stock = ventanaOperaciones.stock3;

		} else if(codigo.equalsIgnoreCase("C004")) {
			descripcion = ventanaOperaciones.descripcion4;

			precio = ventanaOperaciones.precio4;

			stock = ventanaOperaciones.stock4;
			
		} else if(codigo.equalsIgnoreCase("C005")) {
			descripcion = ventanaOperaciones.descripcion5;

			precio = ventanaOperaciones.precio5;

			stock = ventanaOperaciones.stock5;
			
		} else if(codigo.equalsIgnoreCase("C006")) {
			descripcion = ventanaOperaciones.descripcion6;

			precio = ventanaOperaciones.precio6;

			stock = ventanaOperaciones.stock6;	
			
		} else if(codigo.equalsIgnoreCase("C007")) {
			descripcion = ventanaOperaciones.descripcion7;

			precio = ventanaOperaciones.precio7;

			stock = ventanaOperaciones.stock7;
			
		} else if(codigo.equalsIgnoreCase("C008")) {
			descripcion = ventanaOperaciones.descripcion8;

			precio = ventanaOperaciones.precio8;

			stock = ventanaOperaciones.stock8;	
			
		} else {
			
		

		javax.swing.JOptionPane.showMessageDialog(this, "Código no existe");

		return;

		}

		txtdescripcion.setText(descripcion);
		txtprecio.setText("S/. " + precio);
		txtstock.setText("" + stock);

		}


		void leerDatosVenta() {

		nombreCliente = txtnombrecliente.getText().trim();
		cantidad = Integer.parseInt(txtcantidad.getText().trim());

		}


		void calcularVenta() {

		importeCompra = precio * cantidad;

		pDesc = DlgConfigurarDescuentos.porcentaje;

		if (pDesc == null) pDesc = "0%"; 

		double numDesc = Double.parseDouble(pDesc.replace("%", "")) / 100.0;

		importeDescuento = importeCompra * numDesc;

		importePagar = importeCompra - importeDescuento;

		obsequio = DlgConfigurarObsequio.tipoObsequio;

		if (obsequio == null) obsequio = "Ninguno";

		}
		
		void actualizarStock() {
		    
		    if (codigo.equalsIgnoreCase("C001")) {
		        ventanaOperaciones.stock1 -= cantidad;
		    } else if (codigo.equalsIgnoreCase("C002")) {
		        ventanaOperaciones.stock2 -= cantidad;
		    } else if (codigo.equalsIgnoreCase("C003")) {
		        ventanaOperaciones.stock3 -= cantidad;
		    } else if (codigo.equalsIgnoreCase("C004")) {
		        ventanaOperaciones.stock3 -= cantidad;
		    }else if (codigo.equalsIgnoreCase("C005")) {
		        ventanaOperaciones.stock3 -= cantidad;
		    }else if (codigo.equalsIgnoreCase("C006")) {
		        ventanaOperaciones.stock3 -= cantidad;
		    }else if (codigo.equalsIgnoreCase("C007")) {
		        ventanaOperaciones.stock3 -= cantidad;
		    }else if (codigo.equalsIgnoreCase("C008")) {
		        ventanaOperaciones.stock3 -= cantidad;
		    }
		    
		    
		    txtstock.setText("" + (stock - cantidad));
		}


		void mostrarBoleta() {

		txtS.setText(" *** BOLETA DE VENTA ***\n");
		txtS.append("--------------------------------\n");
		txtS.append("CLIENTE: " + nombreCliente + "\n");
		txtS.append("PRODUCTO: " + descripcion + "\n");
		txtS.append("PRECIO UNITARIO: S/. " + precio + "\n");
		txtS.append("CANTIDAD: " + cantidad + "\n");
		txtS.append("--------------------------------\n");
		txtS.append("IMPORTE COMPRA: S/. " +  importeCompra + "\n");
		txtS.append("DESCUENTO (" + pDesc + "): S/. " +  importeDescuento + "\n");
		txtS.append("TOTAL A PAGAR: S/. " +  importePagar + "\n");
		txtS.append("--------------------------------\n");
		txtS.append("OBSEQUIO: " + obsequio + "\n");

		}

		protected void actionPerformedBtnProcesar(ActionEvent e) {

			if (txtnombrecliente.getText().trim().isEmpty() || 
			        txtcodigo.getText().trim().isEmpty() || 
			        txtcantidad.getText().trim().isEmpty()) {
			        
			        JOptionPane.showMessageDialog(this, "¡Debe completar todos los datos!", "Error", JOptionPane.ERROR_MESSAGE);
			        return; 
			    }

			    try {
			        
			        leerDatosVenta();

			        if (cantidad <= stock) {
			            calcularVenta();
			            actualizarStock(); 
			            mostrarBoleta();
			            JOptionPane.showMessageDialog(this, "Venta realizada con éxito.");
			        } else {
			            JOptionPane.showMessageDialog(this, "No hay stock suficiente.");
			        }
			    } catch (NumberFormatException ex) {
			        JOptionPane.showMessageDialog(this, "En cantidad solo se permiten números.");
			    }
			}
}

