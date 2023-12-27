package main.java.utils.impl.collections;

import java.util.ArrayList;
import java.util.Collection;

import main.java.config.Bean;
import main.java.utils.collections.ValidadorColecciones;

public class ValidadorColeccionImpl<I extends Number, T, U> implements ValidadorColecciones<I, T, U>, Bean {

	private Collection<T> coleccionGenerica;
	
	public ValidadorColeccionImpl(Collection<T> coleccion) {
		this.coleccionGenerica = coleccion;
	}
	
	public ValidadorColeccionImpl() {
		this.coleccionGenerica = new ArrayList<>();
	}
	
	@Override
	public boolean comprobarExistenciaPorIndice(I indice) {
		int id = indice.intValue();

		return id >= 0 && id < coleccionGenerica.size();
	}

	@Override
	public boolean comprobarExistenciaPorTipo(T tipoElemento) {
		return true;
	}

	@Override
	public boolean comprobarExistenciaDuplicados(T elemento) {
		return elemento != null && coleccionGenerica.contains(elemento);
	}

	@Override
	public boolean esColeccionValida(Collection<T> coleccion) {
		return coleccion != null && coleccion.isEmpty();
	}

	@Override
	public boolean esIndiceValido(I indice) {
		int id = indice.intValue();

		return id >= 0 && id <= coleccionGenerica.size();
	}
	
	@Override
	public boolean esRangoValido(I desde, I hasta) {
		int from = desde.intValue();
		int to = hasta.intValue();

		return from >= 0 && to <= coleccionGenerica.size() && from <= to;
		
	}
	
	public ValidadorColeccionImpl<I, T, U> dameInstancia() {
		return this;
	}

	@Override
	public String dameNombre() {
		return this.getClass().getName();
	}

	@Override
	public void setNombre(String nombre) {
		
		
	}

}
