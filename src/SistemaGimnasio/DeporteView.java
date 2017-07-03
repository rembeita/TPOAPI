package SistemaGimnasio;

public class DeporteView {
	
	private int codDeporte;
	private String nombre;
	private String descripcion;
	
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

	public String toString() {
		return "[codDeporte=" + codDeporte + ", nombre=" + nombre + "]";
	}
	
	
	

}
