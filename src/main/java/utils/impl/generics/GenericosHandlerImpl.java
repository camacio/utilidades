package main.java.utils.impl.generics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.java.exception.GestorBibliotecaException;
import main.java.exception.GestorBibliotecaExceptionEnum;
import main.java.utils.generics.GenericosHandler;

public class GenericosHandlerImpl<I extends Number, T, U> implements GenericosHandler<T, U> {

	private T objeto;
	private Collection<T> coleccionGenericos;
	private ValidadorColeccionImpl<I, T, U> validador = new ValidadorColeccionImpl<>();

	public GenericosHandlerImpl(T objeto) {
		this.objeto = objeto;
	}

	public GenericosHandlerImpl(Collection<T> coleccion) {
		this.coleccionGenericos = coleccion;
	}

	public GenericosHandlerImpl() {
		Object objeto = this.objeto;
	}

	@Override
	public String obtenerTipoElemento(T elemento) {
		Objects.requireNonNull(elemento);
		
		return elemento.getClass().getTypeName();
	}

	@Override
	public T obtenerElementoGenerico(T elemento, Collection<T> coleccion) {
		if (esTipoValido(elemento, elemento.getClass()) && validador.esColeccionValida(coleccion)) {
			return coleccion.stream().filter(e -> e.getClass()
					.isAssignableFrom(elemento.getClass())).findFirst()
					.orElse(objeto);
		} else {
			throw new GestorBibliotecaException("Error al obtener tipo generico",
					GestorBibliotecaExceptionEnum.ERROR_CONVERSION);
		}
	}

	@Override
	public String obtenerTipoColeccion(T elemento, Collection<T> coleccion) {
		if (esTipoValido(elemento, elemento.getClass()) && validador.esColeccionValida(coleccion)) {
			return coleccion.stream().map(e -> e.getClass().getTypeName()).findAny().get();

		} else {
			throw new GestorBibliotecaException("Error al obtener el tipo de la coleccion",
					GestorBibliotecaExceptionEnum.ERROR_CONVERSION);
		}
	}

	
	public T crearElementoTipoAleatorio() {
		
	}

	@Override
	public U transformarATipoDestino(T tipoOrigen, Class<U> tipoDestino) {
		Objects.requireNonNull(tipoOrigen);
		Objects.requireNonNull(tipoOrigen);

		return tipoDestino.cast(tipoOrigen.getClass());
	}

	@Override
	public U transformar(T dato, Function<T, U> funcion) {
		return null;

	}

	@Override
	public Collection<U> transformarColeccion(Collection<T> coleccion, Function<Collection<T>, Collection<U>> funcion) {
		if (validador.esColeccionValida(coleccion)) {
			return funcion.apply(coleccion);
		} else {
			throw new GestorBibliotecaException("Coleccion nula o vacia",
					GestorBibliotecaExceptionEnum.COLECCION_VACIA);
		}
	}

	public Collection<U> transformarColeccion(Collection<T> coleccionOrigen, U tipoDestino) {
		if (validador.esColeccionValida(coleccionOrigen)) {
			return coleccionOrigen.stream().filter(e -> !e.getClass().isAssignableFrom(tipoDestino.getClass()))
					.map(t -> (U) t).collect(Collectors.toList());
		} else {
			throw new GestorBibliotecaException("Coleccion nula o vacia",
					GestorBibliotecaExceptionEnum.COLECCION_VACIA);
		}
	}

	@Override
	public boolean esTipoValido(T elemento, Class<? extends Object> clase) {
		Objects.requireNonNull(elemento);
		Objects.requireNonNull(clase);
		
		if(elemento.getClass().isAssignableFrom(clase)) {
			return elemento.getClass() == clase.getClass();
		} else {
			throw new GestorBibliotecaException("El tipo del elemento no se corresponde al de la clase proporcionada",
					GestorBibliotecaExceptionEnum.ERROR_CONVERSION);
		}
	}

	@Override
	public T clonar(T generico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean sonMismoTipo(T elemento, U otroElemento) {
		return elemento.getClass().equals(otroElemento.getClass());
	}

	@Override
	public boolean esTipoPrimitivo(T objeto, Class<U> clase) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T conversionTipoPrimitivo(T elemento, Class<U> otroElemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean sonNull(T... objetos) {
		for (T objeto : objetos) {
			if (objeto == null) {
				return true;
			}
		}
		return false;
	}

}
