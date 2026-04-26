package gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Dimension;

public class DlgListar extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JButton btnlistar;
	private JTable table;
	private JPanel panel;
	private JPanel panelcerrar;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgListar dialog = new DlgListar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgListar() {
		setUndecorated(true);
		setBounds(100, 100, 770, 507);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 125, 750, 372);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Fira Code", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Precio", "Talla", "Stock", "Descripcion", "Color", "Proveedor"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(99);
		table.getColumnModel().getColumn(2).setPreferredWidth(82);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		scrollPane.setViewportView(table);

		
		// modificamos cabecera
		table.getTableHeader().setFont(new Font("Fira Code", Font.PLAIN, 11));
		
		// centramos los titulos
		((javax.swing.table.DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer())
		    .setHorizontalAlignment(SwingConstants.CENTER);
		
		
		table.setFont(new Font("Fira Code", Font.PLAIN, 12));
		

		ImageIcon iconList = null;
        
        try {
            // Se escala a 20x20 para que entre bien en el botón
            iconList = new ImageIcon(new ImageIcon(getClass().getResource("/IMG/listar.png"))
                .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
            
        } catch (Exception e) {
            System.out.println("Error: No se encontraron las imágenes en src/IMG/");
        }
		
		btnlistar = new JButton("Listar");
		btnlistar.setIcon(iconList);
		btnlistar.addActionListener(this);
		btnlistar.setHorizontalTextPosition(SwingConstants.RIGHT); 
        btnlistar.setIconTextGap(10);
		btnlistar.setFont(new Font("Fira Code", Font.PLAIN, 11));
		btnlistar.setBounds(302, 77, 119, 30);
		contentPanel.add(btnlistar);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 770, 33);
		contentPanel.add(panel);
		
		panelcerrar = new JPanel();
		panelcerrar.setLayout(null);
		panelcerrar.setBounds(0, 0, 54, 33);
		panel.add(panelcerrar);
		
		lblNewLabel = new JLabel("X");
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setPreferredSize(new Dimension(40, 40));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setBounds(0, 0, 54, 33);
		
		lblNewLabel.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent e) {
		        dispose(); 
		    }
		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		        
		        lblNewLabel.setForeground(java.awt.Color.WHITE);
		    }
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent e) {
		        
		        lblNewLabel.setForeground(java.awt.Color.WHITE);
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
		panelcerrar.add(lblNewLabel);
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnlistar) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		agregarFila(model, ventanaOperaciones.codigo1, ventanaOperaciones.precio1, ventanaOperaciones.talla1,
				ventanaOperaciones.stock1, ventanaOperaciones.descripcion1, ventanaOperaciones.color1,
				ventanaOperaciones.proveedor1);
		agregarFila(model, ventanaOperaciones.codigo2, ventanaOperaciones.precio2, ventanaOperaciones.talla2,
				ventanaOperaciones.stock2, ventanaOperaciones.descripcion2, ventanaOperaciones.color2,
				ventanaOperaciones.proveedor2);
		agregarFila(model, ventanaOperaciones.codigo3, ventanaOperaciones.precio3, ventanaOperaciones.talla3,
				ventanaOperaciones.stock3, ventanaOperaciones.descripcion3, ventanaOperaciones.color3,
				ventanaOperaciones.proveedor3);
		agregarFila(model, ventanaOperaciones.codigo4, ventanaOperaciones.precio4, ventanaOperaciones.talla4,
				ventanaOperaciones.stock4, ventanaOperaciones.descripcion4, ventanaOperaciones.color4,
				ventanaOperaciones.proveedor4);
		agregarFila(model, ventanaOperaciones.codigo5, ventanaOperaciones.precio5, ventanaOperaciones.talla5,
				ventanaOperaciones.stock5, ventanaOperaciones.descripcion5, ventanaOperaciones.color5,
				ventanaOperaciones.proveedor5);
		agregarFila(model, ventanaOperaciones.codigo6, ventanaOperaciones.precio6, ventanaOperaciones.talla6,
				ventanaOperaciones.stock6, ventanaOperaciones.descripcion6, ventanaOperaciones.color6,
				ventanaOperaciones.proveedor6);
		agregarFila(model, ventanaOperaciones.codigo7, ventanaOperaciones.precio7, ventanaOperaciones.talla7,
				ventanaOperaciones.stock7, ventanaOperaciones.descripcion7, ventanaOperaciones.color7,
				ventanaOperaciones.proveedor7);
		agregarFila(model, ventanaOperaciones.codigo8, ventanaOperaciones.precio8, ventanaOperaciones.talla8,
				ventanaOperaciones.stock8, ventanaOperaciones.descripcion8, ventanaOperaciones.color8,
				ventanaOperaciones.proveedor8);
	}

	private void agregarFila(DefaultTableModel model, String codigo, double precio, String talla, int stock,
			String descripcion, String color, String proveedor) {
		Object[] fila = { codigo, precio, talla, stock, descripcion, color, proveedor };
		model.addRow(fila);
	}
}
