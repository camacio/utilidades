package main.java.utils.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Alias {

	@AliasPara("atributo")
	String valor() default "";
	
	@AliasPara("valor")
	String atributo() default "";
	
	Class<? extends Annotation> anotacion() default Annotation.class;
}
