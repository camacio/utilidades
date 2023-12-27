package main.java.entity.elementos;

import java.io.Serializable;

import main.java.entity.AutorEntity;
import main.java.entity.EstadoElementoBibliotecaEnum;
import main.java.entity.GeneroElementoBibliotecaEnum;

public abstract class ElementoBibliotecaEntity implements Serializable, Comparable<ElementoBibliotecaEntity> {

	private static final long serialVersionUID = 1L;

	private static int contadorId;
	private int id;
	protected String titulo;
	protected AutorEntity autor;
	protected GeneroElementoBibliotecaEnum genero;
	protected EstadoElementoBibliotecaEnum estado;

	protected ElementoBibliotecaEntity(String titulo, AutorEntity autor, GeneroElementoBibliotecaEnum genero,
			EstadoElementoBibliotecaEnum estado) {
		super();
		this.id = ++contadorId;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.estado = estado;
	}

	protected ElementoBibliotecaEntity() {

	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public AutorEntity getAutor() {
		return autor;
	}

	public void setAutor(AutorEntity autor) {
		this.autor = autor;
	}

	public GeneroElementoBibliotecaEnum getGenero() {
		return genero;
	}

	public void setGenero(GeneroElementoBibliotecaEnum genero) {
		this.genero = genero;
	}

	public EstadoElementoBibliotecaEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoElementoBibliotecaEnum estado) {
		this.estado = estado;
	}

	public abstract boolean comprobarEstadoElemento(int id, EstadoElementoBibliotecaEnum estado);

}
