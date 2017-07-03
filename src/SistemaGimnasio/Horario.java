package SistemaGimnasio;
import java.time.LocalDate;
import java.time.LocalTime;

public class Horario {

	private LocalDate dia;
	private LocalTime horario;

	public Horario(LocalDate dia, LocalTime horario) {
		super();
		this.dia = dia;
		if(horario != null)
			this.horario = horario;
		else
			this.horario = LocalTime.parse("00:00:00");
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

}
