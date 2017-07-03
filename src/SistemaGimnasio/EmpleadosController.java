package SistemaGimnasio;
import java.util.Random;
import java.util.Vector;

public class EmpleadosController {

	private Vector<EmpleadoProfesorClase> empleadosProfesorClase;
	private Vector<EmpleadoProfesorCompleto> empleadosProfesorCompleto;
	private Vector<EmpleadoAdministrativo> empleadosAdministrativos;

	public EmpleadosController() {
		this.empleadosProfesorClase = new Vector<EmpleadoProfesorClase>();
		this.empleadosProfesorCompleto = new Vector<EmpleadoProfesorCompleto>();
		this.empleadosAdministrativos = new Vector<EmpleadoAdministrativo>();
	}

	// Region Empleado Profesor Clase
	public String altaEmpleadoProfesorClase(String nombre, float valorHora, int horasTrabajadas) {
		EmpleadoProfesorClase emp = new EmpleadoProfesorClase(nombre, valorHora, horasTrabajadas);
		empleadosProfesorClase.addElement(emp);
		return "Se cargo el empleado exitosamente";
	}

	public String modificarEmpleadoProfesorClase(int nroLegajo, float sueldo, float valorHora, int horasTrabajadas) {
		EmpleadoProfesorClase emp = buscarEmpleadoProfesorClase(nroLegajo);
		if (emp != null) {
			emp.setSueldo(sueldo);
			emp.setHorasTrabajadas(horasTrabajadas);
			emp.setValorHora(valorHora);
		}
		return "Empleado modificado exitosamente";
	}

	public String bajaEmpleadoProfesorClase(int nroLegajo) {
		EmpleadoProfesorClase emp = buscarEmpleadoProfesorClase(nroLegajo);
		if (emp != null)
			emp.setEstado(false);
		return "Se elimino el empleado exitosamente";
	}

	public EmpleadoProfesorClase buscarEmpleadoProfesorClase(int nroLegajo) {
		for (int i = 0; i < empleadosProfesorClase.size(); i++) {
			if (empleadosProfesorClase.elementAt(i).getLegajo() == nroLegajo)
				return empleadosProfesorClase.elementAt(i);
		}
		return null;
	}

	public Vector<EmpleadoView> getEmpleadosProfesoresClase() {
		Vector<EmpleadoView> empView = new Vector<EmpleadoView>();
		EmpleadoView aux;
		for (int i = 0; i < empleadosProfesorClase.size(); i++) {
			aux = new EmpleadoView();
			aux.setNombre(empleadosProfesorClase.elementAt(i).getNombre());
			aux.setSueldo(empleadosProfesorClase.elementAt(i).getSueldo());
			aux.setLegajo(empleadosProfesorClase.elementAt(i).getLegajo());
			empView.add(aux);
		}
		return empView;
	}

	// Fin Region Empleado Profesor Clase

	// Region Empleado Profesor Completo
	public String altaEmpleadoCompleto(String nombre, float sueldo) {
		EmpleadoProfesorCompleto emp = new EmpleadoProfesorCompleto(nombre, sueldo);
		empleadosProfesorCompleto.addElement(emp);
		return "Se cargo el empleado correctamente";
	}

	public String modificarEmpleadoCompleto(int nroLegajo, float sueldo, float os, float jub) {
		EmpleadoProfesorCompleto emp = buscarEmpleadoProfesorCompleto(nroLegajo);
		if (emp != null) {
			emp.setSueldo(sueldo);
			emp.setOs(os);
			emp.setJub(jub);
		}
		return "Se modifico el empleado correctamente";
	}

	public String bajaEmpleadoProfesorCompleto(int nroLegajo) {
		EmpleadoProfesorCompleto emp = buscarEmpleadoProfesorCompleto(nroLegajo);
		if (emp != null)
			emp.setEstado(false);
		return "Se elimino el empleado exitosamente";
	}

	public EmpleadoProfesorCompleto buscarEmpleadoProfesorCompleto(int nroLegajo) {
		for (int i = 0; i < empleadosProfesorCompleto.size(); i++) {
			if (empleadosProfesorCompleto.elementAt(i).getLegajo() == nroLegajo)
				return empleadosProfesorCompleto.elementAt(i);
		}
		return null;
	}

	public Vector<EmpleadoView> getEmpleadosProfesoresCompleto() {
		Vector<EmpleadoView> empView = new Vector<EmpleadoView>();
		EmpleadoView aux;
		for (int i = 0; i < empleadosProfesorCompleto.size(); i++) {
			aux = new EmpleadoView();
			aux.setNombre(empleadosProfesorCompleto.elementAt(i).getNombre());
			aux.setSueldo(empleadosProfesorCompleto.elementAt(i).getSueldo());
			aux.setLegajo(empleadosProfesorCompleto.elementAt(i).getLegajo());
			empView.add(aux);
		}
		return empView;
	}
	// Fin Region Empleado Profesor Completo

	// Region Empleado Administrativo
	public String altaEmpleadoAdministrativo(String nombre, float sueldo) {
		EmpleadoAdministrativo emp = new EmpleadoAdministrativo(nombre, sueldo);
		empleadosAdministrativos.addElement(emp);
		return "Se cargo el empleado exitosamente";
	}

	public String modificarEmpleadoAdministrativo(int nroLegajo, float sueldo, float os, float jub) {
		EmpleadoProfesorCompleto emp = buscarEmpleadoProfesorCompleto(nroLegajo);
		if (emp != null) {
			emp.setSueldo(sueldo);
			emp.setOs(os);
			emp.setJub(jub);
		}
		return "Se modifico el empleado correctamente";
	}

	public String bajaEmpleadoAdministrativo(int nroLegajo) {
		EmpleadoAdministrativo emp = buscarEmpleadoAdministrativo(nroLegajo);
		if (emp != null)
			emp.setEstado(false);
		return "Se cargo el empleado exitosamente";
	}

	public EmpleadoAdministrativo buscarEmpleadoAdministrativo(int nroLegajo) {
		for (int i = 0; i < empleadosAdministrativos.size(); i++) {
			if (empleadosAdministrativos.elementAt(i).getLegajo() == nroLegajo)
				return empleadosAdministrativos.elementAt(i);
		}
		return null;
	}

	public Vector<EmpleadoView> getEmpleadosAdministrativos() {
		Vector<EmpleadoView> empView = new Vector<EmpleadoView>();
		EmpleadoView aux;
		for (int i = 0; i < empleadosAdministrativos.size(); i++) {
			aux = new EmpleadoView();
			aux.setNombre(empleadosAdministrativos.elementAt(i).getNombre());
			aux.setSueldo(empleadosAdministrativos.elementAt(i).getSueldo());
			aux.setLegajo(empleadosAdministrativos.elementAt(i).getLegajo());
			empView.add(aux);
		}
		return empView;
	}
	// Fin Region Empleado Administrativo

}
