package main.java.config.bean;

import java.util.List;

public interface BeanFactory {

	DefinicionBean obtenerDefinicionBean(String nombreBean);
	
	DefinicionBean obtenerDefinicionBean(Class<?> claseBean);
	
	Object crearBean(String nombreBean);
	
	Object crearBean(DefinicionBean definicion);
	
	Object crearBean(DefinicionBean definicion, Object... args);
	
	void registrarDefinicionBean(String nombreBean, DefinicionBean definicion);
	
	void registrarDefinicionBean(Class<?> claseBean, DefinicionBean definicion);
	
	void registrarDefinicionBeanDesdeConfiguracion(String rutaArchivo);
	
	void eliminarRegistroDefinicionBean(String nombreBean);
	
	void eleminarRegistroDefinicionBean(Class<?> claseBean);
	
	void definirScopeBean(String scope);
	
	String obtenerScopeBean();
	
	void eliminarScopeBean();
	
	void establecerDependencias(String nombreBean, List<String> nombreDependencias);
	
	void inicializarBean(String nombreBean);
	
	void destruirBean(String nombreBean);
	
	void lanzarExcepcionBeanNoEncontrado(String nombreBean);
	
	void lanzarExcepcionCreacionBeanFallida(String nombreBean);
	
	
}
