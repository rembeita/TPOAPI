package SistemaGimnasio;
public class ItemDeporte {

	private Deporte deporte;
	private Actividad actividad;

	public ItemDeporte(Deporte deporte, Actividad actividad) {
		super();
		this.deporte = deporte;
		this.actividad = actividad;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

}
