package SistemaGimnasio;
public class EmpleadoAdministrativo extends Empleado {

	private float sueldo;
	private float os;
	private float jub;

	public EmpleadoAdministrativo(String nombre, float sueldo) {
		super(nombre);
		this.os = sueldo * 3 / 100;
		this.jub = sueldo * 11 / 100;
		// TODO Auto-generated constructor stub
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
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
		// TODO Auto-generated method stub
		return 0;
	}

}
