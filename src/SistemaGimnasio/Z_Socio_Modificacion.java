package SistemaGimnasio;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Z_Socio_Modificacion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(SociosController controlador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Z_Socio_Modificacion frame = new Z_Socio_Modificacion(controlador);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Z_Socio_Modificacion(SociosController controlador) {
		setTitle("Modificacion de Socio");
		setBounds(100, 100, 680, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 66, 69, 20);
		contentPane.add(lblNombre);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(15, 103, 69, 20);
		contentPane.add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(15, 139, 69, 20);
		contentPane.add(lblTelefono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(15, 175, 69, 20);
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(173, 63, 279, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(173, 100, 279, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(173, 136, 279, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(173, 172, 279, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(15, 24, 437, 26);
		contentPane.add(comboBox);
				
		Vector<Socio_View> socios = controlador.getSocios();
		for (int i = 0; i < socios.size(); i++) {
			comboBox.addItem(socios.elementAt(i).toString());
		}
		
		if(comboBox.getItemCount()>0){
			comboBox.setSelectedIndex(0);
			textField.setText(socios.elementAt(comboBox.getSelectedIndex()).getNombre());
			textField_1.setText(socios.elementAt(comboBox.getSelectedIndex()).getDomicilio());
			textField_2.setText(socios.elementAt(comboBox.getSelectedIndex()).getTelefono());
			textField_3.setText(socios.elementAt(comboBox.getSelectedIndex()).getMail());
		}
		
		
		JButton btnNewButton = new JButton("Grabar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.modificarSocio(socios.elementAt(comboBox.getSelectedIndex()).getNroSocio(), textField_1.getText(), textField_2.getText(), textField_3.getText());
				JOptionPane.showMessageDialog(null, "Socio modificado");
			}
		});
		btnNewButton.setBounds(15, 233, 115, 29);
		contentPane.add(btnNewButton);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getItemCount()>0){
					textField.setText(socios.elementAt(comboBox.getSelectedIndex()).getNombre());
					textField_1.setText(socios.elementAt(comboBox.getSelectedIndex()).getDomicilio());
					textField_2.setText(socios.elementAt(comboBox.getSelectedIndex()).getTelefono());
					textField_3.setText(socios.elementAt(comboBox.getSelectedIndex()).getMail());
				}
			}
		});
		
	}
}
