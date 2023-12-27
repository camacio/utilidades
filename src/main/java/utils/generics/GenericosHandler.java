package main.java.utils.generics;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

public interface GenericosHandler<T,U> {
	
	String obtenerTipoElemento(T elemento);
	
	T obtenerElementoGenerico(T elemento, Collection<T> coleccion);
	
	String obtenerTipoColeccion(T elemento, Collection<T> coleccion);
	
	U transformarATipoDestino(T tipoOrigen, Class<U> tipoDestino);
	
	U transformar(T elemento, Function<T,U> funcion);
	
	Collection<U> transformarColeccion(Collection<T> coleccion, Function<Collection<T>, Collection<U>> funcion);
	
	Collection<U> transformarColeccion(Collection<T> coleccionOrigen, U tipoDestino);
	
	T clonar(T elemento);
	
	boolean sonMismoTipo(T elemento, U objetoComparar);
	
	boolean esTipoValido(T elemento, Class<? extends Object> clase);
	
	boolean esTipoPrimitivo(T elemento, Class<U> clase);
	
	boolean esNull(T... elementos);
	
	T conversionTipoPrimitivo(T elemento, Class<U> otroElemento);

}
