package ejer2;

import java.io.Serializable;

public class Pais implements Serializable {
	private String nombre;
	private int habitantes;
	private String continente;
	public Pais(String nombre, int habitantes, String continente) {
		super();
		this.nombre = nombre;
		this.habitantes = habitantes;
		this.continente = continente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
}