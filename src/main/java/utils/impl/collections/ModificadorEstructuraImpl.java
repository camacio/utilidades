package main.java.utils.impl.collections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import main.java.exception.GestorBibliotecaException;
import main.java.exception.GestorBibliotecaExceptionEnum;
import main.java.utils.reflection.ModificadorClase;

public class ModificadorEstructuraImpl<I extends Number, T ,U> implements ModificadorClase<I, T ,U>{

	private GenericosHandlerImpl<T, U> manejador = new GenericosHandlerImpl<>();
	private Map<T,U> filtro;
	private Collection<T> coleccionElementos;
	
	public ModificadorEstructuraImpl(Map<T,U> filtro) {
		this.filtro = filtro;
	}
	
	public ModificadorEstructuraImpl(T elemento, U nombre) {
		filtro = new HashMap<>();
		filtro.put(elemento, nombre);
	}
	
	public ModificadorEstructuraImpl(Collection<T> coleccion) {
		this.coleccionElementos = coleccion;
		
	}
	
	public ModificadorEstructuraImpl() {
		
	}
	
	@Override
	public U obtenerNombreAtributo(T elemento) {
		
		
	}
	
	@Override
	public T instanciarElemento(T elemento) {

		try {
			return (T) elemento.getClass().getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new GestorBibliotecaException("Error combertir tipo de dato: ".concat(e.getMessage()),
					GestorBibliotecaExceptionEnum.ERROR_CONVERSION);
		}
	}
	

	public Collection<T> buscarPorAtributos(Map<T, Object> filtros) {
		
		if (filtros != null && !filtros.isEmpty() && coleccionGenerica != null && coleccionGenerica.isEmpty()) {
			return  coleccionGenerica.stream().filter(elemento -> filtros.entrySet().stream().allMatch(entry -> {
				T nombre = entry.getKey();
				Object valor = entry.getValue();
				Object valorElemento = obtenerValorAtributo(elemento, nombre);
				return valorElemento != null && valorElemento.equals(valor);
			})).collect(Collectors.toList());
		} else {
			throw new GestorBibliotecaException("Coleccion vacia", GestorBibliotecaExceptionEnum.COLECCION_VACIA);
		}
		Collection<T> valores = filtros.;
	}
	
	public T obtenerAtributoPorIndice(T elemento, I indice) {
		if(Integer)
		return (U) Arrays.asList(elemento.getClass()
				.getDeclaredFields())
				.get(indice.intValue())
				.getName();
	}
	
	@Override
	public T obtenerAtributoPorNombre(T elemento, U nombre) {
		try {
			return (U) elemento.getClass().getDeclaredField(nombre.toString()).getName();
		} catch (NoSuchFieldException | SecurityException e) {
			throw new GestorBibliotecaException("Error al obtener el atributo",
					GestorBibliotecaExceptionEnum.ERROR_CONVERSION);
		}
	}

	@Override
	public Collection<U> obtenerTodosAtributos(T elemento) {
		return Arrays.asList(elemento.getClass().getDeclaredFields())
				.stream()
				.map(Field::getName)
				.map(c -> (U) elemento)
				.collect(Collectors.toList());
	}

	@Override
	public void añdirAtributo(Map<T, U> filtro) {
		
		
	}

	@Override
	public void añdirVariosAtributos(Map<T, Collection<Object>> filtro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarAtributo(Map<T, Object> filtro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarAtributo(T elemento) {
		elemento.getClass().getDeclaredField(elemento.toString()).setAccessible(true);
		
	}

	@Override
	public void eliminarTodosAtributos(T elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void añadirAtributoColeccion(Collection<T> colecion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarAtributoColeccion(I indice, Collection<T> colecion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarAtributoColeccion(I indice, Collection<T> colecion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existeAtributo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object obtenerMetodo(Map<T, Object> filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Object> obtenerTodosMetodos(Map<T, Object> filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void añadirMetodo(Map<T, Object> filtro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void añadirVariosMetodos(Map<T, Collection<Object>> filtro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarMetodo(Map<T, Object> filtro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarMetodo(T elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarTodosMetodos(T elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void añadirMetodoColeccion(Collection<T> colecion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarMetodoColeccion(I indice, Collection<T> colecion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarMetodoColeccion(I indice, Collection<T> colecion) {
		// TODO Auto-generated method stub
		
	}


	


	@Override
	public void añdirVariosAtributos(Map<T, Collection<U>> filtro) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void modificarAtributo(Map<T, U> filtro) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean existeAtributo(T elemento) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public U clonarAtributo(T elemento) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public U obtenerNombreMetodo(Map<T, U> filtro) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public U obtenerMetodo(Map<T, U> filtro) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Collection<U> obtenerTodosMetodos(Map<T, U> filtro) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void añadirMetodo(Map<T, U> filtro) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void añadirVariosMetodos(Map<T, Collection<U>> filtro) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void modificarMetodo(Map<T, U> filtro) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void existeMetodo(T elemento) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public U clonarMetodo(T elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public U obtenerNombreClase(T elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public U obtenerConstructor(T elemento) {
		// TODO Auto-generated method stub
		return null;
	}

}
