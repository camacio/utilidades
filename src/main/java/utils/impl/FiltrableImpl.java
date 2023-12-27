package main.java.utils.impl;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import main.java.utils.DatosFicticiosPrivider;
import main.java.utils.Filtrable;

public class FiltrableImpl<T, I extends Number> implements Filtrable<T, I>, DatosFicticiosPrivider<T> {

	private Collection<T> coleccionGenerica;
	private T tipoElemento;
	private I numeroElementos;
	
	public FiltrableImpl() {
		generarDatosPorDefecto();
		
	}	
	
	@Override
	public Collection<T> devolverDatosFicticios() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void generarDatosFicticios(T tipoDato) {
		Class clase = tipoDato.getClass();
		var[] 
		
	}

	@Override
	public void añadirSegunCondicion(Predicate<T> condicion) {
		Objects.requireNonNull(condicion, "La condición no puede ser nula");
		
		Optional<T> elemento = coleccionGenerica.stream().filter(condicion).findFirst();
		coleccionGenerica.stream().collect(Collectors.toList()).add(elemento.get());
	}

	@Override
	public void añadirVariosSegunCondicion(Predicate<T> condicion) {
		Objects.requireNonNull(condicion, "La condición no puede ser nula");

		Collection<T> filtrados = coleccionGenerica.stream()
			.filter(condicion)
			.collect(Collectors.toList());
		coleccionGenerica.addAll(filtrados);
	}

	@Override
	public Optional<T> filtarSegunCondicion(Predicate<T> condicion) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Collection<T> filtrarVariosSegunCondicion(Predicate<T> condicion) {
		Objects.requireNonNull(condicion, "La condición no puede ser nula");

		return coleccionGenerica.stream().filter(condicion).collect(Collectors.toList());
	}

	@Override
	public void eliminarSegunCondicion(Predicate<T> condicion) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarVariosSegunCondicion(Predicate<T> condicion) {
		Objects.requireNonNull(condicion, "La condición no puede ser nula");

		coleccionGenerica.stream().filter(condicion).collect(Collectors.toList()).clear();
	}

	@Override
	public Optional<T> filtrar(Predicate<T> condicion) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<I> contarSegunCondicion(Predicate<T> condicion) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean algunoCumpleCondicion(Predicate<T> condicion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean todosCumplenCondicion(Predicate<T> condicion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<T> obtenerPrimeroCumpleCondicion(Predicate<T> condicion) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Collection<T> obtenerNoCumplenCondicion(Predicate<T> condicion) {
		// TODO Auto-generated method stub
		return null;
	}
}
