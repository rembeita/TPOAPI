package SistemaGimnasio;
public class EmpleadoProfesorClase extends EmpleadoProfesor {

	private float valorHora;
	private int horasTrabajadas;

	public EmpleadoProfesorClase(String nombre, float valorHora, int horasTrabajadas) {
		super(nombre);
		this.valorHora = valorHora;
		this.horasTrabajadas = horasTrabajadas;
		this.sueldo = valorHora * horasTrabajadas;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public float getValorHora() {
		return valorHora;
	}

	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}

	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public float calcularSueldo(int sueldo) {
		return this.sueldo;
	}
}
