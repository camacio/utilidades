package main.java.publishsuscribe;

public class SuscriptorImpl implements Suscriptor {

	private EventoAbstracto evento;
	
	public SuscriptorImpl(EventoAbstracto evento) {
		this.evento = evento;
	}
	
	@Override
	public void actualizar(Suscriptor suscriptor) {
		this.evento.notificarSuscriptor(suscriptor);
	}

}
