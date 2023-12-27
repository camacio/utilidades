package main.java.config.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DefinicionBean {

	private String nombre;
	private Class<?> claseBean;
	private Object[] tipoParametrosConstructor;
	private FuenteDefinicionBean fuenteDefinicionBean;
	private String scope;
	private List<String> dependencias;

	public DefinicionBean(String nombre, Class<?> claseBean, Object[] tipoParametrosConstructor,
			FuenteDefinicionBean fuenteDefinicionBean, String scope, List<String> dependencias) {

		Objects.requireNonNull(nombre, "El nombre del bean no puede ser nulo");
		Objects.requireNonNull(claseBean, "La clase del bean no puede ser nula");

		this.nombre = nombre;
		this.claseBean = claseBean;
		this.tipoParametrosConstructor = tipoParametrosConstructor;
		this.fuenteDefinicionBean = fuenteDefinicionBean;
		this.scope = scope;
		this.dependencias = dependencias != null ? dependencias : new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Class<?> getClaseBean() {
		return claseBean;
	}

	public Object[] getTipoParametrosContructor() {
		return tipoParametrosConstructor;
	}

	public FuenteDefinicionBean getFuenteDefinicionBean() {
		return fuenteDefinicionBean;
	}

	public void setFuenteDefinicionBean(FuenteDefinicionBean fuenteDefinicionBean) {
		this.fuenteDefinicionBean = fuenteDefinicionBean;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public List<String> getDependencias() {
		return dependencias;
	}

	@Override
	public String toString() {
		return "DefinicionBean [nombre=" + nombre + ", nombreClase=" + claseBean
				+ ", tipoParametrosContructor=" + Arrays.toString(tipoParametrosConstructor) + ", fuenteDefinicionBean="
				+ fuenteDefinicionBean + ", scope=" + scope + ", dependencias=" + dependencias + "]";
	}

}
