package main.java.utils.generics;

import java.util.Collection;
import java.util.Map;

public interface RecopiladorDatosFicticios<T, U> {
	
	void agregarColeccionDatos(Map<Class<?>, Object> contenedor);
	
	Map<Class<?>, Object> obtenerDatosFicticios();
	
}
