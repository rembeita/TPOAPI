package SistemaGimnasio;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Z_Empleado_Alta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(EmpleadosController controlador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Z_Empleado_Alta frame = new Z_Empleado_Alta(controlador);
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
	public Z_Empleado_Alta(EmpleadosController controlador) {
		setTitle("Alta de empleado");
		setBounds(100, 100, 664, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 193, 612, 107);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(15, 44, 69, 20);
		contentPane.add(lblTipo);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()==0){ // Profesor Clase
					panel.setVisible(true);
				}
				else if(comboBox.getSelectedIndex()==1){ // Profesor Completo
					panel.setVisible(false);
				}
				else{ // Administrativo
					panel.setVisible(false);
				}
			}
		});
		comboBox.setBounds(96, 41, 312, 26);
		contentPane.add(comboBox);
		
		JLabel lblNombre = new JLabel("Valor hora");
		lblNombre.setBounds(15, 16, 98, 20);
		panel.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(147, 13, 161, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Horas trabajadas");
		lblNewLabel.setBounds(15, 66, 119, 20);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 63, 161, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(15, 102, 69, 20);
		contentPane.add(lblNombre_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(96, 99, 312, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setBounds(15, 144, 69, 20);
		contentPane.add(lblSueldo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(96, 141, 312, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()==0){ // Profesor Clase
					controlador.altaEmpleadoProfesorClase(textField_2.getText(), Float.parseFloat(textField.getText()), Integer.parseInt(textField_1.getText()));
				}
				else if(comboBox.getSelectedIndex()==1){ // Profesor Completo
					controlador.altaEmpleadoCompleto(textField.getText(), Float.parseFloat(textField_1.getText()));
				}
				else{ // Administrativo
					controlador.altaEmpleadoAdministrativo(textField.getText(), Float.parseFloat(textField_1.getText()));
				}
				JOptionPane.showMessageDialog(null, "Empleado dado de alta");
			}
		});
		btnGuardar.setBounds(15, 382, 115, 29);
		contentPane.add(btnGuardar);
		comboBox.addItem("Profesor - Clase");
		comboBox.addItem("Profesor - Completo");
		comboBox.addItem("Administrativo");
	}
}
