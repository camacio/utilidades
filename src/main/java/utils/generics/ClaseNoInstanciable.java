package main.java.utils.generics;

public class ClaseNoInstanciable extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private ClaseNoInstanciable() {
	}
	
	public static ClaseNoInstanciable dameInstancia() {
		return new ClaseNoInstanciable();
	}
	
	public String dameMensaje() {
		return "No se pudo instanciar la clase";
	}
	
}
