package ejemplo1;
import java.io.Serializable;

public class Persona implements Serializable{
 
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected  int edad;
	
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}	
}