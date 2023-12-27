package main.java.exception;

public class UtilidadesException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	private UtilidadesExceptionEnum error;
	
	public UtilidadesException(String mensaje) {
		super("Error en la gestion de utilidades: ".concat(mensaje));
		this.mensaje = mensaje;
	}
	
	public UtilidadesException(String mensaje, UtilidadesExceptionEnum error) {
		super("Error en la gestion de utilidades: ".concat(mensaje).concat(" ").concat(error.toString()));
		this.mensaje = mensaje;
		this.error = error;
	}
	
	public String obtenerMensaje() {
		return this.mensaje;
	}
	
	public UtilidadesExceptionEnum obtenerError() {
		return this.error;
	}

	@Override
	public String toString() {
		return "UtilidadesException [mensaje=" + mensaje + ", error=" + error + "]";
	}
	
}
