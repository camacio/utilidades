package main.java.utils.string;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.Serializable;
import java.text.AttributedString;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.swing.JFormattedTextField;

import main.java.utils.string.formato.FormatoTextoConsola;

public final class Cadena implements Serializable, Comparable<Cadena> {

	private static final long serialVersionUID = 1L;
	private String cadena;
	private List<String> lineas;


	public Cadena(String cadena) {
		this.cadena = cadena;
		
		lineas = new ArrayList<>();
		
	}
	
	public Cadena dividirMitad() {
		this.cadena = this.cadena.substring(0, cadena.length() / 2);
		return this;
	}
	
	public Cadena letraSiguiente() {
		StringCharacterIterator iterator = new StringCharacterIterator(cadena);
		
		Character letra = iterator.next();
		this.cadena = letra.toString();
		return this;
	}
	
	public Cadena letraAnterior() {
		StringBuilder builder = new StringBuilder();
		StringCharacterIterator iterator = new StringCharacterIterator(cadena);
		char letra = iterator.last();
		while(letra != iterator.first()) {
			builder.append(letra);
			iterator.previous();
		}
		this.cadena = builder.toString();
		return this;
	}
	
	public Cadena ultimaLetra() {
		StringCharacterIterator iterador = new StringCharacterIterator(cadena);
		Character letra = iterador.last();
		this.cadena = letra.toString();
		return this;
	}
	
	public Cadena seleccionarLetras(char letra) {
		Objects.nonNull(letra);
		
		this.cadena = this.cadena.lines()
				.filter(l -> l.chars()
				.anyMatch(c -> Character.toLowerCase(c) == (Character.toLowerCase(letra))))
				.collect(Collectors.joining(System.lineSeparator()));
		return this;
	}
	
	public Cadena separarEnLineas() {
		
		return this;
	}
	
	public Cadena capitalizar() {
		StringCharacterIterator iterator = new StringCharacterIterator(cadena);
		this.cadena = this.cadena.lines().filter(l -> l.equals(" "))
						.map(l -> l += iterator.next())
						.map(String::toUpperCase)
						.collect(Collectors.joining());
		return this;
		
	}
	
	public Cadena buscarCadena(String otraCadena) {
		Objects.requireNonNull(otraCadena);
		
		this.cadena = this.cadena.lines()
				.filter(l -> l.equalsIgnoreCase(String.valueOf(otraCadena.chars())))
				.findFirst()
				.get();
		
		return this;
	}
	
	public Cadena buscarCadenas(String otraCadena) {
		Objects.requireNonNull(otraCadena);
		
		this.cadena = this.cadena.lines().takeWhile(l -> l.equalsIgnoreCase(otraCadena))
					.collect(Collectors.joining(", "));
		
		return this;
	}
	
	public Cadena concatenar(String cadena) {
		Objects.requireNonNull(cadena);
		
		this.cadena = this.cadena.concat(" ").concat(cadena);
		return this;
	}
	
	public Cadena saltoDeLinea() {
		this.cadena = this.cadena.concat(System.lineSeparator());
		return this;
	}

	public boolean estaVacia() {
		return cadena.length() == 0;
	}
	
	private Cadena aplicarFormato(String inicio, String fin) {
		StringBuilder builder = new StringBuilder();
        builder.append(inicio).append(cadena).append(fin);
        this.cadena = builder.toString();
		return this;
	}
	
	public Cadena negrita() {
		return aplicarFormato("\033[1m", "\033[0m");
	}
	
	public Cadena subrayar() {
		return aplicarFormato("\033[4m", "\033[0m");
	}
	
	public Cadena cursiva() {
		StringBuilder builder = new StringBuilder();
		AttributedString texto = new AttributedString(cadena);
		texto.addAttribute(TextAttribute.FONT, new Font(Font.SANS_SERIF, Font.ITALIC, 16));
		texto.getIterator().toString();
		return this;
	}
	
	public Cadena copiarCadena(String otraCadena) {
		new String(otraCadena);
		return this;
	}
	
	public Cadena obtenerCadena() {
		return new Cadena(this.cadena);
	}
	
	public Cadena reiniciarCadena() {
		this.cadena = "";
		return this;
	}

	@Override
	public String toString() {
		return this.cadena;
	}
	
	@Override
	public int compareTo(Cadena otraCadena) {
		return this.compareTo(otraCadena);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cadena);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadena other = (Cadena) obj;
		return Objects.equals(cadena, other.cadena);
	}

	public Cadena obtenerTamañoFuente() {
		return this;
	}

}

