package genetico;

public class Poblacion {
    private Individuo [] individuos; // Array que contiene todos los Individuos de la población

    /// # Constructor de la clase: crea una `poblacion` (conjunto de `individuos`) de manera aleatoria
    /// @param tam_pobl es el tamaño de la `poblacion` (cuántos `individuos` hay)
    /// @param tam_indi es la longitud de los `individuos` (cuántos genes tienen los cromosomas)
    /// @param problema es cómo se elije al mejor `individuo`
    public Poblacion(int tam_pobl, int tam_indi, Problema problema){
        if (tam_pobl <= 0)
            throw new IllegalArgumentException("Error: tamaño de la población nulo o negativo");
        // Inicializo el Array de individuos con cierto tamaño (numero de individuos o tamaño de la poblacion)
        individuos = new Individuo[tam_pobl];

        for (int i = 0; i < tam_pobl; i++){ // Una poblacion es un conjunto de individuos
            // Llamo al 1 constrcutor de individuos, que me crea individuos aleatoriamente
            individuos[i] = new Individuo(tam_indi, problema);
        }
    }

    /// Devuelve el número de individuos que componen la poblacion, es decir, la longitud del array de individuos
    public int getNumIndividuos(){
        return individuos.length;
    }

    /// Devuelve la la posicion de un `individuo` en el array de `individuos`
    ///@param posicion del i-ésimo individuo en la población.
    public Individuo getIndividuo(int posicion){
        return individuos[posicion];
    }

    /// Devuelve el `individuo` con mayor valor de `fitness` de la `poblacion`
    public Individuo mejorIndividuo(){

        // Lanzo un trhow para comprobar que la población no está vacía
        if (individuos.length == 0) {
            throw new IllegalArgumentException("La población está vacía.");
        }

        // Suponemos que el primer individuo es el mejor y que su fitness es el mayor
        // El que tenga mayor fitness será mejor

        Individuo mejor_individuo = individuos[0];

        // Comparo los fitness uno a uno quedandome con el mayor valor
        // Si hay alguien con mayor fitness lo asigno como mejor individuo
        // Si da la casualidad que el primer individuo es el mejor, se devuelve ese individuo
        // Se empieza en i = 1 para no contar el individuo 0
        for (int i = 1; i < individuos.length; i++){
            if (individuos[i].getFitness() > mejor_individuo.getFitness()){
                mejor_individuo = individuos[i];
            }
        }
        return mejor_individuo;
    }

    /// Sustituye un individuo por otro (dado como parámetro) en el caso de que ese otro
    /// sea mejor (tenga mayor `fitness`)
    public void remplaza(Individuo indi){

        // Suponemos que el primer individuo es el peor y que su fitness es el peor
        int posicion_peor = 0;
        double peor_fitness = individuos[0].getFitness();

        // Voy comparando el fitness de todos los individuos con el primer individuo
        // Si hay alguien con peor fitness lo asigno como peor individuo
        // Puede darse la casualidad de que el primer individuo sea el peor
        // El bucle empieza en i = 1 para no comparar el primer individuo consigo mismo
        for (int i = 1; i < individuos.length; i++){
            if (peor_fitness > individuos[i].getFitness()){
                peor_fitness = individuos[i].getFitness();
                posicion_peor = i;
            }
        }

        // Si el peor individuo de la poblacion sigue siendo mejor que el que se pasa como
        // argumento, no se hace nada.
        // Si el peor individuo es peor que el que se pasa como argumento, se remplaza este
        // peor individuo por el del argumento, que es mejor.
        if (peor_fitness < indi.getFitness())
            individuos[posicion_peor] = indi;
    }
}
