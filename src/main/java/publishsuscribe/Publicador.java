package main.java.publishsuscribe;

import java.util.ArrayList;
import java.util.List;

public class Publicador {
	private List<Suscriptor> suscriptores = new ArrayList<>();
	
	public void añadirSuscriptor(Suscriptor suscriptor) {
		this.suscriptores.add(suscriptor);
	}
	
	public void eleminarSuscriptor(Suscriptor suscriptor) {
		this.suscriptores.remove(suscriptor);
	}
	
	public void publicarEventoMensaje() {
		EventoMensaje mensaje = new EventoMensaje();
		publicar(mensaje);
	}
	
	public void publicEventoError() {
		EventoError error = new EventoError();
		publicar(error);
	}
	
	public void publicar(EventoAbstracto evento) {
		for(Suscriptor suscriptor : suscriptores) {
			evento.notificarSuscriptor(suscriptor);
		}
	}
}
