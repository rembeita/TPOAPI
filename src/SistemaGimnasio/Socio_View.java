package SistemaGimnasio;

public class Socio_View {
	private int nroSocio;
	private String nombre;
	private String domicilio;
	private String mail;
	private String telefono;
	
	
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getNroSocio() {
		return nroSocio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "[nroSocio=" + nroSocio + ", nombre=" + nombre + "]";
	}
	
	
}
