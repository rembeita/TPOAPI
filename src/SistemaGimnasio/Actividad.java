package SistemaGimnasio;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Vector;

public abstract class Actividad {

	private static int ultimoCodActividad = 0;
	protected int codActividad;
	protected String nombre;
	protected Horario horarioActividad;
	protected String estado;
	protected String dia;
	protected String hora;
	
	public Actividad(String nombre, String dia, String hora) {
		super();
		this.codActividad = ultimoCodActividad++;
		this.nombre = nombre;
		this.dia = dia;
		this.hora = hora;
		//this.horarioActividad = generarHorario(dia, hora);
		this.estado = "true";
	}

	private Horario generarHorario(String dia, String hora) {
		// DateTimeFormatter formatter =
		// DateTimeFormatter.ofPattern("YYYY-MM-dd");
		Horario horario = new Horario(LocalDate.parse(dia), LocalTime.parse(hora));
		return horario;
	}

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

	public void setHorarioActividad(Horario horario) {
		this.horarioActividad = horario;
	}


}
