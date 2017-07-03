package SistemaGimnasio;
public abstract class Empleado {

	private static int ultimaInstancia = 1067356;
	protected int legajo;
	protected String nombre;
	protected boolean estado;

	public Empleado(String nombre) {
		super();
		this.legajo = ultimaInstancia++;
		this.nombre = nombre;
		this.estado = true;
	}

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

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public abstract float calcularSueldo(int sueldo);

}
