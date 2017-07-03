package SistemaGimnasio;

public class ActividadView {
	
	protected int codActividad;
	protected String nombre;
	protected Horario horarioActividad;
	
	public int getCodActividad() {
		return codActividad;
	}
	public void setCodActividad(int codActividad) {
		this.codActividad = codActividad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Horario getHorarioActividad() {
		return horarioActividad;
	}
	public void setHorarioActividad(Horario horarioActividad) {
		this.horarioActividad = horarioActividad;
	}
	@Override
	public String toString() {
		return "[codActividad=" + codActividad + ", nombre=" + nombre + ", horarioActividad="
				+ horarioActividad + "]";
	}
	
	

}
