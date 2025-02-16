package genetico;

public class OneMax implements Problema{
    /// Constructor por defecto
    public OneMax(){
    }

    /// # Calcula el fitness sumando los genes con valor 1 en el cromosoma
    /// @param cromosoma es el cromosoma al que se le calcula el fitness
    @Override
    public double evalua(Cromosoma cromosoma) {
        double fitness = 0;
        for (int i = 0; i < cromosoma.getLongitud(); i++){
            if(cromosoma.getGen(i) == 1)
                fitness++;
        }
        return fitness;
    }
}
