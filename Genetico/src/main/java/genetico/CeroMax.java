package genetico;

public class CeroMax implements Problema{
    /// Constructor por defecto
    public CeroMax(){
    }

    /// # Calcula el fitness sumando los genes con valor 0 en el cromosoma
    /// @param cromosoma es el cromosoma al que se le calcula el fitness
    @Override
    public double evalua(Cromosoma cromosoma) {
        double fitness = 0;
        for (int i = 0; i < cromosoma.getLongitud(); i++){
            if(cromosoma.getGen(i) == cromosoma.GEN_POR_DEFECTO)
                fitness++;
        }
        return fitness;
    }
}