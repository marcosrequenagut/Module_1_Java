package rectas;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public record Punto(double x, double y) {

    // Tengo un constructor con dos argumentos
    // Tengo dos metodos que me devuelven la x y la y
    // Tengo el toString que me muestra el punto
    // Todo esto incluido en el record

    // Creo el constructor que me piden
    // Creo un constructor que llama al record (el otro constructor)
    // Al record smp hay que llamarlo

    /// Constructor que inicializa el punto al origen de coordenadas
    public Punto(){
        this(0,0);
    }

    // El receptor es siempre (0,0)?
    /// Calcula la distancia entre el receptor y el punto `pto`
    /// @param pto es el punto al que se va a calcular la distancia
    /// @return distancia
    public double distancia(Punto pto){
        return sqrt(pow(this.x - pto.x(),2) + pow(this.y - pto.y(),2));
    }

}
