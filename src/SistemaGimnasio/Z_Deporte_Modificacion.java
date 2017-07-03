package SistemaGimnasio;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Z_Deporte_Modificacion extends JFrame {

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
					Z_Deporte_Modificacion frame = new Z_Deporte_Modificacion(controlador);
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
	public Z_Deporte_Modificacion(DeportesController controlador) {
		setTitle("Modificar deporte");
		setBounds(100, 100, 530, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setBounds(15, 16, 69, 20);
		contentPane.add(lblDeporte);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 88, 69, 20);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(123, 85, 342, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Descripcion");
		lblNewLabel.setBounds(15, 130, 93, 20);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(123, 127, 342, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(15, 198, 115, 29);
		contentPane.add(btnGuardar);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		Vector<DeporteView> deportes = controlador.getDeportes();
		comboBox.setBounds(99, 13, 366, 26);
		contentPane.add(comboBox);
		
	
		for (int i = 0; i < deportes.size(); i++) {
			comboBox.addItem(deportes.elementAt(i).toString());
		}
		if(comboBox.getItemCount()==0)
			btnGuardar.setEnabled(false);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(deportes.elementAt(comboBox.getSelectedIndex()).getNombre());
				textField_1.setText(deportes.elementAt(comboBox.getSelectedIndex()).getDescripcion());
			}
		});		
		
	
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.modificarDeporte(deportes.elementAt(comboBox.getSelectedIndex()).getCodDeporte(), textField.getText(), textField_1.getText());
				JOptionPane.showMessageDialog(null, "Deporte modificado");
			}
		});
		
	}
}
