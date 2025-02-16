package genetico;
import java.util.Arrays;
import java.util.Random;

public class Cromosoma {
    /// Atributos de la clase
    protected int [] datos; // Array de genes, un array de genes "forma" un cromosoma
    protected int GEN_POR_DEFECTO = 0;
    protected static Random gna = new Random(); // Las variables Random siempre son static

    /// # Crea un cromosoma de manera aleatoria o por defecto
    /// 1. Si `gen = True` el `cromosoma` se genera aleatoriamente
    /// 1. Si `gen = False` el `cromosoma` es todo 0
    /// @param tam es la cantidad de genes que tiene cada cromosoma (longitud del cromosoma)
    /// @param gen  me indica si el cromosoma se crea de forma aleatoria o por defecto

    public Cromosoma (int tam, boolean gen){
        if (tam <= 0)
            throw new IllegalArgumentException("Error: el tamaño del cromosomma es nulo o negativo");

        datos = new int[tam];
        for (int i = 0; i < tam; i++){
            if(gen)
                datos[i] = gna.nextInt(2);
            else
                datos[i] = GEN_POR_DEFECTO;
        }
    }

    /// # Genera una copia del cromosoma
    /// @param cromosoma es el cromosoma al que se realiza la copia
     /// @return no devuelve nada
    public Cromosoma(Cromosoma cromosoma) {
        this.datos = new int[cromosoma.datos.length];

        // Copiar los valores de los genes
        for (int i = 0; i < cromosoma.datos.length; i++) {
           this.datos[i] = cromosoma.datos[i];
        }
    }

    /// # Asigna un cierto valor a un gen
    /// @param valor_gen es el valor que se asigna al gen
     /// @param posicion es la posición donde se va a asignar
     /// @return no devuelve nada
    public void setGen(int posicion, int valor_gen){
        datos[posicion] = valor_gen;
    }

    /// # Devuelve el valor de un gen en un cromosoma
    /// @param posicion del gen
     /// @return devuelve el valor del gen en cierta posicion
    public int getGen(int posicion){
        return datos[posicion];
    }

    /// # Devuelve la longitud del cromosoma (cantidad de genes que lo componen)
    public int getLongitud(){
        return datos.length;
    }

    /// # Provoca una mutación en ciertos genes
    /// 1. Se genera un número aleatorio entre 0 y 1
    /// 1. Si ese número es menor que `prob_mutacion` el gen cambia su valor
    /// @param prob_mutacion es la probabilidad de mutación
     /// @return no devuelve nada
    public void mutar(double prob_mutacion){
        if (prob_mutacion > 1)
            throw new IllegalArgumentException("Error: la probabilidad de mutacion no puede ser mayor que 1");

        for (int i = 0; i < getLongitud(); i++){
            if(gna.nextDouble() < prob_mutacion) {
                if (datos[i] == 1)
                    datos[i] = GEN_POR_DEFECTO;
                else
                    datos[i] = 1;
            }
        }
    }

    /// Muestra el cromosoma como un array de elementos separados por comas
    @Override
    public String toString() {
        return Arrays.toString(datos) ;
    }
}
