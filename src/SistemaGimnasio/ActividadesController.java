package SistemaGimnasio;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Vector;

import persistencia.ActividadesAdminPersistencia;

public class ActividadesController {

	private Vector<ActividadLibre> actividadesLibre;
	private Vector<ActividadProfesor> actividadesProfesor;

	public ActividadesController() {
		this.actividadesLibre = new Vector<ActividadLibre>();
		this.actividadesProfesor = new Vector<ActividadProfesor>();
	}

	// Inicio region Actividad Libre
	public String altaActividadLibre(String nombre, String dia, String hora) {
		ActividadLibre al = new ActividadLibre(nombre, dia, hora);
		actividadesLibre.addElement(al);
		return "Se genero la actividad correctamente";
	}

	public String modificarActividad(int codActividad, String dia, String hora) {
		ActividadLibre al = buscarActividadLibre(codActividad);
		if (al != null) {
			Horario horario = new Horario(LocalDate.parse(dia), LocalTime.parse(hora));
			al.setHorarioActividad(horario);
		}
		return "Se modifico la actividad correctamente";
	}

	public String bajaActividad(int codActividad) {
		ActividadLibre al = buscarActividadLibre(codActividad);
		if (al != null) {
			al.setEstado(false);
		}
		return "Se elimino la actividad correctamente";
	}

	public ActividadLibre buscarActividadLibre(int codActividad) {
		for (int i = 0; i < actividadesLibre.size(); i++)
			if (actividadesLibre.elementAt(i).getCodActividad() == codActividad)
				return actividadesLibre.elementAt(i);
		return null;
	}

	// Fin region Actividad Libre

	// Inicio region Actividad Profesor
	public String altaActividadProfesor(String nombre, String dia, String hora, int codProfesor) {
		EmpleadosController ec = new EmpleadosController();
		EmpleadoProfesorClase epc = ec.buscarEmpleadoProfesorClase(codProfesor);
//		if (epc != null) {
			ActividadProfesor al = new ActividadProfesor(nombre, dia, hora, epc);
			actividadesProfesor.addElement(al);
//		}
		return "Se genero la actividad correctamente";
	}

	public String modificarActividadProfesor(int codActividad, String dia, String hora, EmpleadoProfesor profesor) {
		ActividadProfesor al = buscarActividadProfesor(codActividad);
		if (al != null) {
			Horario horario = new Horario(LocalDate.parse(dia), LocalTime.parse(hora));
			al.setHorarioActividad(horario);
			al.setProfesor(profesor);
		}
		return "Se modifico la actividad correctamente";
	}

	public String bajaActividadProfesor(int codActividad) {
		ActividadProfesor al = buscarActividadProfesor(codActividad);
		if (al != null) {
			al.setEstado(false);
		}
		return "Se elimino la actividad correctamente";
	}

	public ActividadProfesor buscarActividadProfesor(int codActividad) {
		for (int i = 0; i < actividadesProfesor.size(); i++)
			if (actividadesProfesor.elementAt(i).getCodActividad() == codActividad)
				return actividadesProfesor.elementAt(i);
		return null;
	}
	
	/** Devuelve todas las actividades **/
	public Vector<Actividad> getActividades() {
		Vector<Actividad> actividades_view = new Vector<Actividad>();
		ActividadesAdminPersistencia connpers = new ActividadesAdminPersistencia();
		actividades_view = connpers.selectAll();

		return actividades_view;
	}

	// Fin region Actividad Profesor
}
