package main.java.utils.impl.generics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import main.java.exception.UtilidadesException;
import main.java.exception.UtilidadesExceptionEnum;
import main.java.utils.generics.GeneradorDatosFicticios;
import main.java.utils.generics.RecopiladorDatosFicticios;

public class RecopiladorDatosFicticiosImpl<T, U> implements RecopiladorDatosFicticios<T, U> {

	private Map<Class<?>, Object> coleccionDatos;
	private GeneradorDatosFicticios generador;

	public RecopiladorDatosFicticiosImpl(GeneradorDatosFicticios generador) {
		this.generador = generador;

	}

	public RecopiladorDatosFicticiosImpl(Map<Class<?>, Object> coleccionDatos) {
		this.coleccionDatos = coleccionDatos;
	}

	@Override
	public Map<Class<?>, Object> obtenerDatosFicticios() {
		return (Map<Class<?>, Object>) coleccionDatos.values();
	}


	

	@Override
	public void agregarColeccionDatos(Map<Class<?>, Object> coleccion) {
		
		
	}



}
