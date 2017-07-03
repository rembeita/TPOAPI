package SistemaGimnasio;
import java.util.Random;
import java.util.Vector;

public class SociosController {

	private Vector<Socio> socios;

	public SociosController() {
		this.socios = new Vector<Socio>();
	}

	/** Genera un socio y lo asocia al sistema */
	public void altaSocio(String nombre, String domicilio, String telefono, String mail, String nombreAbono,
			String fechaCertificado, String nombreProfesional, String observaciones) {
		Socio s = new Socio(nombre, domicilio, telefono, mail, nombreAbono, fechaCertificado,
				nombreProfesional, observaciones);
		socios.add(s);
	}

	/** Modifica los atributos de un socio */
	public void modificarSocio(int nroSocio, String domicilio, String telefono, String mail) {
		Socio s = buscarSocio(nroSocio);
		if (s != null) {
			s.setDomicilio(domicilio);
			s.setMail(mail);
			s.setTelefono(telefono);
		}
	}

	/** Elimina el socio del sistema */
	public void eliminarSocio(int nroSocio) {
		Socio s = buscarSocio(nroSocio);
		if (s != null) {
			socios.remove(s);
		}
	}

	/** Busca un socio en el sistema. Si lo encuentra lo devuelve */
	public Socio buscarSocio(int nroSocio) {
		for (int i = 0; i < socios.size(); i++) {
			if (socios.elementAt(i).getNroSocio() == nroSocio)
				return socios.elementAt(i);
		}
		return null;
	}

	/** Genera un numero random al azar entre 1 y 1000 */
	/*
	 * private int GenerarNroSocio() { return socios.size() + 1; }
	 */

	/** Devuelve todos los socios */
	public Vector<Socio_View> getSocios() {
		Vector<Socio_View> socios_view = new Vector<Socio_View>();
		Socio_View aux;
		for (int i = 0; i < socios.size(); i++) {
			aux  = new Socio_View();
			aux.setNroSocio(socios.elementAt(i).getNroSocio());
			aux.setNombre(socios.elementAt(i).getNombre());
			aux.setTelefono(socios.elementAt(i).getTelefono());
			aux.setMail(socios.elementAt(i).getMail());
			aux.setDomicilio(socios.elementAt(i).getDomicilio());
			socios_view.add(aux);
		}
		return socios_view;
	}

}
