package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
	private JButton btnNewButton;
	private JTable table;
	private int xMouse, yMouse;
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
		scrollPane.setBounds(10, 125, 699, 357);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Fira Code", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descripci\u00F3n", "Modelo", "Talla", "Stock", "Precio (S/.)"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(99);
		table.getColumnModel().getColumn(2).setPreferredWidth(82);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Listar");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Fira Code", Font.BOLD, 12));
		btnNewButton.setBounds(302, 77, 119, 30);
		contentPanel.add(btnNewButton);
		
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
		        
		        lblNewLabel.setForeground(java.awt.Color.BLACK);
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
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	}
}
