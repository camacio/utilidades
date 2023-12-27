package main.java.entity;

import java.io.Serializable;
import java.util.Date;

public class MultaEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static int contadorId;
	private int idMulta;
	private int idUsuario;
	private Double cantidadDinero;
	private Date fechaVencimiento;
	private String motivo;
	
	public MultaEntity(int idUsuario, Double cantidadDinero, Date fechaVencimiento, String motivo) {
		super();
		this.idMulta = ++contadorId;
		this.idUsuario = idUsuario;
		this.cantidadDinero = cantidadDinero;
		this.fechaVencimiento = fechaVencimiento;
		this.motivo = motivo;
	}
	
	public MultaEntity() {
		
	}

	public int getIdMulta() {
		return idMulta;
	}

	public void setIdMulta(int idMulta) {
		this.idMulta = idMulta;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Double getCantidadDinero() {
		return cantidadDinero;
	}

	public void setCantidadDinero(Double cantidadDinero) {
		this.cantidadDinero = cantidadDinero;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "MultaEntity [idMulta=" + idMulta + ", idUsuario=" + idUsuario + ", cantidadDinero=" + cantidadDinero
				+ ", fechaVencimiento=" + fechaVencimiento + ", motivo=" + motivo + "]";
	}

}
