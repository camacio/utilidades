package main.java.utils.jdbc;

public enum DataDefinicionLenguajeEnum {
	
	CREATE_TABLE("create table"), ALTER_TABLE("alter table"), 
	DROP_TABLE("drop table"), CREATE_INDEX("create index"), CREATE_DATABASE("create database");
	
	private final String sentencia;
	
	private DataDefinicionLenguajeEnum(String sentencia) {
		this.sentencia = sentencia;
	}
	
	public String getSentencia() {
		return this.sentencia;
	}
	
	public static boolean verificarSentencia(String cadenaComparar) {
        for (DataDefinicionLenguajeEnum valorEnum : DataDefinicionLenguajeEnum.values()) {
            if (valorEnum.getSentencia().equalsIgnoreCase(cadenaComparar)) {
                return true;
            }
        }
        return false;
    }
}
