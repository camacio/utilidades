package main.java.publishsuscribe;

public class EventoMensaje extends EventoAbstracto {

	private String remitente;
	private String destinatario;
	private String contenido;
	
	public EventoMensaje(String tipoEvento, Object datosEvento, String remitente, String destinatario,
			String contenido) {
		super("Mensaje", contenido);
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.contenido = contenido;
	}

	public EventoMensaje() {
		super();
	}


	@Override
	public void notificarSuscriptor(Suscriptor suscriptor) {
		// TODO Auto-generated method stub
		
	}
	
	
}
