package main.java.utils.impl.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.java.exception.UtilidadesException;
import main.java.exception.UtilidadesExceptionEnum;
import main.java.utils.jdbc.DataDefinicionLenguajeEnum;
import main.java.utils.logs.Logs;

public class ManejadorArchivos {

	public String obtenerTextoFichero(String ruta) {
		String textoLeido = "";
		File fichero = new File(ruta);

		if (fichero.exists()) {
			
			try (BufferedReader reader = new BufferedReader(new FileReader(fichero.getPath()))) {
				textoLeido = reader.lines()
							.map(l -> l.replace(",", " ").trim())
							.collect(Collectors.joining(","));
				
			} catch (Exception e) {
				throw new UtilidadesException("Error en la lectura del fichero ".concat(e.getMessage()),
						UtilidadesExceptionEnum.ERROR_LECTURA);
			}
		}
		
		return textoLeido;
	}

	public StringBuilder obtenerTextoFicheroAleatorio() {
		StringBuilder texto = new StringBuilder();
		File directorio = new File("src/main/resources/coleccionesTexto/");
		
		File[] ficheros = directorio.listFiles(File::isFile);
		File ficheroRandom = ficheros[new Random().nextInt(ficheros.length)];
	
		 if (!directorio.exists() || !directorio.isDirectory() || directorio.listFiles().length == 0) {
		        throw new UtilidadesException("El archivo no existe o no se puede leer", 
		        		UtilidadesExceptionEnum.ERROR_LECTURA);
		    }

		try (BufferedReader reader = new BufferedReader(new FileReader(ficheroRandom))) {
			String nombre;
			while ((nombre = reader.readLine()) != null) {
				texto.append(nombre.replace(",", " ")).append(System.lineSeparator());
			}
		} catch (Exception e) {
			throw new UtilidadesException("Error al leer el fichero:".concat(e.getMessage()),
					UtilidadesExceptionEnum.ERROR_LECTURA);
		}

		return texto;
	}

	public List<File> mostrarFicheros(String ruta) {
		File file = new File(ruta);
		return Arrays.asList(file.listFiles());
	}

	

	public String maniputularTablaDesdeFichero(String ruta, String nombreTabla) {
		return nombreTabla;
		
		

	}
	
	public void escribirFichero(String ruta, String texto) {
		File fichero = new File(ruta);
		
		if(fichero.exists()) {
		
			try(BufferedWriter writer = new BufferedWriter(new FileWriter(fichero))) {
				
				while(!texto.isEmpty()) {
					writer.write(texto);
					writer.newLine();
				}
				
			} catch (IOException e) {
				throw new UtilidadesException("Error al crear el fichero:".concat(e.getMessage()),
						UtilidadesExceptionEnum.ERROR_ESCRITURA);
			}
		}
		
	}

	public void escribirFicheroTablas() {
		String nombreTablas = Stream.of(NombreTablasEnum.values())
				.map(n -> n.toString().trim())
				.filter(n -> !n.isBlank())
				.collect(Collectors.joining(","));
		
		
		File ficheroTablas = new File("src/main/resources/db/nombreTablas.txt");
		
		try {
			Logs.log(ficheroTablas.getAbsolutePath());
			if(!ficheroTablas.exists()) {
				ficheroTablas.createNewFile();
				escribirFichero(ficheroTablas.getAbsolutePath(), nombreTablas);
			}
		} catch (IOException e) {
			throw new UtilidadesException("Error al crear el fichero:".concat(e.getMessage()),
					UtilidadesExceptionEnum.ERROR_CREACION);
		}
	}
	
	public String seleccionarNombreTablaFichero(String nombre) {
		String tablas = obtenerTextoFichero("db/nombreTablas.txt");
		String nombreTabla = "";
		if(!tablas.isEmpty()) {
			tablas.lines().filter(t -> t.equalsIgnoreCase(nombre.toUpperCase().trim()))
							.collect(Collectors.joining());
		}
		Logs.log(nombreTabla);
		return nombreTabla;
	}
	
	public void crearTablaFichero() {
		String create = obtenerTextoFichero("createFile.txt");

		File file = new File("src/main/resources/db/tablaAutores.txt");
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new UtilidadesException("Error al crear el fichero:".concat(e.getMessage()),
						UtilidadesExceptionEnum.ERROR_CREACION);
			}
		}
		String sentencia = create.substring(0, create.indexOf(";") + 1);
		
		Logs.log(sentencia);
						
		escribirFichero(file.getName(), create);
		
		Logs.log(obtenerTextoFichero(file.getName()));
	}
	
	public void crearTablaFichero(String nombreTabla, String query) {
		if(nombreTabla.isBlank() && query.isBlank()) {
			throw new UtilidadesException("Error en los datos de consulta",
					UtilidadesExceptionEnum.ERROR_DATOS_CONSULTA);
		}
		
		String fichero = obtenerTextoFichero("src/main/resources/createFile.txt");
		
		File file = new File("src/main/resources/db/tabla".concat(nombreTabla).concat(".txt"));
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new UtilidadesException("Error al crear el fichero:".concat(e.getMessage()),
						UtilidadesExceptionEnum.ERROR_CREACION);
			}
		}
		
		String nombreTablaOk = NombreTablasEnum.verificarNombreTabla(nombreTabla) ? nombreTabla.toUpperCase() : "";
		String sentenciaOk = DataDefinicionLenguajeEnum.verificarSentencia(query) ? query.toUpperCase() : "";
		
		String sentencia = fichero.lines().filter(t -> t.startsWith(sentenciaOk))
				.filter(t -> t.contentEquals(nombreTablaOk)).takeWhile(t -> t.equals(";"))
				.collect(Collectors.joining());
		
		Logs.log(sentencia);
		
		escribirFichero(file.getName(), fichero);
		
	}
	
	
	

	
	
}  
