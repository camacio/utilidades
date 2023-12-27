package main.java;

import main.java.utils.logs.Logs;
import main.java.utils.string.formato.Color;
import main.java.utils.string.formato.FormatoTexto;
import main.java.utils.string.formato.FormatoTextoConsola;

public class MainClass {

	public static void main(String... args) {
		
		Color color = new Color();
		Logs.log(color.obtenerCodigoColor());
		color.aplicarColorAscii("rojo","Comodoro Jimi Joe");
		Logs.establecerColorError(new Color(), Logs.NivelErrorLogEnum.INFO.name());

		
//		Cadena cadena = new Cadena("prueba rara");
//		
//		cadena.concatenar("a ver si sale algo")
//		.concatenar("porqueee")
//		.saltoDeLinea()
//		.concatenar("seguimos para bingo")
//		.concatenar("probando proba")
//		.seleccionarLetras('a');
//	
//		
//		
//		Logs.log(cadena);

	}
	
//	public static void busquedaClasesPorPaquete() {
//		Map<List<String>, List<String>> sql = new HashMap<>();
//		List<String> nombreTablas = new ArrayList<>();
//		Annotation[] sentencias;
//
//		List<Class<?>[]> anotaciones = Stream.of(ClassLoader.getSystemClassLoader().getDefinedPackages())
//											.filter(p -> p.getName().contains("utils") && p.getName()
//											.endsWith("reflection"))
//											.map(p -> p.getClass().getClasses())
//											.collect(Collectors.toList());
//	}

}
