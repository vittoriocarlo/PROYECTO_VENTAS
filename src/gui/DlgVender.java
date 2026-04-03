package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
	private JTextField txtCantidad;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnlimpiar;
	private JButton btnVender;
	private JComboBox cboModelo;
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
			JLabel lblNewLabel = new JLabel("Modelo");
			lblNewLabel.setFont(new Font("Fira Code", Font.PLAIN, 12));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(20, 92, 92, 29);
			contentPanel.add(lblNewLabel);
		}
		{
			cboModelo = new JComboBox();
			cboModelo.setBounds(153, 93, 135, 21);
			contentPanel.add(cboModelo);
		}
		{
			JLabel lblCantidad = new JLabel("Cantidad");
			lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
			lblCantidad.setFont(new Font("Fira Code", Font.PLAIN, 12));
			lblCantidad.setBounds(30, 166, 92, 29);
			contentPanel.add(lblCantidad);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setBounds(151, 131, 137, 21);
			contentPanel.add(txtCantidad);
			txtCantidad.setColumns(10);
		}
		{
			btnVender = new JButton("Vender");
			btnVender.addActionListener(this);
			btnVender.setFont(new Font("Fira Code", Font.PLAIN, 12));
			btnVender.setBounds(51, 231, 92, 34);
			contentPanel.add(btnVender);
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 286, 628, 155);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setColumnHeaderView(txtS);
		txtS.setEditable(false);
		{
			btnlimpiar = new JButton("Limpiar");
			btnlimpiar.addActionListener(this);
			btnlimpiar.setFont(new Font("Fira Code", Font.PLAIN, 12));
			btnlimpiar.setBounds(178, 231, 92, 34);
			contentPanel.add(btnlimpiar);
		}
		
		lblNombreCliente = new JLabel("Nombre cliente");
		lblNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCliente.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblNombreCliente.setBounds(321, 92, 113, 29);
		contentPanel.add(lblNombreCliente);
		
		txtcantidad = new JTextField();
		txtcantidad.setColumns(10);
		txtcantidad.setBounds(153, 170, 137, 21);
		contentPanel.add(txtcantidad);
		
		lblPrecioUnitario = new JLabel("Precio Unitario");
		lblPrecioUnitario.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioUnitario.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblPrecioUnitario.setBounds(20, 131, 113, 29);
		contentPanel.add(lblPrecioUnitario);
		
		txtnombrecliente = new JTextField();
		txtnombrecliente.setColumns(10);
		txtnombrecliente.setBounds(443, 92, 137, 21);
		contentPanel.add(txtnombrecliente);
		
		lblStockActual = new JLabel("Stock");
		lblStockActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblStockActual.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblStockActual.setBounds(321, 127, 113, 29);
		contentPanel.add(lblStockActual);
		
		txtstock = new JTextField();
		txtstock.setColumns(10);
		txtstock.setBounds(443, 131, 137, 21);
		contentPanel.add(txtstock);
		
		lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcin.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblDescripcin.setBounds(321, 166, 113, 29);
		contentPanel.add(lblDescripcin);
		
		txtdescripcion = new JTextField();
		txtdescripcion.setColumns(10);
		txtdescripcion.setBounds(443, 171, 137, 21);
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
		
		
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnlimpiar) {
			actionPerformedBtnlimpiar(e);
			
		}
	}
	protected void actionPerformedBtnlimpiar(ActionEvent e) {
		//cboModelo.setSelectedIndex(0);
		txtCantidad.setText("");
		txtCantidad.requestFocus();
		cboModelo.requestFocus();
	}
}
