package main.java.utils.collections;

public interface ColeccionGenerica<I extends Number,T,U> extends ConsultadorColecciones<T, I, U>, ManipuladorColecciones<T, I>, 
							OperacionesEspecialesColecciones<T, U>, ValidadorColecciones<I, T, U>{

}
