package main.java.pruebas;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Color {
	private static Map<TipoFormatoColorEnum, Map<ColoresEnum, String>> formatos;
	private String tipoFormato;
	private String codigoColor;

	static {

		formatos = new HashMap<>();
		Map<ColoresEnum, String> asciiMap = new HashMap<>();
		asciiMap.put(ColoresEnum.AMARILLO, "\u001B[33m");
		asciiMap.put(ColoresEnum.ROJO, "\u001B[31m");
		asciiMap.put(ColoresEnum.AZUL, "\u001B[34m");
		asciiMap.put(ColoresEnum.VERDE, "\u001B[32m");
		asciiMap.put(ColoresEnum.VIOLETA, "\u001B[35m");
		asciiMap.put(ColoresEnum.ROSA, "\u001B[38;5;205m");
		asciiMap.put(ColoresEnum.NARANJA, "\u001B[38;5;208m");
		asciiMap.put(ColoresEnum.MARRON, "\u001B[38;5;130m");
		asciiMap.put(ColoresEnum.GRIS, "\u001B[38;5;240m");
		asciiMap.put(ColoresEnum.BLANCO, "\u001B[37m");
		asciiMap.put(ColoresEnum.NEGRO, "\u001B[30m");
		formatos.put(TipoFormatoColorEnum.ASCII, asciiMap);

		Map<ColoresEnum, String> hexMap = new HashMap<>();
		hexMap.put(ColoresEnum.AMARILLO, "#FFFF00");
		hexMap.put(ColoresEnum.ROJO, "#FF0000");
		hexMap.put(ColoresEnum.AZUL, "#0000FF");
		hexMap.put(ColoresEnum.VERDE, "#00FF00");
		hexMap.put(ColoresEnum.VIOLETA, "#8A2BE2");
		hexMap.put(ColoresEnum.ROSA, "#FF1493");
		hexMap.put(ColoresEnum.NARANJA, "#FFA500");
		hexMap.put(ColoresEnum.MARRON, "#8B4513");
		hexMap.put(ColoresEnum.GRIS, "#808080");
		hexMap.put(ColoresEnum.BLANCO, "#FFFFFF");
		hexMap.put(ColoresEnum.NEGRO, "#000000");
		formatos.put(TipoFormatoColorEnum.HEXADECIMAL, hexMap);

		Map<ColoresEnum, String> rgbMap = new HashMap<>();
		rgbMap.put(ColoresEnum.AMARILLO, "255,255,0");
		rgbMap.put(ColoresEnum.ROJO, "255,0,0");
		rgbMap.put(ColoresEnum.AZUL, "0,0,255");
		rgbMap.put(ColoresEnum.VERDE, "0,255,0");
		rgbMap.put(ColoresEnum.VIOLETA, "138,43,226");
		rgbMap.put(ColoresEnum.ROSA, "255,20,147");
		rgbMap.put(ColoresEnum.NARANJA, "255,165,0");
		rgbMap.put(ColoresEnum.MARRON, "139,69,19");
		rgbMap.put(ColoresEnum.GRIS, "128,128,128");
		rgbMap.put(ColoresEnum.BLANCO, "255,255,255");
		rgbMap.put(ColoresEnum.NEGRO, "0,0,0");
		formatos.put(TipoFormatoColorEnum.RGB, rgbMap);
		
		formatos.put(TipoFormatoColorEnum.DEFAULT, Map.of(ColoresEnum.BLANCO, "255,255,255"));
		formatos.put(TipoFormatoColorEnum.VACIO, Collections.emptyMap());
		
	}

	public Color(String tipoFormato, String codigoColor) {
		if(tipoFormato.isBlank() || codigoColor.isBlank()) {
			this.tipoFormato = TipoFormatoColorEnum.DEFAULT.obtenerTipoFormato();
			this.codigoColor = ColoresEnum.BLANCO.obtenerColor();
		} else {
			this.tipoFormato = tipoFormato;
			this.codigoColor = codigoColor;
		}
	}
	
	public Color() {
		this.tipoFormato = TipoFormatoColorEnum.DEFAULT.obtenerTipoFormato();
		this.codigoColor = ColoresEnum.BLANCO.obtenerColor();
	}

	public void establecerTipoFormato(String tipoFormato) {
		Objects.requireNonNull(tipoFormato);

		this.tipoFormato = tipoFormato;
	}
	
	public void establecerCodigoColor(String codigoColor) {
		this.codigoColor = codigoColor;
	}

	public String obtenerTipoFormato() {
		return this.tipoFormato;
	}

	public String obtenerColor() {
		return this.codigoColor;
	}
	
	public Map<ColoresEnum, String> obtenerVariosColores(String tipoFormatoColor) {
		return Color.formatos.get(TipoFormatoColorEnum.comprobarTipo(tipoFormatoColor));
	}
	
	public String obtenerColorPorTipo(String tipoFormatoColor, String color) {
		return Color.formatos.get(TipoFormatoColorEnum.comprobarTipo(tipoFormatoColor))
				.get(ColoresEnum.comprobarColor(color));
	}
	
	public void establecerColor(String codigoColor) {
		Objects.requireNonNull(codigoColor);

		this.codigoColor = codigoColor;
	}

	public void establecerColorHexadecimal(String codigoColor) {
		Objects.requireNonNull(codigoColor);

		establecerTipoFormato(TipoFormatoColorEnum.HEXADECIMAL.obtenerTipoFormato());
		establecerColor(ColoresEnum.comprobarColor(codigoColor).obtenerColor());
	}

	public void establecerColorAscii(String codigoColor) {
		Objects.requireNonNull(codigoColor);

		establecerTipoFormato(TipoFormatoColorEnum.ASCII.obtenerTipoFormato());
		establecerColor(ColoresEnum.comprobarColor(codigoColor).obtenerColor());
	}

	public void establecerColorRgb(String codigoColor) {
		Objects.requireNonNull(codigoColor);

		establecerTipoFormato(TipoFormatoColorEnum.RGB.obtenerTipoFormato());
		establecerColor(ColoresEnum.comprobarColor(codigoColor).obtenerColor());
	}

	private void establecerColorPorDefecto() {
		this.codigoColor = ColoresEnum.BLANCO.obtenerColor();
	}
	
	public void establecerTipoFormatoPorDefecto() {
		this.tipoFormato = TipoFormatoColorEnum.DEFAULT.obtenerTipoFormato();
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
	
	public void reset() {
		establecerColorPorDefecto();
		establecerTipoFormatoPorDefecto();
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
		NARANJA("Naranja"), MARRON("Marron"), GRIS("Gris"), BLANCO("Blanco"), NEGRO("Negro");

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
