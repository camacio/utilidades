package main.java.utils;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface Filtrable<T, I extends Number> {
	
	void añadirSegunCondicion(Predicate<T> condicion);
	
	void añadirVariosSegunCondicion(Predicate<T> condicion);

	Optional<T> filtarSegunCondicion(Predicate<T> condicion);
	
	Collection<T> filtrarVariosSegunCondicion(Predicate<T> condicion);
	
	void eliminarSegunCondicion(Predicate<T> condicion);
	
	void eliminarVariosSegunCondicion(Predicate<T> condicion);
	
	Optional<T> filtrar(Predicate<T> condicion);
	
	Optional<I> contarSegunCondicion(Predicate<T> condicion);
	
	boolean algunoCumpleCondicion(Predicate<T> condicion);
	
	boolean todosCumplenCondicion(Predicate<T> condicion);
	
	Optional<T> obtenerPrimeroCumpleCondicion(Predicate<T> condicion);
	
	Collection<T> obtenerNoCumplenCondicion(Predicate<T> condicion);
	
}
