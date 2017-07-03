package SistemaGimnasio;
public class Deporte {

	private static int ultimoCodDeporte = 0;
	private int codDeporte;
	private String nombre;
	private String descripcion;
	private boolean estado;

	public Deporte(String nombre, String descripcion, int codDeporte, boolean estado){
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codDeporte = codDeporte;
		this.estado = estado;
	}
	
	public Deporte(String nombre, String descripcion) {
		super();
		this.codDeporte = ultimoCodDeporte++;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = true;
	}

	public int getCodDeporte() {
		return codDeporte;
	}

	public void setCodDeporte(int codDeporte) {
		this.codDeporte = codDeporte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
