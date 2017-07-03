package SistemaGimnasio;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Z_Socio_Baja extends JFrame {

	private JPanel contentPane;

	
	public static void main(SociosController controlador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Z_Socio_Baja frame = new Z_Socio_Baja(controlador);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Z_Socio_Baja(SociosController controlador) {
		setBounds(100, 100, 628, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(15, 24, 437, 26);
		contentPane.add(comboBox);
		Vector<Socio_View> socios = controlador.getSocios();
		for (int i = 0; i < socios.size(); i++) {
			comboBox.addItem(socios.elementAt(i).toString());
		}
		if(comboBox.getItemCount()>0){
			comboBox.setSelectedIndex(0);
		}
		
		JButton btnNewButton = new JButton("Dar de baja");
		btnNewButton.setBounds(15, 99, 115, 29);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getItemCount()>0){
					controlador.eliminarSocio(socios.elementAt((comboBox.getSelectedIndex())).getNroSocio());
					comboBox.removeItemAt(comboBox.getSelectedIndex());
					JOptionPane.showMessageDialog(null, "Socio dado de baja");
				}
				else{
					JOptionPane.showMessageDialog(null, "No hay mas socios");
				}
			}
		});

	}

}
