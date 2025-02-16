package fabrica.maquinas;
import fabrica.Pieza;
import fabrica.posiciones.*;


public class Fresadora implements Maquina {
    private Posicion posicion;
    private OrFresa orFresa;
    private Grosor grosor;

    /// Constructor Fresadora. Crea la máquina fresadora con los parámetros posicion, orientacion y grosor indicados
    /// @param pos posicion de la fresadora
    /// @param orientacion orientacion de la fresadora
    /// @param gr grosor de la fresadora
    public Fresadora(Posicion pos, OrFresa orientacion, Grosor gr){
        posicion = pos;
        orFresa = orientacion;
        grosor = gr;
    }

    //uso: Fresadora(Posicion.IzSu, OrFresa.Vertical, Grosor.Medio)

    /// Transforma la información pasada como argumento en el main para modificar la pieza al actuar una fresadora
    @Override
    public void actua(Pieza pieza) {

        String grosorFr = switch (grosor) {
            case Fino -> "1";
            case Medio -> "2";
            case Grueso -> "3";
            //default -> "Grosor no válido";  // no hace falta ponerlo xque es un enum!!!
        };

        String orientacionFr = switch (orFresa) {
            case Vertical -> "FV";
            case Diagonal -> "FD";
            case Horizontal -> "FH";
        };

        String codigoFresadora = orientacionFr + grosorFr;

        //Posición en la matriz según la posición de la fresadora.
        int fila = 0;
        int columna = 0;
        switch (posicion) {
            case IzSu -> {fila = 0; columna = 0;}
            case IzCe -> {fila = 1; columna = 0;}
            case IzIn -> {fila = 2; columna = 0;}
            case CeSu -> {fila = 0; columna = 1;}
            case CeCe -> {fila = 1; columna = 1;}
        }

        //Actualizar la matriz en la posición calculada.
        pieza.insertaEnOrden(fila, columna, codigoFresadora);
        }


}


