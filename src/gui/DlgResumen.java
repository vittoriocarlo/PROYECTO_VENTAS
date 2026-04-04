package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

// Agregamos "implements ActionListener" para que el "this" funcione
public class DlgResumen extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnmostrar;
	private JButton btndescargar;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	private JPanel panelcerrar;
	private JLabel lblNewLabel;
	private int xMouse, yMouse;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgResumen frame = new DlgResumen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // <-- Te faltaba esta llave
		}); // <-- Te faltaba este paréntesis
	}

	public DlgResumen() {
		setUndecorated(true);
		// Si quieres que se vea el FlatLaf, recuerda que el main debe tener el setup
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Mejor use DISPOSE para subventanas
		setBounds(100, 100, 850, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon iconmostrar = null;
		ImageIcon icondescargar = null;
		
		try {
            iconmostrar = new ImageIcon(new ImageIcon(getClass().getResource("/IMG/mostrar.png"))
                .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
            icondescargar = new ImageIcon(new ImageIcon(getClass().getResource("/IMG/descargar.png"))
                .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        } catch (Exception e) {
            System.out.println("Error: No se encontraron las imágenes en src/IMG/");
        }
	
		btnmostrar = new JButton("Mostrar");
		btnmostrar.setIcon(iconmostrar);
		btnmostrar.addActionListener(this); 
		btnmostrar.setIconTextGap(10);
		btnmostrar.setFont(new Font("Fira Code", Font.PLAIN, 11));
		btnmostrar.setBounds(285, 58, 120, 28); 
		contentPane.add(btnmostrar);
		
		btndescargar = new JButton("Descargar");
		btndescargar.setIcon(icondescargar); 
		btndescargar.addActionListener(this);
		btndescargar.setFont(new Font("Fira Code", Font.PLAIN, 11));
		btndescargar.setBounds(459, 58, 120, 28);
		contentPane.add(btndescargar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 108, 850, 441); 
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"Codigo", "Producto", "Descripcion", "Precio", "Fecha venta", "Descuento", "Cant. Vendida", "Total"
			}
		));
		
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true); // Para que se vea blanco hasta el fondo
		
		table.getTableHeader().setFont(new Font("Fira Code", Font.PLAIN, 11));
		
		((javax.swing.table.DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer())
		    .setHorizontalAlignment(SwingConstants.CENTER);
		
		table.setFont(new Font("Fira Code", Font.PLAIN, 12));
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 850, 33);
		contentPane.add(panel);
		
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
		panelcerrar.add(lblNewLabel);
		
		lblNewLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				dispose(); 
			}
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				panelcerrar.setBackground(new Color(60, 63, 65)); 
				lblNewLabel.setForeground(Color.WHITE); 
				lblNewLabel.setOpaque(false); 
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				panelcerrar.setBackground(panel.getBackground());
		        lblNewLabel.setForeground(Color.WHITE);
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

	// MÉTODO OBLIGATORIO PARA LOS BOTONES
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnmostrar) {
			actionPerformedBtnMostrar(e);
		}
		if (e.getSource() == btndescargar) {
			actionPerformedBtnDescargar(e);
		}
	}

	protected void actionPerformedBtnMostrar(ActionEvent e) {
		
	}

	protected void actionPerformedBtnDescargar(ActionEvent e) {
		
	}
}