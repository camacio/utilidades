package main.java.utils.impl.generics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.java.exception.UtilidadesException;
import main.java.exception.UtilidadesExceptionEnum;
import main.java.utils.generics.ClaseNoInstanciable;
import main.java.utils.generics.GeneradorDatosFicticios;
import main.java.utils.impl.io.ManejadorArchivos;
import main.java.utils.impl.reflection.ModificadorClaseImpl;

public class GeneradorDatosFicticiosImpl<I extends Number, T, U> implements GeneradorDatosFicticios<I, T, U> {
	
	private static final String ERROR_DE_INSTANCIACION = "Error de instanciacion: ";
	private Map<Class<?>, Object> mapaDatos;
	
	public GeneradorDatosFicticiosImpl() {
		this.mapaDatos = new HashMap<>();
	}
	
	@Override
	public void generarDatosFicticiosConAtributos(Class<T> tipo, I numeroElementos, Collection<T> atributos) {
		
		
	}

	@Override
	public void generarDatosPorDefecto() {
		
	}
	
	@Override
	public void generarDatosFicticios(T tipoElemento, I numeroElementos) {
		Objects.requireNonNull(tipoElemento);
		Objects.requireNonNull(tipoElemento);
		
		
	}
	
	public Object generarInstanciaPorNombre(T elemento) {
		String nombre = new ModificadorClaseImpl<T>().obtenerNombreSimpleClase(elemento);
		try {
			return Class.forName(nombre).getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			throw new UtilidadesException(ERROR_DE_INSTANCIACION.concat(e.getMessage()),
					UtilidadesExceptionEnum.ERROR_INSTANCIACION);
		} 
	}
	
	@Override
	public Object generarInstanciaPorNombresTxt(Collection<String> nombres) {
		List<String> coleccion = nombres.stream().collect(Collectors.toList());
		Class<?> clase;
		
		for(String nombre : coleccion) {
			try {
				clase = Class.forName(nombre);
				return clase.getDeclaredConstructor().newInstance();

				
			} catch (Exception e) {
				throw new UtilidadesException(ERROR_DE_INSTANCIACION.concat(e.getMessage()),
						UtilidadesExceptionEnum.ERROR_INSTANCIACION);
			}
		}
		return ClaseNoInstanciable.dameInstancia();
	}
	
	public Collection<Object> generarVariasInstanciasTxt(String txt) {
		Collection<Object> instancias = new ArrayList<>();
		File fichero = new File("src/main/recursos/".concat(txt));
		
		if(fichero.exists()) {
			try(BufferedReader reader = new BufferedReader(new FileReader(fichero))) {
				String linea;
				while((linea = reader.readLine()) != null) {
					Class<?> clase = Class.forName(linea.trim());
					Object objeto = clase.getDeclaredConstructor().newInstance();
					instancias.add(objeto);
				}
			} catch (Exception e) {
				throw new UtilidadesException(ERROR_DE_INSTANCIACION.concat(e.getMessage()),
						UtilidadesExceptionEnum.ERROR_INSTANCIACION);
			} 
		}
		return instancias;
	}
	
	@Override //Corregir porque puede seleccionar fichero que no contiene clases y daria error de instanciacion
	public Collection<Object> generarDatosAleatoriosTxt() {
		List<String> texto = new ArrayList<>(new ManejadorArchivos().obtenerTextoFicheroAleatorio());
		Collection<Object> instancias = new ArrayList<>();
		
		try {
			Class<?> clase = Class.forName(texto.get(new Random().nextInt(texto.size())));
			Object objeto = clase.getDeclaredConstructor().newInstance();
			instancias.add(objeto);
	
		} catch (Exception e) {
			throw new UtilidadesException(ERROR_DE_INSTANCIACION.concat(e.getMessage()),
					UtilidadesExceptionEnum.ERROR_INSTANCIACION);
		}
		return instancias;
	}

	@Override
	public Map<Class<?>, Object> generarDatosVariosTipos() {
		try(BufferedReader reader = new BufferedReader(new FileReader("src/main/recursos/ColeccionNombres.txt"))) {
			String nombre;
			while((nombre = reader.readLine().trim()) != null) {
				Class<?> clase = Class.forName(nombre);
				Object instancia = clase.getConstructor().newInstance();
				mapaDatos.put(clase, instancia);
			}
		} catch (Exception e) {
			throw new UtilidadesException("Error al leer el fichero:".concat(e.getMessage()), 
					UtilidadesExceptionEnum.ERROR_LECTURA);
		} 
		return mapaDatos;
	}

	@Override
	public Map<Class<?>, T> generarDatosSegunTipo(Class<T> tipo, I numero) {
		return Stream.<T>generate(() -> {
			try {
				return tipo.getDeclaredConstructor()
						.newInstance();
			} catch (Exception e) {
				throw new UtilidadesException("Error al leer el fichero", 
						UtilidadesExceptionEnum.ERROR_LECTURA);
			}
		}).limit(numero.longValue())
				.collect(Collectors.toMap(e -> tipo, e -> e));
	}



}
