package main.java.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioEntity implements Serializable, Comparable<UsuarioEntity> {

	private static final long serialVersionUID = 1L;
	
	private static int contadorId = 0;
	private int id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String paisNacimiento;
	private EstadoUsuarioEnum estado;
	private List<MultaEntity> cantidadMultas;
	
	

	public UsuarioEntity(int id, String nombre, String apellido, Date fechaNacimiento, String paisNacimiento,
			EstadoUsuarioEnum estado, List<MultaEntity> cantidadMultas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.paisNacimiento = paisNacimiento;
		this.estado = estado;
		this.cantidadMultas = cantidadMultas;
	}

	public UsuarioEntity() {
		cantidadMultas = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public EstadoUsuarioEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoUsuarioEnum estado) {
		this.estado = estado;
	}

	public List<MultaEntity> getCantidadMultas() {
		return cantidadMultas;
	}

	public String getPaisNacimiento() {
		return paisNacimiento;
	}

	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}

	@Override
	public int compareTo(UsuarioEntity o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEntity other = (UsuarioEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioEntity [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", paisNacimiento=" + paisNacimiento + ", estado=" + estado + ", cantidadMultas="
				+ cantidadMultas + "]";
	}
	
}
