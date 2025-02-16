package genetico;

public class Individuo{
    /// Atributos de la clase
    private double fitness;
    private Cromosoma cromosoma;

    /// Primer constructor: crea un cromosoma de manera aleatoria y se calcula su fitness
    /// @param tam es el tamaño o longitud del cromosoma (de cuantos genes está compuesto)
    /// @param problema es un parámetro que indica de qué forma se va a calcular el mejor individuo
    public Individuo(int tam, Problema problema){
        this.cromosoma = new Cromosoma(tam, true); // true indica que se creará de manera aleatoria
        fitness = problema.evalua(cromosoma);
    }

    /// Segundo constructor: crea una copia del cromosoma que se le pasa como argumento
    /// @param cromosoma asociado a un individuo
     /// @param problema a resolver
    public Individuo(Cromosoma cromosoma, Problema problema){

        // Copia el cromosoma argumento utilizando el segundo constructor de Cromosoma
        this.cromosoma = new Cromosoma(cromosoma);

        // Evalua el fitness del cromosoma
        this.fitness = problema.evalua(this.cromosoma);
    }

    /// # Devuelve el valor fitness del cromosoma
    /// ## Es una cuantificación de cuánto de bueno es el individuo
    public double getFitness(){
        return fitness;
    }

    /// Devuelve una copia del cromosoma
    public Cromosoma getCromosoma(){
        return new Cromosoma(this.cromosoma);
    }

    /// Muuestra los resultados de manera conveniente
    @Override
    public String toString() {
        return "Individuo{" +
                "fitness= " + fitness +
                ", cromosoma= " + cromosoma +
                '}';
    }
}
