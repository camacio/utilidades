package main.java.publishsuscribe;

public class EventoError extends EventoAbstracto{

	private String mensajeError;
	private String contenido;
	
	public EventoError(String tipoEvento, Object datosEvento, String contenido, String mensajeError) {
		super(tipoEvento, datosEvento);
		this.mensajeError = mensajeError;
		this.contenido = contenido;
	}

	public EventoError() {
		super();
	}

	@Override
	public void notificarSuscriptor(Suscriptor suscriptor) {
		// TODO Auto-generated method stub
		
	}
	
	

}
