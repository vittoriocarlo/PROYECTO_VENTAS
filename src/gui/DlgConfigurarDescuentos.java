package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;

public class DlgConfigurarDescuentos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblA_1;
	private JLabel lblA;
	private JLabel lblMasDe;
	private JTextField txtporcentaje3;
	private JTextField txtporcentaje4;
	private JButton btnNewButton;
	private JButton btnCancelar;
	private JTextField txtporcentaje2;
	private JTextField txtporcentaje1;
	private JPanel panel;
	private JPanel panelcerrar;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarDescuentos dialog = new DlgConfigurarDescuentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarDescuentos() {
		setUndecorated(true);
		setTitle("Configurar porcentajes de descuento");
		setBounds(100, 100, 748, 459);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("1 a 5 unidades:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 68, 130, 30);
		contentPanel.add(lblNewLabel);
		
		lblA_1 = new JLabel("11 a 15 unidades:");
		lblA_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblA_1.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblA_1.setBounds(10, 148, 130, 30);
		contentPanel.add(lblA_1);
		
		lblA = new JLabel("6 a 10 unidades:");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblA.setBounds(10, 108, 130, 30);
		contentPanel.add(lblA);
		
		lblMasDe = new JLabel("Mas de 15 unidades:");
		lblMasDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblMasDe.setFont(new Font("Fira Code", Font.PLAIN, 12));
		lblMasDe.setBounds(10, 188, 154, 30);
		contentPanel.add(lblMasDe);
		
		txtporcentaje3 = new JTextField();
		txtporcentaje3.setColumns(10);
		txtporcentaje3.setBounds(163, 154, 130, 19);
		contentPanel.add(txtporcentaje3);
		
		txtporcentaje4 = new JTextField();
		txtporcentaje4.setColumns(10);
		txtporcentaje4.setBounds(163, 194, 130, 19);
		contentPanel.add(txtporcentaje4);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Fira Code", Font.PLAIN, 12));
		btnNewButton.setBounds(25, 261, 104, 35);
		contentPanel.add(btnNewButton);
		
		btnCancelar = new JButton("Limpiar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Fira Code", Font.PLAIN, 12));
		btnCancelar.setBounds(189, 261, 104, 35);
		contentPanel.add(btnCancelar);
		
		txtporcentaje2 = new JTextField();
		txtporcentaje2.setColumns(10);
		txtporcentaje2.setBounds(163, 114, 130, 19);
		contentPanel.add(txtporcentaje2);
		
		txtporcentaje1 = new JTextField();
		txtporcentaje1.setColumns(10);
		txtporcentaje1.setBounds(163, 74, 130, 19);
		contentPanel.add(txtporcentaje1);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 748, 33);
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
		lblNewLabel_1.setBounds(0, 0, 748, 33);
		panel.setBounds(0, 0, 748, 33);
		
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
		
		panel_1 = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
		        try {
		            // El "/" busca en la carpeta src. Verifica que el nombre sea IGUAL.
		            ImageIcon icono = new ImageIcon(getClass().getResource("/IMG/descuento.jpg"));
		            g.drawImage(icono.getImage(), 0, 0, getWidth(), getHeight(), this);
		        } catch (Exception e) {
		            // Si sale este mensaje en consola, es que no moviste la imagen al src
		            System.out.println("Problemas al cargar la imagen");
		        }
		    }
			
		};
		panel_1.setBounds(347, 0, 401, 459);
		contentPanel.add(panel_1);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnNewButton_1(e);
		}
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		txtporcentaje1.setText("");
		txtporcentaje2.setText("");
		txtporcentaje3.setText("");
		txtporcentaje4.setText("");
		txtporcentaje1.requestFocus();
		
		
	}
}
