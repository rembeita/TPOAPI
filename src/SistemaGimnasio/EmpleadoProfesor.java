package SistemaGimnasio;
import java.util.Random;

public abstract class EmpleadoProfesor extends Empleado {

	protected float sueldo;

	// Constructor para Empleado Profesor Completo
	public EmpleadoProfesor(String nombre, float sueldo) {
		super(nombre);

	}

	// Constructor para Empleado Profesor Clase
	public EmpleadoProfesor(String nombre) {
		super(nombre);
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public abstract float calcularSueldo(int sueldo);
}
