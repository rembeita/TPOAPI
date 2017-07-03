package SistemaGimnasio;
public class EmpleadoProfesorCompleto extends EmpleadoProfesor {

	private float os;
	private float jub;

	public EmpleadoProfesorCompleto(String nombre, float sueldo) {
		super(nombre, sueldo);
		this.sueldo = sueldo;
		this.os = sueldo * 3 / 100;
		this.jub = sueldo * 11 / 100;
	}

	public float getOs() {
		return os;
	}

	public void setOs(float os) {
		this.os = os;
	}

	public float getJub() {
		return jub;
	}

	public void setJub(float jub) {
		this.jub = jub;
	}

	@Override
	public float calcularSueldo(int sueldo) {
		return this.sueldo;
	}

}
