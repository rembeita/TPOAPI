package SistemaGimnasio;
//Bug: Si das de baja un administrativo, luego cambias de tipo
//y volves a administativo sigue apareciendo el objeto dado de baja
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Z_Empleado_Baja extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(EmpleadosController controlador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Z_Empleado_Baja frame = new Z_Empleado_Baja(controlador);
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
	public Z_Empleado_Baja(EmpleadosController controlador) {
		setBounds(100, 100, 613, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(146, 16, 271, 26);
		contentPane.add(comboBox);		
		comboBox.addItem("Administrativo");
		comboBox.addItem("Profesor - Completo");
		comboBox.addItem("Profesor - Clase");
					
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(15, 19, 69, 20);
		contentPane.add(lblTipo);
		
		JButton btnDarDeBaja = new JButton("Dar de baja");
		btnDarDeBaja.setBounds(15, 129, 115, 29);
		contentPane.add(btnDarDeBaja);
		btnDarDeBaja.setEnabled(false);
				
		JLabel lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setBounds(15, 61, 115, 20);
		contentPane.add(lblEmpleado);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(146, 58, 271, 26);
		contentPane.add(comboBox_1);
		Vector<EmpleadoView> empViewEmpleadosAdm = controlador.getEmpleadosAdministrativos();
		Vector<EmpleadoView> empViewEmpleadosProfCompleto = controlador.getEmpleadosProfesoresCompleto();
		Vector<EmpleadoView> empViewEmpleadosProfClase = controlador.getEmpleadosProfesoresClase();	
		
		for (int i = 0; i < empViewEmpleadosAdm.size(); i++) {
			comboBox_1.addItem(empViewEmpleadosAdm.elementAt(i).toString());
		}
		if(comboBox_1.getItemCount()>0){
			comboBox_1.setSelectedIndex(0);
			btnDarDeBaja.setEnabled(true);
		}
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()==0){ // Administrativo
					comboBox_1.removeAllItems();
					for (int i = 0; i < empViewEmpleadosAdm.size(); i++) {
						comboBox_1.addItem(empViewEmpleadosAdm.elementAt(i).toString());
					}
					if(comboBox_1.getItemCount()>0){
						comboBox_1.setSelectedIndex(0);
						btnDarDeBaja.setEnabled(true);
					}
				}
				else if(comboBox.getSelectedIndex()==1){ // Profesor completo
					comboBox_1.removeAllItems();
					for (int i = 0; i < empViewEmpleadosProfCompleto.size(); i++) {
						comboBox_1.addItem(empViewEmpleadosProfCompleto.elementAt(i).toString());
					}
					if(comboBox_1.getItemCount()>0){
						comboBox_1.setSelectedIndex(0);
						btnDarDeBaja.setEnabled(true);
					}
				}
				else{
					comboBox_1.removeAllItems();
					for (int i = 0; i < empViewEmpleadosProfClase.size(); i++) {
						comboBox_1.addItem(empViewEmpleadosProfClase.elementAt(i).toString());
					}
					if(comboBox_1.getItemCount()>0){
						comboBox_1.setSelectedIndex(0);
						btnDarDeBaja.setEnabled(true);
					}
				}
				
			}
		});
		
		btnDarDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()==0){ // Administrativo
					controlador.bajaEmpleadoAdministrativo(empViewEmpleadosAdm.elementAt(comboBox_1.getSelectedIndex()).getLegajo());
					comboBox_1.removeItemAt(comboBox_1.getSelectedIndex());
				}
				else if(comboBox.getSelectedIndex()==1){ // Profesor completo
					controlador.bajaEmpleadoProfesorCompleto(empViewEmpleadosAdm.elementAt(comboBox_1.getSelectedIndex()).getLegajo());
					comboBox_1.removeItemAt(comboBox_1.getSelectedIndex());
				}
				else{
					controlador.bajaEmpleadoProfesorClase(empViewEmpleadosAdm.elementAt(comboBox_1.getSelectedIndex()).getLegajo());
					comboBox_1.removeItemAt(comboBox_1.getSelectedIndex());
				}
				JOptionPane.showMessageDialog(null, "Empleado dado de baja");	
				
			}
		});
		
	}

}
