package main.java.utils.impl.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

import main.java.config.Bean;
import main.java.exception.GestorBibliotecaException;
import main.java.exception.GestorBibliotecaExceptionEnum;
import main.java.utils.collections.ConsultadorColecciones;

public class ConsultadorColeccionesImpl<T, I extends Number, U> implements ConsultadorColecciones<T, I, U>, Bean {

	private Collection<T> coleccionGenerica;
	private ValidadorColeccionImpl<I, T, U> validador;
	
	public ConsultadorColeccionesImpl(Collection<T> coleccion) {
		this.coleccionGenerica = coleccion;
	}
	
	public ConsultadorColeccionesImpl() {
		coleccionGenerica = new ArrayList<>();
	}
	
	@Override
	public Optional<T> obtenerPorIndice(I indice) {


		if (validador.esIndiceValido(indice) && validador.esTipoValido(indice, I)) {
			return Optional.of(coleccionGenerica.stream().skip(indice.intValue()).findFirst().get());
		} else {
			throw new GestorBibliotecaException("Indice proporcinado no valido",
					GestorBibliotecaExceptionEnum.INDICE_ERRONEO);
		}
	}

	@Override
	public Collection<T> obtenerVarios(I desde, I hasta) {
		int from = desde.intValue();
		int to = hasta.intValue();

		if (from >= 0 && to <= coleccionGenerica.size() && from <= to) {
			return coleccionGenerica.stream().toList().subList(from, to);
		} else {
			throw new GestorBibliotecaException("Indices proporcionados no validos",
					GestorBibliotecaExceptionEnum.INDICE_ERRONEO);
		}
	}
	
	@Override
	public Optional<T> obtenerPrimerElemento() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<T> obtenerUltimoElemento() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<I> obtenerNumeroTotalElementos() {
		if (validador.esColeccionValida(coleccionGenerica)) {
			return Optional.of((I) Integer.valueOf(coleccionGenerica.size()));
		} else {
			throw new GestorBibliotecaException("Indice proporcinado no valido",
					GestorBibliotecaExceptionEnum.COLECCION_VACIA);
		}
	}

	@Override
	public Collection<T> obtenerElementosDuplicados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<T> obtenerMinimo(Comparator<T> comparador) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<T> obtenerMaximo(Comparator<T> comparador) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Collection<T> obtenerPorLimite(I cantidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<T> obtenerElementosPorTipo(Class<?> clase) {
		
		return null;
	}

	@Override
	public Collection<T> obtenerElementosPorAtributo(Map<T, U> filtros) {
		// TODO Auto-generated method stub
		return null;
	}

}
