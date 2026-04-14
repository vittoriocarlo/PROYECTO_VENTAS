package gui;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class DlgResumenVentas extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JTable tabla;
	private DefaultTableModel modelo;
	private JButton btnCerrar;

	public static void main(String[] args) {
		try {
			DlgResumenVentas dialog = new DlgResumenVentas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgResumenVentas() {

		setTitle("Historial de Ventas");
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());

		JLabel titulo = new JLabel("Historial de Ventas");
		titulo.setFont(new Font("Arial", Font.BOLD, 18));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(titulo, BorderLayout.NORTH);

		String columnas[] = { "Cliente", "Código", "Cantidad", "Total" };

		modelo = new DefaultTableModel(null, columnas);

		tabla = new JTable(modelo);

		JScrollPane scrollPane = new JScrollPane(tabla);

		getContentPane().add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);

		panel.add(btnCerrar);

		getContentPane().add(panel, BorderLayout.SOUTH);

		cargarVentas();
	}

	void cargarVentas() {

		try {

			BufferedReader lector = new BufferedReader(new FileReader("ventas.txt"));

			String linea;

			while ((linea = lector.readLine()) != null) {

				String datos[] = linea.split(",");

				modelo.addRow(datos);
			}

			lector.close();

		} catch (Exception e) {

			System.out.println("No se encontró el archivo ventas.txt");
		}
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnCerrar) {

			dispose();
		}
	}
}