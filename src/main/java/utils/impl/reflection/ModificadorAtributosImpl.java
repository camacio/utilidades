package main.java.utils.impl.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import main.java.utils.reflection.ModificadorAtributos;

public class ModificadorAtributosImpl implements ModificadorAtributos {

	
	public List<String> obtenerNombreTodosAtributos(Class<?> clase) {
		Field[] campos = clase.getDeclaredFields();
		List<String> nombreCampos = new ArrayList<>();
		for(Field campo : campos) {
			nombreCampos.add(campo.getName());
		}
		
		return nombreCampos;
	}

	
	public Object obtenerAtributoPorNombre(String nombre) {
		String nombreAtributo = obtenerNombreTodosAtributos();
	}

	@Override
	public Object obtenerAtributoPorIndice(Object elemento, Number indice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection obtenerTodosAtributos(Object elemento) {
		List<Field> campos;
	}

	@Override
	public Object añadirAtributo(Map filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object añadirVariosAtributos(Map filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object modificarAtributo(Map filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eliminarAtributo(Object elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eliminarTodosAtributos(Object elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection añadirAtributoColeccion(Collection colecion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection modificarAtributoColeccion(Collection colecion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection eliminarAtributoColeccion(Collection colecion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeAtributo(Object elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object clonarAtributo(Object elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object obtenerNombreAtributo(Object elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object obtenerAtributoPorNombre(Object elemento, Object nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
