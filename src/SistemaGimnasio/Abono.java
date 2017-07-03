package SistemaGimnasio;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;


public class Abono {

	private int codAbono;
	private String nombre;
	private float precio;
	private Horario vigencia;

	public Abono(String nombre) {
		super();
		this.codAbono = generarCodAbono();
		this.nombre = nombre;
		this.precio = 0;
		this.vigencia = generarVigencia();
	}

	private Horario generarVigencia() {
		LocalDateTime date = LocalDateTime.now().plusDays(30);
		Horario vigencia = new Horario(date.toLocalDate(),date.toLocalTime());
		return vigencia;
	}

	/** Genera un numero random al azar entre 1 y 1000 */
	public int generarCodAbono() {
		Random rand = new Random();
		return rand.nextInt((1000 - 1) + 1) + 1;

	}

	public int getCodAbono() {
		return codAbono;
	}

	public void setCodAbono(int codAbono) {
		this.codAbono = codAbono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Horario getVigencia() {
		return vigencia;
	}

	public void setVigencia(Horario vigencia) {
		this.vigencia = vigencia;
	}
}
