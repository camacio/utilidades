package main.java.config.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ContenedorBean {
	private Map<String, Object> beans = new HashMap<>();
    private Map<String, DefinicionBean> beanDefinitions = new HashMap<>();

    public void registrarDefinicionBean(String nombreBean, DefinicionBean definicion) {
        beanDefinitions.put(nombreBean, definicion);
    }

    public void registrarBean(String nombreBean, Object bean) {
        beans.put(nombreBean, bean);
    }

    public Object obtenerBean(String nombreBean) {
        DefinicionBean definicion = beanDefinitions.get(nombreBean);
        if (definicion != null) {
            Object bean = beans.get(nombreBean);
            if (bean == null) {
                // Crear y almacenar el bean si aún no está creado
                bean = crearBean(definicion);
                beans.put(nombreBean, bean);
            }
            return bean;
        }
        return null;
    }

    private Object crearBean(DefinicionBean definicion) {
        // Aquí puedes implementar la lógica para crear el bean
        // utilizando los datos de la DefinicionBean
        // Por ejemplo, puedes utilizar reflection para crear la instancia
        // o cualquier otra lógica de inicialización

        // Ejemplo simple utilizando la clase Class para crear una instancia
        try {
            return definicion.getClaseBean().getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Otros métodos como eliminarBean, métodos para gestión de ciclos de vida, etc.
	
	//ejemplo
    public <T> void registrarClase(Class<T> clase) {
        try {
            Constructor<?> constructor = clase.getDeclaredConstructors()[0]; // Obtener el primer constructor
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] dependencies = new Object[parameterTypes.length];

            for (int i = 0; i < parameterTypes.length; i++) {
                dependencies[i] = obtenerInstancia(parameterTypes[i]); // Resolver las dependencias recursivamente
            }

            T instancia = (T) constructor.newInstance(dependencies);
            contenedor.put(clase, instancia);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> T obtenerInstancia(Class<T> clase) {
        return clase.cast(contenedor.computeIfAbsent(clase, this::registrarClase));
   
}
