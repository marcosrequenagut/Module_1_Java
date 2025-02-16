package genetico;

/// # Devuelve el valor fitness (como de bueno es el individuo) asociado al cromosoma, dependiendo del problema que se le asigne.
/// 1. Si el problema elegido es `0neMax()`, el `fitness` es la suma de genes con valor 1 del cromosoma
/// 1. Si el problema elegido es `CeroMax()`, el `fitness` es la suma de genes con valor 0 del cromosoma
@FunctionalInterface // Es una interfaz con un solo método abstracto, me aseguro de que sea realmente funcional
public interface Problema {
    double evalua (Cromosoma cromosoma);
}

