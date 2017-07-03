package SistemaGimnasio;

public class EmpleadoView {
	private String nombre;
	private float sueldo;
	private int legajo;
	
	
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}	
	
	public String toString() {
		return "[Empleado=" + nombre + "]";
	}

}
