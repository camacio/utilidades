package main.java.utils.impl.io;

public enum NombreTablasEnum {

	ELEMENTOS("elementos"), MOBILIARIO("mobiliario"), AUTORES("autores"), USUARIOS("usuarios"), 
	EMPLEADOS("empleados"), MULTAS("multas"), LIBROS("libros"), REVISTAS("revistas"), PELICULAS("peliculas");
	
	private String nombreTabla;
	
	private NombreTablasEnum(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}
	
	public String dameNombreTabla() {
		return this.nombreTabla;
	}
	
	public static boolean verificarNombreTabla(String cadenaComparar) {
        for (NombreTablasEnum valorEnum : NombreTablasEnum.values()) {
            if (valorEnum.dameNombreTabla().equalsIgnoreCase(cadenaComparar)) {
                return true;
            }
        }
        return false;
    }
}
