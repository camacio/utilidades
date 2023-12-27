package main.java.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import main.java.exception.UtilidadesException;
import main.java.exception.UtilidadesExceptionEnum;

public class AlmacenClases {

	private static Map<TiposDatosEnum, Map<OrganizacionClasesEnum, Class<?>>> clases = new HashMap<>();
	
	static {
		File fichero = new File("src/main/resouces/clases.properties");
		
		try(BufferedReader input = new BufferedReader(new FileReader(fichero))) {
			Properties propiedades = new Properties();
			propiedades.load(input);
			
			Map<OrganizacionClasesEnum,Class<?>> entityMap = new HashMap<>();
			Map<OrganizacionClasesEnum,Class<?>> utilMap = new HashMap<>();
			Map<OrganizacionClasesEnum,Class<?>> coleccionesMap = new HashMap<>();
			
			for(OrganizacionClasesEnum clase : OrganizacionClasesEnum.values()) {
				
				entityMap.put(OrganizacionClasesEnum.ENTITY, 
						propiedades.getProperty();
				
				utilMap.put(OrganizacionClasesEnum.UTIL, Class.class);
				
				coleccionesMap.put(OrganizacionClasesEnum.COLLECTION, Class.class);
				
			}
			
			clases.put(TiposDatosEnum.CLASE, entityMap);
			clases.put(TiposDatosEnum.CLASE, utilMap);
			clases.put(TiposDatosEnum.CLASE, coleccionesMap);
		
		} catch (IOException e) {
			throw new UtilidadesException("Error al leer fichero propiedades clases: ",
					UtilidadesExceptionEnum.ERROR_LECTURA);
		}
	}
	
	public AlmacenClases() {
		
	}
	
	enum TiposDatosEnum {
		CLASE, CLASE_ABSTRACTA, INTERFAZ, ENUM, ANOTACION, PAQUETE;
	}
	
	enum OrganizacionClasesEnum	{
		ENTITY, REPOSITORY, MAP, SERVICE, CONTROLLER, UTIL, TEXT, FORMAT, COLOR, EXCEPTION, LOGS, COLLECTION, 
		IO, JDBC, SOCKETS, REFECTION, CONFIGURACION;
	}
}
