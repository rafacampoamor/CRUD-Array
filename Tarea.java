import java.util.Arrays;
import java.util.Date;

public class Tarea {
	public Tarea(String[] titulo, String[] descripcion, Date[] fechaLimite) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaLimite = fechaLimite;
	}
	public Tarea() {
		super();
	}
	private int posiciones = 20;
	private int posicion;
	private String[] titulo = new String[posiciones];
	private String[] descripcion = new String[posiciones];
	private Date[] fechaLimite = new Date[posiciones];
	
	public String[] getTitulo() {
		return titulo;
	}
	public void setTitulo(int posicion, String titulo) {
		this.titulo[posicion] = titulo;
	}
	public String[] getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(int posicion, String descripcion) {
		this.descripcion[posicion] = descripcion;
	}
	public Date[] getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(int posicion, Date fechaLimite) {
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
