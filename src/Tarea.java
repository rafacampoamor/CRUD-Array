import java.time.LocalDate;
import java.util.Arrays;

public class Tarea {
	public Tarea(String[] titulo, String[] descripcion, LocalDate[] fechaLimite) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaLimite = fechaLimite;
	}
	public Tarea() {
		super();
	}
	private int posiciones = 20;
	private String[] titulo = new String[posiciones];
	private String[] descripcion = new String[posiciones];
	private LocalDate[] fechaLimite = new LocalDate[posiciones];
	
	public String[] getTitulo() {
		return titulo;
	}
	public void setTitulo(int posicion, String titulo) {
		//para hacer funcionar este setter, he tirado de Google
		this.titulo[posicion] = titulo;
	}
	public String[] getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(int posicion, String descripcion) {
		//para hacer funcionar este setter, he tirado de Google
		this.descripcion[posicion] = descripcion;
	}
	public LocalDate[] getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(int posicion, LocalDate fechaLimite) {
		//para hacer funcionar este setter, he tirado de Google
		this.fechaLimite[posicion] = fechaLimite;
	}
	
	public int getPosiciones() {
		return posiciones;
	}
	public void setPosiciones(int posiciones) {
		this.posiciones = posiciones;
	}
	@Override
	public String toString() {
		return "tarea [titulo=" + Arrays.toString(titulo) + ", descripcion=" + Arrays.toString(descripcion)
				+ ", fechaLimite=" + Arrays.toString(fechaLimite) + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
