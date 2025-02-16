package genetico;

public abstract class AlgoritmoGenetico {
    private Problema problema;
    private double probMutacion;
    private Poblacion poblacion;
    private int pasos;

    /// Constructor de la clase
    /// @param tam_pobl es el tamaño de la población (cuántos individuos hay)
    /// @param tam_indi es la longitud de los individuos (cuántos genes tiene cada individuo)
    /// @param pasos es el número de iteraciones (generaciones)
    /// @param probMutacion es la probabilidad de mutación
    /// @param problema es cómo se calcula el fitness
    public AlgoritmoGenetico(int tam_pobl, int tam_indi, int pasos, double probMutacion, Problema problema){
        this.poblacion = new Poblacion(tam_pobl, tam_indi, problema);
        this.pasos = pasos;
        this.probMutacion = probMutacion;
        this.problema = problema;
        if (pasos <= 0)
            throw new IllegalArgumentException("Error: el número de pasos (o de generaciones) es nulo o negativo");
    }

    /// # Crea todos los individuos de la población y los va comparando uno a uno quedándose con el mejor
    /// 1. Selecciona aleatoriamente dos individuos de la poblacion, recombina sus cromosomas y forma un nuevo cromosoma.
    /// 1. Luego muta ese nuevo cromosoma y crea un nuevo individuo con ese nuevo cromosoma mutado.
    /// 1. Si ese nuevo individuo es mejor que el peor individuo de la poblacion, lo remplazo.
    /// 1. Todo este proceso se repite el numero de `pasos` pasado como argumento.
    /// @return `poblacion.mejorIndividuo()` es el mejor individuo de la población
    public Individuo ejecuta(){
        int posicion1;
        int posicion2;

        for (int i = 0; i < pasos; i++) {
           do {
               posicion1 = Cromosoma.gna.nextInt(poblacion.getNumIndividuos());
               posicion2 = Cromosoma.gna.nextInt(poblacion.getNumIndividuos());
           } while (posicion1 == posicion2); // Se repite si las posiciones coinciden
            Individuo i1 = poblacion.getIndividuo(posicion1);
            Individuo i2 = poblacion.getIndividuo(posicion2);

            Cromosoma cr1 = i1.getCromosoma();
            Cromosoma cr2 = i2.getCromosoma();

            Cromosoma cr3_recombinado = recombinar (cr1,cr2);
            cr3_recombinado.mutar(probMutacion);

            Individuo indi_nuevo = new Individuo(cr3_recombinado, problema);
            poblacion.remplaza(indi_nuevo);
        }
        return poblacion.mejorIndividuo();
    }

    /// # Recombina los genes de dos cromosomas (individuos).
    /// ## Dependiendo qué algoritmo se elija (`AGUniforme` o `AGUnPunto`) se recombinan de una forma u otra
    // Al estar dentro de una clase Abstracta y ser un método abstracto
    // las subclases están obligadas a implementar esos métodos
    protected abstract Cromosoma recombinar(Cromosoma cr1, Cromosoma cr2);
}


