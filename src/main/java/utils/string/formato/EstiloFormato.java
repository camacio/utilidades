package main.java.utils.string.formato;

import java.util.Map;

public class EstiloFormato {
	private Map<TipoEstiloFormatoEnum, Map<EstiloFormatoEnum, String>> estiloFormato;
	
	
	
	public enum TipoEstiloFormatoEnum {
		ASCII("\033[1m"), HTML("\033[3m"), MARKDOWN("\033[3m"), RTF("\033[4m"), UNICODE("\033[9m"),
		RESET("\033[0m");

		private final String codigoEscape;

		private TipoEstiloFormatoEnum(String codigoEscape) {
		        this.codigoEscape = codigoEscape;
		    }

		public String getCodigoEscape() {
			return codigoEscape;
		}
	}
	
	public enum EstiloFormatoEnum {
		
		NEGRITA("Negrita"), CURSIVA("Cursiva"), SUBRAYADO("Subrayado"), TACHADO("Tachado"),
		RESET("Reset");
		
		private final String formato;
		
		private EstiloFormatoEnum(String formato) {
			this.formato = formato;
		}
		
		public String obtenerFormato() {
			return this.formato;
		}
		
		public EstiloFormatoEnum comprobarFormato(String formato) {
			return EstiloFormatoEnum.valueOf(formato);
		}
	}
}
