package main.java.utils.string.formato;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import main.java.exception.UtilidadesException;
import main.java.exception.UtilidadesExceptionEnum;
import main.java.utils.logs.Logs;
import main.java.utils.string.formato.EstiloFormato.TipoEstiloFormatoEnum;

public class Color {
	private static Map<TipoFormatoColorEnum, Map<ColoresEnum, String>> formatos = new HashMap<>();
	private String tipoFormato;
	private String codigoColor;
	private String color;

	static {
		Properties propiedades = new Properties();
		File file = new File("src/main/resources/color.properties");
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			propiedades.load(reader);

			Map<ColoresEnum, String> colorAscii = new HashMap<>();
			Map<ColoresEnum, String> colorHexa = new HashMap<>();
			Map<ColoresEnum, String> colorRgb = new HashMap<>();

			for (ColoresEnum color : ColoresEnum.values()) {
				colorAscii.put(color, propiedades.getProperty(color.obtenerColor().toUpperCase() + ".ASCII"));

				colorHexa.put(color, propiedades.getProperty(color.obtenerColor().toUpperCase() + ".HEXADECIMAL"));

				colorRgb.put(color, propiedades.getProperty(color.obtenerColor().toUpperCase() + ".RGB"));
			}

			formatos.put(TipoFormatoColorEnum.ASCII, colorAscii);
			formatos.put(TipoFormatoColorEnum.HEXADECIMAL, colorHexa);
			formatos.put(TipoFormatoColorEnum.RGB, colorRgb);
			formatos.put(TipoFormatoColorEnum.DEFAULT, Map.of(ColoresEnum.BLANCO, "#FFFFFF"));
			formatos.put(TipoFormatoColorEnum.VACIO, Collections.emptyMap());

			Logs.log(formatos);
		} catch (IOException e) {
			throw new UtilidadesException("Error al leer fichero color:", UtilidadesExceptionEnum.ERROR_LECTURA);
		}
	}

	public Color(String tipoFormato, String codigoColor, String color) {
		this.tipoFormato = (tipoFormato.isBlank()) ? TipoFormatoColorEnum.DEFAULT.obtenerTipoFormato() : tipoFormato;
		this.color = (color.isBlank()) ? ColoresEnum.BLANCO.obtenerColor() : color;
		establecerCodigoColor(this.color);

	}

	public Color() {
		establecerPropiedadesPorDefecto();
	}

	public void establecerTipoFormato(String tipoFormato) {
		Objects.requireNonNull(tipoFormato);

		if (!tipoFormato.equalsIgnoreCase(TipoFormatoColorEnum.comprobarTipo(tipoFormato).obtenerTipoFormato())) {
			throw new UtilidadesException("Nombre formato mal escrito", UtilidadesExceptionEnum.ERROR_DATOS_CONSULTA);
		}

		this.tipoFormato = tipoFormato;
	}

	public void establecerColor(String color) {
		Objects.requireNonNull(color);

		this.color = (color.isBlank()) ? ColoresEnum.BLANCO.obtenerColor() : color;
		establecerCodigoColor(this.color);

	}

	public void establecerCodigoColor(String codigoColor) {
		Objects.requireNonNull(codigoColor);

		this.codigoColor = formatos.get(TipoFormatoColorEnum.comprobarTipo(this.tipoFormato))
				.get(ColoresEnum.comprobarColor(codigoColor));
	}

	public String obtenerTipoFormato() {
		return this.tipoFormato;
	}

	public String obtenerColor() {
		return this.color;
	}

	public String obtenerCodigoColor() {
		return formatos.get(TipoFormatoColorEnum.comprobarTipo(this.tipoFormato))
				.get(ColoresEnum.comprobarColor(this.color));
	}

	public String obtenerCodigoColorPorTipo(String tipoFormato, String color) {
		return obtenerMapaColoresPorTipo(tipoFormato).get(ColoresEnum.comprobarColor(color));

	}

	private Map<ColoresEnum, String> obtenerMapaColoresPorTipo(String tipoFormato) {
		return formatos.get(TipoFormatoColorEnum.comprobarTipo(tipoFormato));

	}

	public void establecerColorPorTipo(String tipoFormato, String color) {
		Objects.requireNonNull(tipoFormato);
		Objects.requireNonNull(color);

		establecerTipoFormato(TipoFormatoColorEnum.comprobarTipo(tipoFormato).obtenerTipoFormato());
		establecerColor(ColoresEnum.comprobarColor(color).obtenerColor());
	}

	public void establecerColorHexadecimal(String color) {
		Objects.requireNonNull(color);

		establecerTipoFormato(TipoFormatoColorEnum.HEXADECIMAL.obtenerTipoFormato());
		establecerColor(ColoresEnum.comprobarColor(color).obtenerColor());
	}

	public void establecerColorAscii(String color) {
		Objects.requireNonNull(color);

		establecerTipoFormato(TipoFormatoColorEnum.ASCII.obtenerTipoFormato());
		establecerColor(ColoresEnum.comprobarColor(color).obtenerColor());

	}

	public String aplicarColorAscii(String colorParaAplicar, String objetivo) {
		establecerColorAscii(colorParaAplicar);

		String comienzoColor = obtenerCodigoColorPorTipo(this.tipoFormato, this.color);
		System.out.print(comienzoColor);

		System.out.print(objetivo);

		establecerColorAscii("reset");

		String finalColor = obtenerCodigoColorPorTipo(this.tipoFormato, this.color);
		System.out.print(finalColor);

		return objetivo;
	}

	public void establecerColorRgb(String color) {
		Objects.requireNonNull(color);

		establecerTipoFormato(TipoFormatoColorEnum.RGB.obtenerTipoFormato());
		establecerColor(ColoresEnum.comprobarColor(color).obtenerColor());
	}

	public void establecerPropiedadesPorDefecto() {
		this.tipoFormato = TipoFormatoColorEnum.DEFAULT.obtenerTipoFormato();
		this.color = ColoresEnum.BLANCO.obtenerColor();
		establecerCodigoColor(this.color);
	}

	public void añadirColor(String nombreColor, String codigoColor) {
		Objects.requireNonNull(nombreColor, codigoColor);

		formatos.get(TipoFormatoColorEnum.comprobarTipo(obtenerTipoFormato()))
				.put(ColoresEnum.comprobarColor(nombreColor), codigoColor);
	}

	public void añadirVariosColoresPorTipo(Map<ColoresEnum, String> colores) {

	}

	public void eliminarColor(String nombreColor) {
		Objects.requireNonNull(nombreColor);

		formatos.get(TipoFormatoColorEnum.comprobarTipo(obtenerTipoFormato()))
				.remove(ColoresEnum.comprobarColor(nombreColor));
	}

	public void borrarTipoFormatoColores() {
		formatos.clear();
	}

	public enum TipoFormatoColorEnum {
		ASCII("ascii"), HEXADECIMAL("hexadecimal"), RGB("rgb"), DEFAULT("default"), VACIO("vacio");

		private String tipoFormato;

		private TipoFormatoColorEnum(String tipoFormato) {
			this.tipoFormato = tipoFormato;
		}

		public String obtenerTipoFormato() {
			return this.tipoFormato;
		}

		public static TipoFormatoColorEnum comprobarTipo(String tipo) {
			Objects.requireNonNull(tipo);

			return TipoFormatoColorEnum.valueOf(tipo.toUpperCase());
		}
	}

	public enum ColoresEnum {
		AMARILLO("Amarillo"), ROJO("Rojo"), AZUL("Azul"), VERDE("Verde"), VIOLETA("Violeta"), ROSA("Rosa"),
		NARANJA("Naranja"), MARRON("Marron"), GRIS("Gris"), BLANCO("Blanco"), NEGRO("Negro"), RESET("Reset");

		private final String color;

		private ColoresEnum(String color) {
			this.color = color;
		}

		public String obtenerColor() {
			Objects.requireNonNull(color);

			return this.color;
		}

		public static ColoresEnum comprobarColor(String color) {
			Objects.requireNonNull(color);

			return ColoresEnum.valueOf(color.toUpperCase());
		}
	}

}
