package gui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class DlgResumenVentas extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JLabel lblTotalVentas;
	private JLabel lblProductosVendidos;
	private JLabel lblPromedio;
	private JLabel lblMasVendido;
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

		setTitle("Resumen de Ventas");
		setBounds(100, 100, 420, 280);
		getContentPane().setLayout(new BorderLayout());

		JLabel titulo = new JLabel("Resumen de Ventas");
		titulo.setFont(new Font("Arial", Font.BOLD, 18));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(titulo, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		lblTotalVentas = new JLabel("Total vendido: ");
		lblTotalVentas.setBounds(40, 30, 320, 25);
		panel.add(lblTotalVentas);

		lblProductosVendidos = new JLabel("Productos vendidos: ");
		lblProductosVendidos.setBounds(40, 70, 320, 25);
		panel.add(lblProductosVendidos);

		lblPromedio = new JLabel("Promedio de venta: ");
		lblPromedio.setBounds(40, 110, 320, 25);
		panel.add(lblPromedio);

		lblMasVendido = new JLabel("Producto más vendido: ");
		lblMasVendido.setBounds(40, 150, 320, 25);
		panel.add(lblMasVendido);

		getContentPane().add(panel, BorderLayout.CENTER);

		JPanel panelBoton = new JPanel();

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);

		panelBoton.add(btnCerrar);

		getContentPane().add(panelBoton, BorderLayout.SOUTH);

		calcularResumen();
	}

	void calcularResumen() {

		double totalVentas = 0;
		int totalProductos = 0;
		int totalRegistros = 0;

		HashMap<String, Integer> contadorProductos = new HashMap<>();

		try {

			BufferedReader lector = new BufferedReader(new FileReader("ventas.txt"));
			String linea;

			while ((linea = lector.readLine()) != null) {

				String datos[] = linea.split(",");

				String codigo = datos[1];
				int cantidad = Integer.parseInt(datos[2]);
				double total = Double.parseDouble(datos[3]);

				totalProductos += cantidad;
				totalVentas += total;
				totalRegistros++;

				// Contar productos vendidos
				if (contadorProductos.containsKey(codigo)) {
					contadorProductos.put(codigo, contadorProductos.get(codigo) + cantidad);
				} else {
					contadorProductos.put(codigo, cantidad);
				}
			}

			lector.close();

		} catch (Exception e) {

			lblTotalVentas.setText("No hay ventas registradas");
			return;
		}

		double promedio = 0;

		if (totalRegistros > 0) {
			promedio = totalVentas / totalRegistros;
		}

		// Buscar producto más vendido
		String masVendido = "Ninguno";
		int mayor = 0;

		for (String codigo : contadorProductos.keySet()) {

			int cantidad = contadorProductos.get(codigo);

			if (cantidad > mayor) {
				mayor = cantidad;
				masVendido = codigo;
			}
		}

		lblTotalVentas.setText("Total vendido: S/ " + totalVentas);
		lblProductosVendidos.setText("Productos vendidos: " + totalProductos);
		lblPromedio.setText("Promedio de venta: S/ " + promedio);
		lblMasVendido.setText("Producto más vendido (código): " + masVendido);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnCerrar) {
			dispose();
		}
	}
}