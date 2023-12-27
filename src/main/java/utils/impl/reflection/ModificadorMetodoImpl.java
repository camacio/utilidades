package main.java.utils.impl.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.java.exception.GestorBibliotecaException;
import main.java.exception.GestorBibliotecaExceptionEnum;
import main.java.utils.bean.ContenedorClases;
import main.java.utils.reflection.ModificadorMetodos;

public class ModificadorMetodoImpl<I extends Number, T, U> implements ModificadorMetodos<I, T, U> {
	

	public ModificadorMetodoImpl(T bean) {
		
	}
	
	public ModificadorMetodoImpl() {
		
	}

	@Override
	public Collection<T> obtenerNombreMetodos(T elemento) {
		Objects.requireNonNull(elemento);

		return Stream.of(elemento.getClass()
				.getDeclaredMethods())
				.map(m -> (T) m.getName())
				.collect(Collectors.toList());
	}

	public T obtenerNombrePrimerMetodo(T elemento) {
		Objects.requireNonNull(elemento);
		
		return Stream.of(elemento.getClass().getDeclaredMethods())
				.map(m -> (T) m.getName())
				.findFirst().get();
	}

	@Override
	public T obtenerMetodoPorNombre(T elemento, U nombre) {
		Objects.requireNonNull(elemento);
		Objects.requireNonNull(nombre);
		
		return Stream.of(elemento.getClass().getDeclaredMethods())
				.filter(e -> e.getName().equalsIgnoreCase(nombre.toString()))
				.map(m -> (T) m)
				.findFirst().get();
	}

	@Override
	public T obtenerMetodoPorIndice(T elemento, I indice) {
		Objects.requireNonNull(elemento);
		
		if(validador.esIndiceValido(indice)) {
			return Stream.of(elemento.getClass().getDeclaredMethods())
					.map(m -> (T) m)
					.collect(Collectors.toList())
					.get(indice.intValue());
		} else {
			throw new GestorBibliotecaException("Indice null o fuera de rango",
					GestorBibliotecaExceptionEnum.INDICE_ERRONEO); 
		}

	}

	@Override
	public Collection<U> obtenerTodosMetodo(T elemento) {
		Objects.requireNonNull(elemento);

		return Stream.of(elemento.getClass()
				.getDeclaredMethods())
				.map(m -> (U) m)
				.collect(Collectors.toList());
	}
	
	@Override
	public Collection<U> obtenerTodosParametros(T elemento) {
		Objects.requireNonNull(elemento);
		
		return Stream.of(elemento.getClass().getDeclaredMethods())
				.map(p -> (U) p.getParameters())
				.collect(Collectors.toList());
	}
	
	@Override
	public T obtenerTipoParametros(T elemento) {
		Objects.requireNonNull(elemento);
		
		return Stream.of(elemento.getClass().getDeclaredMethods())
				.map(t -> (T) t.getTypeParameters())
				.findFirst()
				.get();
	}

	@Override
	public T añadirMetodo(Map<T, U> filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T añadirVariosMetodos(Map<T, Collection<U>> filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T modificarMetodo(Map<T, U> filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T eliminarMetodo(T elemento, U nombre) {
		Arrays.asList(elemento.getClass().getDeclaredMethods())
				.removeIf(m -> m.getName().equalsIgnoreCase(nombre.toString()));
		return elemento;
	}

	@Override
	public T eliminarTodosMetodos(T elemento) {
		Stream.of(elemento.getClass().getDeclaredMethods())
				.map(m -> {
					try {
						m.setAccessible(true);
						m.invoke(null, null);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return elemento;
				});
		return elemento;
	}

	@Override
	public T invocarMetodo(T elemento, U nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<T> añadirMetodoColeccion(Collection<T> colecion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<T> modificarMetodoColeccion(Collection<T> colecion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<T> eliminarMetodoColeccion(Collection<T> colecion) {
		return colecion;
		
	}

	@Override
	public boolean existeMetodo(T elemento, U nombre) {
		Objects.requireNonNull(elemento);
		Objects.requireNonNull(nombre);
		
		return true;
	}

	@Override
	public T clonarMetodo(T elemento, U nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
