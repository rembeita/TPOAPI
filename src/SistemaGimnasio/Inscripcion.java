package SistemaGimnasio;
import java.time.LocalDate;
import java.util.Vector;

public abstract class Inscripcion {

	protected Abono abono;
	protected Horario vigencia;
	protected Vector<ItemDeporte> itemDeportes;

	public Inscripcion() {
		super();
		this.abono = new Abono("");
		this.vigencia = new Horario(LocalDate.now().plusDays(30), null);
		this.itemDeportes = new Vector<ItemDeporte>();
	}

	public void agregarActividad(Actividad a, Deporte d) {
		ItemDeporte nuevaActividad = new ItemDeporte(d, a);
		itemDeportes.addElement(nuevaActividad);
	}

}
