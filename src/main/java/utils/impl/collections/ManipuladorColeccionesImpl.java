package main.java.utils.impl.collections;

import java.util.ArrayList;
import java.util.Collection;

import main.java.config.Bean;
import main.java.utils.collections.ManipuladorColecciones;

public class ManipuladorColeccionesImpl<T, I extends Number, U> implements ManipuladorColecciones<T, I> , Bean{
	
	private Collection<T> coleccion;
	
	public ManipuladorColeccionesImpl(Collection<T> coleccion) {
		if(validador.esColeccionValida(coleccion)) {
			this.coleccion = coleccion;
		} else {
			coleccion = new ArrayList<>();
		}
	}
	
	public ManipuladorColeccionesImpl() {
		this.coleccion = new ArrayList<>();
	}
	
	@Override
	public void añadir(T elemento) {
		if(genericos.esTipoValido();
		
	}

	@Override
	public void añadirVarios(Collection<T> coleccionElementos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sustituir(I indice, T elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sustituirVarios(Collection<T> coleccionElementos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPorIndice(I indice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarVarios(I desde, I hasta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarTodos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarDuplicados() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String dameNombre() {
		return this.getClass().getName();
	}

	@Override
	public void setNombre(String nombreBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bean dameInstancia() {
		return this;
	}

}
