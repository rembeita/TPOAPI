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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Z_Deporte_Alta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(DeportesController controlador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Z_Deporte_Alta frame = new Z_Deporte_Alta(controlador);
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
	public Z_Deporte_Alta(DeportesController controlador) {
		setTitle("Alta de deporte");
		setBounds(100, 100, 506, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 35, 90, 20);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(120, 32, 329, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(15, 85, 110, 20);
		contentPane.add(lblDescripcion);
		
		textField_1 = new JTextField();
		textField_1.setBounds(120, 85, 329, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.altaDeporte(textField.getText(), textField_1.getText());
				JOptionPane.showMessageDialog(null, "Deporte dado de alta");
			}
		});
		btnGuardar.setBounds(10, 163, 115, 29);
		contentPane.add(btnGuardar);
	}
}
