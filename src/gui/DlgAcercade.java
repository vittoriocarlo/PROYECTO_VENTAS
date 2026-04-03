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
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgAcercade extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblDesarrolladoPorVittorio;
	private JLabel lblCibertecCiclo;
	private JLabel lblNewLabel_1;

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
		setBounds(100, 100, 564, 363);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Sistema de Venta de Ropa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Fira Code", Font.PLAIN, 13));
		lblNewLabel.setBounds(97, 54, 335, 42);
		contentPanel.add(lblNewLabel);
		
		lblDesarrolladoPorVittorio = new JLabel("Desarrollado por Vittorio Carlo");
		lblDesarrolladoPorVittorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesarrolladoPorVittorio.setFont(new Font("Fira Code", Font.PLAIN, 13));
		lblDesarrolladoPorVittorio.setBounds(137, 117, 259, 42);
		contentPanel.add(lblDesarrolladoPorVittorio);
		
		lblCibertecCiclo = new JLabel("Cibertec - Ciclo 1");
		lblCibertecCiclo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCibertecCiclo.setFont(new Font("Fira Code", Font.PLAIN, 13));
		lblCibertecCiclo.setBounds(169, 169, 180, 42);
		contentPanel.add(lblCibertecCiclo);
		
		lblNewLabel_1 = new JLabel("2026");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Fira Code", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(169, 231, 180, 42);
		contentPanel.add(lblNewLabel_1);
	}
	public void actionPerformed(ActionEvent e) {
	}
}
