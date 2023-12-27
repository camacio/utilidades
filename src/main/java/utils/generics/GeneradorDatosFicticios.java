package main.java.utils.generics;

import java.io.File;
import java.util.Collection;
import java.util.Map;

public interface GeneradorDatosFicticios<I extends Number, T, U> {

	Object generarInstanciaPorNombre(String nombreClase);

	void generarDatosFicticios(T tipoElemento, I numeroElementos);

	void generarDatosFicticiosConAtributos(Class<T> tipo, I numeroElementos, Collection<T> atributos);

	void generarDatosPorDefecto();

	Map<Class<?>, T> generarDatosSegunTipo(Class<T> tipo, I numero);

	Map<Class<?>, Object> generarDatosVariosTipos();

	public Collection<Object> generarDatosAleatoriosTxt();

	Map<Class<?>, Object> generarDatosDesdeTxt(File file);

	Object generarInstanciaPorNombresTxt(Collection<String> nombres);

	Object generarInstanciaPorNombreTxt(File file);

	Collection<Object> generarVariasInstanciasTxt(String txt);

	public Collection<Object> generarDatosAleatoriosDB();

	Map<Class<?>, Object> generarDatosDesdeDB(File file);

	Object generarInstanciaPorNombresDB(Collection<String> nombres);

	Object generarInstanciaPorNombreDB(File file);

	Collection<Object> generarVariasInstanciasDB(String txt);

}
