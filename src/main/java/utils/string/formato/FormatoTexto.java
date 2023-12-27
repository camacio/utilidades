package main.java.utils.string.formato;

import java.util.Map;

public interface FormatoTexto {

	void aplicarTamañoFuente(int tamaño);
	
	int obtenerTamañoFuente();
	
	void aumentarTamañoFuente(int tamaño);
	
	void disminuirTamañoFuente(int tamaño);
	
	String obtenerColorFuente();
	
	void aplicarColorFuente(String color);
	
	void aplicarFamiliaFuente(Familia familia);

	void aplicarFormatoFuente(EstiloFormato formato);
	
	String obtenerFormatoFuente();

}
