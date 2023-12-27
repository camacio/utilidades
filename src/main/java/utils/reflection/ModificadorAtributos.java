package main.java.utils.reflection;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ModificadorAtributos<I extends Number, T, U> {
	
	List<String> obtenerNombreTodosAtributos(Class<?> clase);

	T obtenerNombreAtributo(T elemento);

	T obtenerAtributoPorNombre(T elemento, U nombre);

	T obtenerAtributoPorIndice(T elemento, I indice);

	Collection<U> obtenerTodosAtributos(T elemento);

	T añadirAtributo(Map<T, U> filtro);

	T añadirVariosAtributos(Map<T, Collection<U>> filtro);

	T modificarAtributo(Map<T, U> filtro);

	T eliminarAtributo(T elemento);

	T eliminarTodosAtributos(T elemento);

	Collection<T> añadirAtributoColeccion(Collection<T> colecion);

	Collection<T> modificarAtributoColeccion(Collection<T> colecion);

	Collection<T> eliminarAtributoColeccion(Collection<T> colecion);

	boolean existeAtributo(T elemento);

	T clonarAtributo(T elemento);
}
