package SistemaGimnasio;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import persistencia.DeporteAdminPersistencia;

public class DeportesController {

	private Vector<Deporte> deportes;

	public DeportesController() {
		this.deportes = new Vector<Deporte>();
	}

	/** Genera un deporte y lo asocia al sistema */
	public void altaDeporte(String nombre, String descripcion) {
		Deporte d = new Deporte(nombre, descripcion);
		deportes.add(d);
	}

	/** Modifica un Deporte en el Sistema */
	public void modificarDeporte(int codDeporte, String nombre, String descripcion) {
		Deporte d = this.buscarDeporte(codDeporte);
		if (d != null) {
			d.setNombre(nombre);
			d.setDescripcion(descripcion);
			DeporteAdminPersistencia.getInstance().update(d);
			
			//Actualizo el deporte en el cache
			deportes.remove(d);
			deportes.add(d);
		}
	
	
	}

	public void eliminarDeporte(int codDeporte) {
		Deporte d = (Deporte)DeporteAdminPersistencia.getInstance().select(String.valueOf(codDeporte));
		if (d != null)
			d.setEstado(false);
		DeporteAdminPersistencia.getInstance().update(d);

	}

	/** Busca en el sistema el deporte. Si lo encuentra lo devuelve */
	public Deporte buscarDeporte(int codDeporte) {
		Deporte deporte = null;
		for (int i = 0; i < deportes.size(); i++) {
			if (deportes.elementAt(i).getCodDeporte() == codDeporte)
				deporte = deportes.elementAt(i);
			else{
				//Lo busco en la base y lo meto al cache
				Deporte d = (Deporte)DeporteAdminPersistencia.getInstance().select(String.valueOf(codDeporte));
				deportes.add(d);
			}
		}
		return deporte;
	}
	
	/** Devuelve todos los deportes **/
	public Vector<DeporteView> getDeportes() {
		Vector<DeporteView> deportes_view = new Vector<DeporteView>();
		DeporteView aux;
		ArrayList<Deporte> deportes = 	DeporteAdminPersistencia.getInstance().selectAll();
		for (Deporte deporte : deportes) {
			aux  = new DeporteView();
			aux.setNombre(deporte.getNombre());
			aux.setDescripcion(deporte.getDescripcion());
			deportes_view.add(aux);
		}
		return deportes_view;
	}
}
