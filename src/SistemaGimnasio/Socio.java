package SistemaGimnasio;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Socio {

	private static int ultCodigo = 0;
	private int nroSocio;
	private String nombre;
	private String domicilio;
	private String telefono;
	private String mail;
	private AptoMedico aMedico;
	private boolean estado;

	public Socio(String nombre, String domicilio, String telefono, String mail, String nombreAbono,
			String fechaCertificado, String nombreProfesional, String observaciones) {
		super();
		this.nroSocio = ultCodigo++;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.aMedico = new AptoMedico(nombreProfesional, fechaCertificado, observaciones);
		this.estado = true;
	}

	public int getNroSocio() {
		return nroSocio;
	}

	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	/*public boolean validarVigencia() {
		LocalDateTime date = LocalDateTime.now();
		LocalDate ld = date.toLocalDate();
		LocalTime lt = date.toLocalTime();
		if (this.abono.getVigencia().getDia().isAfter(ld) && this.abono.getVigencia().getHorario().isAfter(lt))
			return true;
		else if (this.abono.getVigencia().getDia().equals(ld) && this.abono.getVigencia().getHorario().equals(lt))
			return true;
		else
			return false;
	}*/

	public boolean validarAptoMedico() {
		if (this.aMedico.getObservaciones().equals("Aprobado"))
			return true;
		else
			return false;
	}

	/*public boolean validarActividad() {
		// TODO cambiar formato de fecha
		Date d = new Date();
		for (int i = 0; i < inscripcion.actividades.size(); i++) {
			if (inscripcion.actividades.elementAt(i).getHorario().equals(d))
				return true;
		}
		return false;
	}*/

	/*public void agregarActividad(Actividad a) {
		// TODO Auto-generated method stub
		inscripcion.actividades.add(a);
	}*/

	/*public void generarInscripcionNormal() {
		this.inscripcion = new InscripcionNormal();
	}*/
}
