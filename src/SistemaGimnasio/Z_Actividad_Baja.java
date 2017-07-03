package SistemaGimnasio;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Z_Actividad_Baja extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(ActividadesController controlador) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Z_Actividad_Baja frame = new Z_Actividad_Baja(controlador);
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
	public Z_Actividad_Baja(ActividadesController controlador) {
		setTitle("Baja actividad");
		setBounds(100, 100, 666, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblActividad = new JLabel("Actividad");
		lblActividad.setBounds(15, 27, 69, 20);
		contentPane.add(lblActividad);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(99, 24, 501, 26);
		contentPane.add(comboBox);
		Vector<Actividad> actividades = controlador.getActividades();
		for (int i = 0; i < actividades.size(); i++) {
			//comboBox.addItem(actividades.elementAt(i).nombre);
			comboBox.addItem(actividades.elementAt(i).getNombre());
		}
		if(comboBox.getItemCount()>0){
			comboBox.setSelectedIndex(0);
		}
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(15, 94, 115, 29);
		contentPane.add(btnEliminar);
	}

}
