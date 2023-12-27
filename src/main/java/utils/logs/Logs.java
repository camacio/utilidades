package main.java.utils.logs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import main.java.utils.string.Cadena;
import main.java.utils.string.formato.Color;
import main.java.utils.string.formato.Color.ColoresEnum;

public class Logs {
	
	private Logs() {
		
	}

	public static void log(Object elemento) {
		LocalDateTime now = LocalDateTime.now();
		String detalles = obtenerDetallesLog(3);
		
		
		
		String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		Cadena mensaje = new Cadena(NivelErrorLogEnum.INFO.obtenerErrorLog())
				.concatenar("El valor del Objecto es:")
				.concatenar(elemento.toString()).negrita()	
				.saltoDeLinea().concatenar(detalles)
				.saltoDeLinea().concatenar(timestamp)
				.concatenar(NivelErrorLogEnum.INFO.obtenerErrorLog());
		
		println(mensaje);
		
	}
	
	private static void println(Cadena mensaje) {
		System.out.println(mensaje);
	}
	
	public static String obtenerDetallesLog(int nivel) {
		StackTraceElement[] pila = Thread.currentThread().getStackTrace();
		
		if(nivel < pila.length) {
			String clase = pila[nivel].getClassName();
			String metodo = pila[nivel].getMethodName();
			int linea = pila[nivel].getLineNumber(); 
			return String.format("Detalles log: Clase: %s, Método: %s, Línea: %d", clase, metodo, linea);
			
		} else {
			return "No se encontraron suficientes detalles en la pila";
		}
		
	}
	
	public static void establecerColorError(Color color, String objetivo) {
		
		for(NivelErrorLogEnum error : NivelErrorLogEnum.values()) {
			Logs.log(color.aplicarColorAscii(error.obtenerColorError(), objetivo));
			
		}
		Logs.log(NivelErrorLogEnum.INFO.obtenerColorError());
	}
	
	public static String obtenerColorError() {
		Logs.log(NivelErrorLogEnum.INFO.obtenerColorError());
		return "";
	}
	
	public enum NivelErrorLogEnum {
		
		ERROR("Error", "Rojo"), INFO("Info", "Verde"), WARN("Warning", "Amarillo"), DEBUG("Debug", "Naranja");

		private final String errorLog;
		private final String colorLog;
		
		private NivelErrorLogEnum(String errorLog, String colorLog) {
			this.errorLog = errorLog;
			this.colorLog = colorLog;
		}

		public String obtenerErrorLog() {
			return this.errorLog;
		}
		
		public NivelErrorLogEnum comprobarErrorLog(String error) {
			return NivelErrorLogEnum.valueOf(error.toUpperCase());
		}
		
		
		public String obtenerColorError() {
			return this.colorLog;
		}
		
		public NivelErrorLogEnum comprobarColorLog(String color) {
			return NivelErrorLogEnum.valueOf(color.toUpperCase());
		}
	}
}
