package main.java.entity.elementos;

import java.util.Date;

import main.java.entity.AutorEntity;
import main.java.entity.EstadoElementoBibliotecaEnum;
import main.java.entity.GeneroElementoBibliotecaEnum;

public class LibroEntity extends ElementoBibliotecaEntity {

	private static final long serialVersionUID = 1L;

	private static int contadorId;
	private int id;
	private String editorial;
	private Date fechaPublicacion;
	private int numeroPaginas;

	public LibroEntity(int id, String titulo, AutorEntity autor, GeneroElementoBibliotecaEnum genero, EstadoElementoBibliotecaEnum estado) {
		super();
	}

	public LibroEntity(String editorial, Date fechaPublicacion, int numeroPaginas, String titulo, AutorEntity autor, 
			GeneroElementoBibliotecaEnum genero, EstadoElementoBibliotecaEnum estado) {
		super(titulo, autor, genero, estado);
		this.id = ++contadorId;
		this.editorial = editorial;
		this.fechaPublicacion = fechaPublicacion;
		this.numeroPaginas = numeroPaginas;
	}

	public LibroEntity() {

	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "LibroEntity [editorial=" + editorial + ", fechaPublicacion=" + fechaPublicacion + ", numeroPaginas="
				+ numeroPaginas + "]";
	}

	@Override
	public int compareTo(ElementoBibliotecaEntity o) {
		
		return 1;
	}

	@Override
	public boolean comprobarEstadoElemento(int id, EstadoElementoBibliotecaEnum estado) {
		// TODO Auto-generated method stub
		return false;
	}

}
