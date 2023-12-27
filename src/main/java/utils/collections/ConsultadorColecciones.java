package main.java.utils.collections;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public interface ConsultadorColecciones<T, I extends Number, U> {

	Optional<T> obtenerPorIndice(I indice);

	Collection<T> obtenerVarios(I desde, I hasta);

	Optional<T> obtenerPrimerElemento();

	Optional<T> obtenerUltimoElemento();

	Optional<I> obtenerNumeroTotalElementos();

	Collection<T> obtenerElementosDuplicados();

	Optional<T> obtenerMinimo(Comparator<T> comparador);

	Optional<T> obtenerMaximo(Comparator<T> comparador);

	Collection<T> obtenerPorLimite(I cantidad);
	
	Collection<T> obtenerElementosPorTipo(Map<T, U> filtros);
	
	Collection<T> obtenerElementosPorAtributo(Map<T, U> filtros);
	
}
