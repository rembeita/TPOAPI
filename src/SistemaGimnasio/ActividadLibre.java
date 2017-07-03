package SistemaGimnasio;

import persistencia.ActividadesAdminPersistencia;

public class ActividadLibre extends Actividad {

	public ActividadLibre(String nombre, String dia, String hora) {
		super(nombre, dia, hora);
		String libre = "libre";
		String estado = "true";
		ActividadesAdminPersistencia admpersist = new ActividadesAdminPersistencia();
		admpersist.insert(dia, nombre, hora, libre, estado);

	}

}
