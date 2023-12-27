package main.java.utils.impl.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import main.java.exception.UtilidadesException;
import main.java.exception.UtilidadesExceptionEnum;
import main.java.utils.logs.Logs;

public class EstablecerConexionDB {
	
	public EstablecerConexionDB() {
		
	}

	public Properties cargarPropiedades(String ruta) {
		Properties propiedades = new Properties();
		InputStream input;

		try {
			input = new FileInputStream(ruta);
			propiedades.load(input);
		} catch (IOException e) {
			throw new UtilidadesException("Error al leer el fichero:".concat(e.getMessage()),
					UtilidadesExceptionEnum.ERROR_LECTURA);
		}
		return propiedades;
	}

	public String[] prepararConexion(Properties propiedades) {
		String url = propiedades.getProperty("db.url");
		String nombre = propiedades.getProperty("db.nombre");
		String contraseña = propiedades.getProperty("db.contraseña");

		return new String[] { url, nombre, contraseña };
	}

	public void conexionApacheDerby() {

		Properties propiedades = cargarPropiedades("src/main/resources/database.properties");
		String[] datosConexion = prepararConexion(propiedades);

		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(datosConexion[0], datosConexion[1], datosConexion[2]);
			if (conexion != null) {
				Logs.log("Conexion realizada");
			}
		} catch (SQLException e) {
			throw new UtilidadesException("Fallo conexion".concat(e.getMessage()),
					UtilidadesExceptionEnum.ERROR_CONEXION);
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				throw new UtilidadesException("Fallo al cerrar la conexion".concat(e.getMessage()),
						UtilidadesExceptionEnum.ERROR_CIERRE_RECURSO);
			}
		}
	}
}
