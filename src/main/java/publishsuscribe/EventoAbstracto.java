package main.java.publishsuscribe;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class EventoAbstracto {
	private String tipoEvento;
	private LocalDateTime timestamp;
	private Object datosEvento;
	
	public EventoAbstracto(String tipoEvento, Object datosEvento) {
		super();
		this.tipoEvento = tipoEvento;
		this.timestamp = LocalDateTime.now();
		this.datosEvento = datosEvento;
	}
	
	public EventoAbstracto() {
		
	}
	
	public String obtenerTipoEvento() {
		return this.tipoEvento;
	}
	
	public LocalDateTime obtenertimestramp() {
		return this.timestamp;
	}
	
	public Object obtenerdatosEvento() {
		return this.datosEvento;
	}
	
	public abstract void notificarSuscriptor(Suscriptor suscriptor);
	
	
}
