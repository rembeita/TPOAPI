package SistemaGimnasio;

import persistencia.ActividadesAdminPersistencia;

public class ActividadProfesor extends Actividad {

	private EmpleadoProfesor profesor;

	public ActividadProfesor(String nombre, String dia, String hora, EmpleadoProfesor profesor) {
		super(nombre, dia, hora);
		System.out.println("Entreeeee");
		this.profesor = profesor;
		String nomprofesor = "nombreprofe";
		String estado = "true";
		ActividadesAdminPersistencia admpersist = new ActividadesAdminPersistencia();
		admpersist.insert(dia, nombre, hora, nomprofesor, estado);

		
	}

	public EmpleadoProfesor getProfesor() {
		return profesor;
	}

	public void setProfesor(EmpleadoProfesor profesor) {
		this.profesor = profesor;
	}

}
