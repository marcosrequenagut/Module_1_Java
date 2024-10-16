package jarras;

public class Profe {
    private final int capacidad;
    private int contenido;

    /// Crea una jarra con capacidad dada
    /// Este es el constructor
    /// y contenido 0
    /// @throw IllegalArgumentException si la capacidad iicial es negativa

    public Jarra (int capInicial){
        if (capInicial <= 0)
            throw new IllegalArgumentException("Capacidad " + capInicial + " no positiva o nula");
        capacidad = capInicial;
        contenido = 0;
    }

    /// Llena `this` desde la jarra `j`
    /// - si cabe todo 'j' se vacia
    /// - si no cabe todo 'this' se llena y 'j' se queda con lo que no cabe
    /// @param j la jarra de donde extraemos
     /// @throw IllegalArgumentException si `this == j`
    public void llenaDesde(Jarra j){
        // this no puede ser 'j'
        if (this == j)
            throw IllegalArgumentException("No se puede volcar una jarra sobre si misma")
        int cabe = capacidad - contenido;
        if (cabe >= j.contenido){
            //HACER COSAS
        } else {
            //NO CABE TODO, HACER COSAS
        }

        // Es una representación concisa y escueta de lo que es la jarra
        // Siempre hay que poner un override cuando pongamos el metodo toString
        @Override
        public String toString(){
            return "J(" + capacidad + ", " + contenido +")";
        }
    }
}
