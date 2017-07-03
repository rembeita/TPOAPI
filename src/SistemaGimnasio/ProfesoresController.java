package SistemaGimnasio;
import java.util.Random;
import java.util.Vector;

public class ProfesoresController {

	private Vector<EmpleadoProfesor> profesores;

	public ProfesoresController() {
		this.profesores = new Vector<EmpleadoProfesor>();
	}

	public void altaProfesorClase() {
		// TODO
	}

	public EmpleadoProfesor buscarProfesor(int codProfesor) {
		for (int i = 0; i < profesores.size(); i++) {
			if (profesores.elementAt(i).getLegajo() == codProfesor)
				return profesores.elementAt(i);
		}
		return null;
	}

	/** Genera un numero random al azar entre 1 y 1000 */
	private int generarCodProfesor() {
		return profesores.size() + 1;
	}
}
