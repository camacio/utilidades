package main.java.utils.reflection;

import java.util.Collection;
import java.util.Map;

public interface ModificadorMetodos<I extends Number, T, U> {

	Collection<T> obtenerNombreMetodos(T elemento);

	T obtenerMetodoPorNombre(T elemento, U nombre);

	T obtenerMetodoPorIndice(T elemento, I indice);

	Collection<U> obtenerTodosMetodo(T elemento);

	T añadirMetodo(Map<T, U> filtro);

	T añadirVariosMetodos(Map<T, Collection<U>> filtro);

	T modificarMetodo(Map<T, U> filtro);

	T eliminarMetodo(T elemento, U nombre);

	T eliminarTodosMetodos(T elemento);
	
	T invocarMetodo(T elemento, U nombre);

	Collection<T> añadirMetodoColeccion(Collection<T> colecion);

	Collection<T> modificarMetodoColeccion(Collection<T> colecion);

	Collection<T> eliminarMetodoColeccion(Collection<T> colecion);

	boolean existeMetodo(T elemento, U nombre);

	T clonarMetodo(T elemento, U nombre);
	
	Collection<U> obtenerTodosParametros(T elemento);
	
	T obtenerTipoParametros(T elemento);
}
