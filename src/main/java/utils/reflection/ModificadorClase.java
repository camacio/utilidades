package main.java.utils.reflection;

import java.io.File;
import java.util.List;

public interface ModificadorClase<T> {
	
	public String obtenerNombreClase(T elemento);
	
	public String obtenerNombreSimpleClase(T elemento);
	
}
