package main.java.utils.string.formato;

public enum FormatoASCIIFuenteEnum {

	NEGRITA("\033[1m"), CURSIVA("\033[3m"), ITALICA("\033[3m"), SUBRAYADO("\033[4m"), TACHADO("\033[9m"),
	RESET("\033[0m");

	private final String codigoEscape;

	FormatoASCIIFuenteEnum(String codigoEscape) {
	        this.codigoEscape = codigoEscape;
	    }

	public String getCodigoEscape() {
		return codigoEscape;
	}

}
