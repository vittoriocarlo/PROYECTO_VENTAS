package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class DlgConfigurarObsequio extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField txtObsequio;
	private JLabel lblCantidadMinima;
	private JTextField txtCantidadMinima;
	private JButton btnAceptar;
	private JButton btnCancelar;

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
		setBounds(100, 100, 604, 413);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Tipo Obsequio:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblNewLabel.setBounds(41, 28, 110, 39);
		contentPanel.add(lblNewLabel);
		
		txtObsequio = new JTextField();
		txtObsequio.setBounds(178, 28, 172, 39);
		contentPanel.add(txtObsequio);
		txtObsequio.setColumns(10);
		
		lblCantidadMinima = new JLabel("Cantidad Minima");
		lblCantidadMinima.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadMinima.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblCantidadMinima.setBounds(41, 126, 110, 39);
		contentPanel.add(lblCantidadMinima);
		
		txtCantidadMinima = new JTextField();
		txtCantidadMinima.setColumns(10);
		txtCantidadMinima.setBounds(178, 126, 172, 39);
		contentPanel.add(txtCantidadMinima);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Fira Code", Font.BOLD, 12));
		btnAceptar.setBounds(67, 216, 119, 39);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Limpiar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Fira Code", Font.BOLD, 12));
		btnCancelar.setBounds(260, 216, 119, 39);
		contentPanel.add(btnCancelar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		txtObsequio.setText("");
		txtCantidadMinima.setText("");
		txtObsequio.requestFocus();
	}
}
