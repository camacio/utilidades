package main.java.utils.string.formato;

public enum FamiliaFuenteEnum {

	ARIAL("Arial"), TIMES_NEW_ROMAN("TimesNewRoman"), HELVETICA("Helvetica"), CALIBRI("Calibri"), 
	VERDABA("Verdaba"), GEORGIA("Georgia"), COURIER_NEW("CourierNew");
	
	private final String familia;
	
	private FamiliaFuenteEnum(String familia) {
		this.familia = familia;
	}

	public String obtenerValor() {
		return familia;
	}
}
