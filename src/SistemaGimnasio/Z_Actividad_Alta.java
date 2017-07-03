package SistemaGimnasio;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Z_Actividad_Alta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(ActividadesController controlador_actividades, EmpleadosController controlador_empleados) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Z_Actividad_Alta frame = new Z_Actividad_Alta(controlador_actividades, controlador_empleados);
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
	public Z_Actividad_Alta(ActividadesController controlador_actividades, EmpleadosController controlador_empleados) {
		setTitle("Alta de actividad");
		setBounds(100, 100, 647, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 34, 69, 20);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(204, 28, 259, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDia = new JLabel("Fecha (YYYY-MM-dd)");
		lblDia.setBounds(15, 74, 174, 20);
		contentPane.add(lblDia);
		
		textField_1 = new JTextField();
		textField_1.setBounds(204, 68, 75, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(15, 116, 69, 20);
		contentPane.add(lblHora);
		
		textField_2 = new JTextField();
		textField_2.setBounds(204, 110, 75, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblProfesor = new JLabel("Profesor");
		lblProfesor.setBounds(15, 209, 69, 20);
		contentPane.add(lblProfesor);
		
		JComboBox<EmpleadoView> comboBox = new JComboBox<EmpleadoView>();
		comboBox.setBounds(204, 203, 259, 26);
		contentPane.add(comboBox);
		Vector<EmpleadoView> profesores = controlador_empleados.getEmpleadosProfesoresClase();
		for (int i = 0; i < profesores.size(); i++) {
			comboBox.addItem(profesores.elementAt(i));
		}
		if(comboBox.getItemCount()>0){
			comboBox.setSelectedIndex(0);
		}		
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_1.getSelectedIndex()==1)
					comboBox.setEnabled(false);
				else
					comboBox.setEnabled(true);
			}
		});
		comboBox_1.setBounds(204, 161, 169, 26);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("Con Profesor");
		comboBox_1.addItem("Libre");
		comboBox_1.setSelectedIndex(0);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(15, 162, 69, 20);
		contentPane.add(lblTipo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_1.getSelectedIndex()==1){
					controlador_actividades.altaActividadLibre(textField.getText(), textField_1.getText(), textField_2.getText());
					JOptionPane.showMessageDialog(null, "Actividad dada de alta");
				}
				else{
					controlador_actividades.altaActividadProfesor(textField.getText(), textField_1.getText(), textField_2.getText(), comboBox.getItemAt(comboBox.getSelectedIndex()).getLegajo());
					JOptionPane.showMessageDialog(null, "Actividad dada de alta");
				}
			}
		});
		btnGuardar.setBounds(15, 290, 115, 29);
		contentPane.add(btnGuardar);
	}
}