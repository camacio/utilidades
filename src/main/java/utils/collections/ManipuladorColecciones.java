package main.java.utils.collections;

import java.util.Collection;

public interface ManipuladorColecciones<T, I extends Number> {

	void añadir(T elemento);

	void añadirVarios(Collection<T> coleccionElementos);

	void sustituir(I indice, T elemento);

	void sustituirVarios(Collection<T> coleccionElementos);

	void eliminarPorIndice(I indice);

	void eliminarVarios(I desde, I hasta);
	
	void eliminarTodos();
	
	void eliminarDuplicados();
}
