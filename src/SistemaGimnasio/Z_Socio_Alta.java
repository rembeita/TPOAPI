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
import java.awt.event.ActionEvent;

public class Z_Socio_Alta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(SociosController controlador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Z_Socio_Alta frame = new Z_Socio_Alta(controlador);
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
	public Z_Socio_Alta(SociosController controlador) {
		setTitle("Alta de Socio");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblAbono = new JLabel("Abono");
		lblAbono.setBounds(15, 211, 69, 20);
		contentPane.add(lblAbono);
		
		JLabel lblFechaCertificado = new JLabel("Fecha certificado");
		lblFechaCertificado.setBounds(15, 247, 130, 20);
		contentPane.add(lblFechaCertificado);
		
		JLabel lblNombreProfesional = new JLabel("Nombre profesional");
		lblNombreProfesional.setBounds(15, 283, 149, 20);
		contentPane.add(lblNombreProfesional);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(15, 319, 149, 20);
		contentPane.add(lblObservaciones);
		
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
		
		textField_4 = new JTextField();
		textField_4.setBounds(173, 280, 279, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(173, 244, 279, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(173, 208, 279, 26);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(173, 316, 424, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("Grabar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.altaSocio(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText(), textField_6.getText(), textField_7.getText());
				JOptionPane.showMessageDialog(null, "Socio dado de alta");
				
			}
		});
		btnNewButton.setBounds(15, 384, 115, 29);
		contentPane.add(btnNewButton);
	}
}
