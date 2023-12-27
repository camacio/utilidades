package main.java.entity;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class AutorEntity implements Serializable, Comparator<AutorEntity> {

	private static final long serialVersionUID = 1L;
	
	private static int contadorId;
	private int id;
	private String nombre;
	private String apellido;
	private String nombreCompleto;
	private Date fechaNacimiento;
	private String paisNacimiento;

	public AutorEntity(String nombre, String apellido, String nombreCompleto, Date fechaNacimiento,
			String paisNacimiento) {
		super();
		this.id = ++contadorId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreCompleto = nombreCompleto;
		this.fechaNacimiento = fechaNacimiento;
		this.paisNacimiento = paisNacimiento;
	}
	
	public AutorEntity() {
		
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	public void setNombreCompleto() {
		this.getNombre().concat(" ").concat(this.getApellido());
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPaisNacimiento() {
		return paisNacimiento;
	}

	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}

	@Override
	public String toString() {
		return "AutorEntity [nombre=" + nombre + ", apellido=" + apellido + ", nombreCompleto=" + nombreCompleto
				+ ", fechaNacimiento=" + fechaNacimiento + ", paisNacimiento=" + paisNacimiento + "]";
	}

	@Override
	public int compare(AutorEntity o1, AutorEntity o2) {
		return o1.getNombreCompleto().compareToIgnoreCase(o2.getNombreCompleto());
	}
	
}
