package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
	private JComboBox cboModelo;
	private JLabel lblPrecios;
	private JTextField txtPrecio;
	private JLabel lblStockActual;
	private JTextField txtStock;
	private JButton btnGuardar;
	private JLabel lblProveedor;
	private JTextField txtproveedor;
	private JButton btnlimpiar;
	private JLabel lblDescripcin;
	private JTextField textField;
	private JLabel lblTalla;
	private JTextField textField_1;
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
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblNewLabel.setBounds(49, 114, 95, 28);
		contentPanel.add(lblNewLabel);
		
		cboModelo = new JComboBox();
		cboModelo.setBounds(199, 118, 125, 21);
		contentPanel.add(cboModelo);
		
		lblPrecios = new JLabel("Precio (S/.)");
		lblPrecios.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecios.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblPrecios.setBounds(49, 152, 95, 28);
		contentPanel.add(lblPrecios);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(199, 156, 125, 21);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblStockActual = new JLabel("Stock Actual");
		lblStockActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblStockActual.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblStockActual.setBounds(49, 190, 95, 28);
		contentPanel.add(lblStockActual);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(199, 194, 125, 21);
		contentPanel.add(txtStock);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Fira Code", Font.PLAIN, 12));
		btnGuardar.setBounds(35, 377, 118, 38);
		contentPanel.add(btnGuardar);
		
		lblProveedor = new JLabel("Proveedor");
		lblProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedor.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblProveedor.setBounds(49, 228, 95, 28);
		contentPanel.add(lblProveedor);
		
		txtproveedor = new JTextField();
		txtproveedor.setColumns(10);
		txtproveedor.setBounds(199, 232, 125, 21);
		contentPanel.add(txtproveedor);
		
		btnlimpiar = new JButton("Limpiar");
		btnlimpiar.addActionListener(this);
		btnlimpiar.setFont(new Font("Fira Code", Font.PLAIN, 12));
		btnlimpiar.setBounds(206, 377, 118, 38);
		contentPanel.add(btnlimpiar);
		
		lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcin.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblDescripcin.setBounds(49, 266, 95, 28);
		contentPanel.add(lblDescripcin);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(199, 270, 125, 21);
		contentPanel.add(textField);
		
		lblTalla = new JLabel("Talla");
		lblTalla.setHorizontalAlignment(SwingConstants.CENTER);
		lblTalla.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblTalla.setBounds(49, 304, 95, 28);
		contentPanel.add(lblTalla);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(199, 308, 125, 21);
		contentPanel.add(textField_1);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 735, 33);
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
		panelcerrar.add(lblNewLabel_1);
		
		panel_1 = new JPanel() {
			protected void paintComponent(Graphics g) {
			}
		};
		panel_1.setBounds(388, 0, 347, 485);
		contentPanel.add(panel_1);
		
		
		lblNewLabel_1.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent e) {
		        dispose(); 
		    }
		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		       
		        lblNewLabel_1.setForeground(Color.WHITE);
		    }
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent e) {
		       
		        lblNewLabel_1.setForeground(Color.BLACK);
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
		if (e.getSource() == btnlimpiar) {
			actionPerformedBtnlimpiar(e);
		}
	}
	protected void actionPerformedBtnlimpiar(ActionEvent e) {
		//cboModelo.setSelectedIndex(0);
		txtPrecio.setText("");
		txtStock.setText("");
		txtproveedor.setText("");
		cboModelo.requestFocus();
		txtPrecio.requestFocus();
	}
}
