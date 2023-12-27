package main.java.utils.impl.reflection;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import main.java.utils.generics.ClaseNoInstanciable;
import main.java.utils.reflection.ModificadorClase;

public class ModificadorClaseImpl<T> implements ModificadorClase<T>{
	
	@Override
	public String obtenerNombreClase(T elemento) {
		return elemento.getClass().getName();
	}

	@Override
	public String obtenerNombreSimpleClase(T elemento) {
		return elemento.getClass().getSimpleName();
	}
}
