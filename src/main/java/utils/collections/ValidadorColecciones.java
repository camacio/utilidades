package main.java.utils.collections;

import java.util.Collection;

public interface ValidadorColecciones<I extends Number, T, U> {

	boolean comprobarExistenciaPorIndice(I indice);
	
	boolean comprobarExistenciaPorTipo(T tipoElemento);

	boolean comprobarExistenciaDuplicados(T elemento);

	boolean esColeccionValida(Collection<T> coleccion);
	
	boolean esIndiceValido(I indice);
	
	boolean esRangoValido(I desde, I hasta);
	
}
