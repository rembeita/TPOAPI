package SistemaGimnasio;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AptoMedico {

	private Horario fechaCertificado;
	private String nombre;
	private String observaciones;

	public AptoMedico(String nombre, String fechaCertificado ,String observaciones) {
		super();
		this.fechaCertificado = generarHorario(fechaCertificado);
		this.nombre = nombre;
		this.observaciones = observaciones;
	}

	private Horario generarHorario(String dia) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate aux = LocalDate.parse(dia,formatter);
		Horario horario2 = new Horario(aux,null);
		return horario2;
	}
	
	public Horario getFechaCertificado() {
		return fechaCertificado;
	}

	public void setFechaCertificado(Horario fechaCertificado) {
		this.fechaCertificado = fechaCertificado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
