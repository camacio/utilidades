package main.java.utils.jdbc;

public enum DataManipulacionLenguajeEnum {
	
	SELECT("select"), INSERT_INTO("insert into"), UPDATE("update"), DELETE_FROM("delete from");
	
	private final String sentencia;
	
	private DataManipulacionLenguajeEnum(String sentencia) {
		this.sentencia = sentencia;
	}
	
	public String getSentencia() {
		return this.sentencia;
	}
}
