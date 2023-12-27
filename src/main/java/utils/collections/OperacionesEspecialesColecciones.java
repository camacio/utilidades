package main.java.utils.collections;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface OperacionesEspecialesColecciones<T,U> {

	void ordenar(Comparator<T> comparador);

	Map<U, List<T>> agruparPor(Function<T, U> funcion);

	void invertir();

	void joining(Class<T> elemento, U atributo);

	Collection<T> copiarColeccion(Collection<T> destino, Collection<T> origen);
	
	Collection<T> duplicarColeccion(Collection<T> coleccion);
}
