package SistemaGimnasio;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class Z_Principal extends JFrame {

	private JPanel contentPane;
	private SociosController controlador_socios = new SociosController();
	private EmpleadosController controlador_empleados = new EmpleadosController();
	private DeportesController controlador_deportes = new DeportesController();
	private ActividadesController controlador_actividades = new ActividadesController();
	//private InscripcionesController controlador_incripciones = new InscripcionesController();
	

	public static void main(String[] args) {
			Z_Principal frame = new Z_Principal();
			frame.setVisible(true);		
	}
	
	public Z_Principal() {
		//////////////////////// DATOS DE PRUEBA
		controlador_socios.altaSocio("Pepe", "Peru 800", "461234567", "pepe@hotmail.com", "abono1", "2017-05-05", "Dr. 1", "Aprobado");
		controlador_socios.altaSocio("Jose", "Lima 800", "45555555", "jose@hotmail.com", "abono2", "2017-05-05", "Dr. 1", "Aprobado");
		controlador_socios.altaSocio("Juan", "Congreso 800", "466666666", "juan@hotmail.com", "abono3", "2017-05-05", "Dr. 1", "Aprobado");
		controlador_socios.altaSocio("Pedro", "Rivadavia 800", "47777777", "pedro@hotmail.com", "abono1", "2017-05-05", "Dr. 1", "Aprobado");
		controlador_socios.altaSocio("Matias", "Independencia 800", "488888888", "matias@hotmail.com", "abono1", "2017-05-05", "Dr. 1", "Aprobado");
		
		controlador_empleados.altaEmpleadoProfesorClase("Diego", 600, 6);
		controlador_empleados.altaEmpleadoProfesorClase("Marcelo" ,300, 6);
		controlador_empleados.altaEmpleadoProfesorClase("Raul", 300, 6);
		
		controlador_empleados.altaEmpleadoCompleto("German", 1500);
		controlador_empleados.altaEmpleadoCompleto("Carlos", 2000);
		controlador_empleados.altaEmpleadoCompleto("Ivan", 1500);
		
		controlador_empleados.altaEmpleadoAdministrativo("Lionel", 500);
		controlador_empleados.altaEmpleadoAdministrativo("Javier", 900);
		
		//controlador_deportes.altaDeporte("Futbol", "Descripcion 1");
		//controlador_deportes.altaDeporte("Tenis", "Descripcion 2");
		//controlador_deportes.altaDeporte("Basquet", "Descripcion 3");
		////////////////////// FIN DATOS DE PRUEBA
		
		setBounds(100, 100, 637, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 615, 31);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Administrar");
		menuBar.add(mnNewMenu);
		
		JMenu mnActividades = new JMenu("Actividades");
		mnNewMenu.add(mnActividades);
		
		JMenuItem mntmAlta_3 = new JMenuItem("Alta");
		mntmAlta_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Z_Actividad_Alta pantallaActividadAlta = new Z_Actividad_Alta(controlador_actividades, controlador_empleados);
				pantallaActividadAlta.setVisible(true);
			}
		});
		mnActividades.add(mntmAlta_3);
		
		JMenuItem mntmBaja_3 = new JMenuItem("Baja");
		mntmBaja_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Z_Actividad_Baja pantallaActividadBaja = new Z_Actividad_Baja(controlador_actividades);
				pantallaActividadBaja.setVisible(true);
			}
		});
		mnActividades.add(mntmBaja_3);
		JMenuItem mntmModificar_3 = new JMenuItem("Modificar");
		mntmModificar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Z_Actividad_Modificacion pantallaActividadModificacion = new Z_Actividad_Modificacion(controlador_actividades);
				pantallaActividadModificacion.setVisible(true);
			}
		});
		
		mnActividades.add(mntmModificar_3);
		
		JMenu mnInscripciones = new JMenu("Inscripciones");
		mnNewMenu.add(mnInscripciones);
		
		JMenuItem mntmAlta_4 = new JMenuItem("Alta");
		mntmAlta_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Z_Inscripcion_Alta pantallaInscripcionAlta = new Z_Inscripcion_Alta(controlador_incripciones);
				//pantallaInscripcionAlta.setVisible(true);
			}
		});
		mnInscripciones.add(mntmAlta_4);
		
		JMenu mnSocios = new JMenu("Socios");
		mnNewMenu.add(mnSocios);
		
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mnSocios.add(mntmAlta);
			mntmAlta.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					Z_Socio_Alta pantallaSocioAlta = new Z_Socio_Alta(controlador_socios);
					pantallaSocioAlta.setVisible(true);
				}});
		
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mnSocios.add(mntmBaja);
			mntmBaja.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					Z_Socio_Baja pantalla = new Z_Socio_Baja(controlador_socios);
					pantalla.setVisible(true);
				}});
			
		JMenuItem mntmModificacion = new JMenuItem("Modificacion");
		mnSocios.add(mntmModificacion);
			mntmModificacion.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					Z_Socio_Modificacion pantalla = new Z_Socio_Modificacion(controlador_socios);
					pantalla.setVisible(true);
				}});
			
			
		
		JMenu mnDeportes = new JMenu("Deportes");
		mnNewMenu.add(mnDeportes);
		
		JMenuItem mntmAlta_2 = new JMenuItem("Alta");
		mntmAlta_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Z_Deporte_Alta pantallaDeporteAlta = new Z_Deporte_Alta(controlador_deportes);
				pantallaDeporteAlta.setVisible(true);
			}
		});
		mnDeportes.add(mntmAlta_2);
		
		JMenuItem mntmBaja_2 = new JMenuItem("Baja");
		mntmBaja_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Z_Deporte_Baja pantallaDeporteBaja = new Z_Deporte_Baja(controlador_deportes);
				pantallaDeporteBaja.setVisible(true);
			}
		});
		mnDeportes.add(mntmBaja_2);
		
		JMenuItem mntmModificacion_2 = new JMenuItem("Modificacion");
		mntmModificacion_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Z_Deporte_Modificacion pantallaDeporteModificacion = new Z_Deporte_Modificacion(controlador_deportes);
				pantallaDeporteModificacion.setVisible(true);
			}
		});
		mnDeportes.add(mntmModificacion_2);
		
		JMenu mnCronogramas = new JMenu("Cronogramas");
		mnNewMenu.add(mnCronogramas);
		
		JMenu mnProfesores = new JMenu("Empleados");
		mnNewMenu.add(mnProfesores);
		
		JMenuItem mntmAlta_1 = new JMenuItem("Alta");
		mntmAlta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				Z_Empleado_Alta pantallaEmpleadoAlta = new Z_Empleado_Alta(controlador_empleados);
				pantallaEmpleadoAlta.setVisible(true);
			}});
		mnProfesores.add(mntmAlta_1);
		
		JMenuItem mntmBaja_1 = new JMenuItem("Baja");
		mntmBaja_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Z_Empleado_Baja pantallaEmpleadoBaja = new Z_Empleado_Baja(controlador_empleados);
				pantallaEmpleadoBaja.setVisible(true);
			}
		});
		mnProfesores.add(mntmBaja_1);
		
		JMenuItem mntmModificacion_1 = new JMenuItem("Modificacion");
		mnProfesores.add(mntmModificacion_1);
		
		JMenu mnLiquidacin = new JMenu("Liquidacion de sueldos");
		mnNewMenu.add(mnLiquidacin);
		
		JMenu mnNotificaciones = new JMenu("Notificaciones");
		mnNewMenu.add(mnNotificaciones);
		
		/*
		JLabel lblActividades = new JLabel("Actividades");
		lblActividades.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblActividades.setBounds(15, 47, 208, 31);
		contentPane.add(lblActividades);
		
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Z_Actividad_Alta pantallaActividadAlta = new Z_Actividad_Alta(controlador_actividades, controlador_empleados);
				pantallaActividadAlta.setVisible(true);
			}
		});
		btnAlta.setBounds(25, 94, 115, 29);
		contentPane.add(btnAlta);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBaja.setBounds(155, 94, 115, 29);
		contentPane.add(btnBaja);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(285, 94, 115, 29);
		contentPane.add(btnNewButton);
		*/
	}
}
