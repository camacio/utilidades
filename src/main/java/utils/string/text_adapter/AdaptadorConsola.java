package main.java.utils.string.text_adapter;

import main.java.utils.string.formato.FormatoTexto;

public class AdaptadorConsola {

	private FormatoTexto formato;
	
	public AdaptadorConsola(FormatoTexto formato) {
		this.formato = formato;

	}
	
	public void aplicarColorFuente(String codigoColor) {
		formato.aplicarColorFuente(codigoColor);
		
	}
	
	public String obtenerColorFuente()	{
		return formato.obtenerColorFuente();
	}
	
	
	
}
