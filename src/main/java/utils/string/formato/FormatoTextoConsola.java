package main.java.utils.string.formato;

import java.util.Map;

public class FormatoTextoConsola implements FormatoTexto {
	
	private Color color;
	
	public FormatoTextoConsola(Color color) {
		this.color = color;
	}
	
	@Override
	public void aplicarTamañoFuente(int tamaño) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int obtenerTamañoFuente() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void aumentarTamañoFuente(int tamaño) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disminuirTamañoFuente(int tamaño) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String obtenerColorFuente() {
		return color.obtenerColorPorTipo("ascii", "azul");
	}

	@Override
	public void aplicarColorFuente(String color) {
		this.color.establecerColorAscii(color);
		
	}

	@Override
	public void aplicarFamiliaFuente(Familia familia) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void aplicarFormatoFuente(EstiloFormato formato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String obtenerFormatoFuente() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
