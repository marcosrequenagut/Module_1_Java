package fabrica.maquinas;

import fabrica.Pieza;
import fabrica.posiciones.Grosor;
import fabrica.posiciones.OrLija;
import fabrica.posiciones.Posicion;

public class Lijadora implements Maquina {
    private OrLija orLija;
    private Posicion posicion;
    private Grosor grosor;

    /// Constructor Lijadora. Crea la máquina lijadora con los parámetros posicion, orientacion y grosor indicados
    /// @param pos posicion de la lijadora
    /// @param orientacion orientacion de la lijadoara
    /// @param gr grosor de la lijadora
    public Lijadora(Posicion pos, OrLija orientacion, Grosor gr){
        posicion = pos;
        orLija = orientacion;
        grosor  = gr;
    }

    //uso:  Lijadora(Posicion.IzSu, OrLija.Norte,Grosor.Grueso);
    /// Transforma la información pasada como argumentos en el main para modificar la pieza al actuar una lijadora
    @Override
    public void actua(Pieza pieza) {
        String grosorLi = switch (grosor) {
            case Fino -> "1";
            case Medio -> "2";
            case Grueso -> "3";
        };

        String orientacionLi = switch (orLija) {
            case Norte -> "LN";
            case Sur -> "LS";
            case Este -> "LE";
            case Oeste -> "LO";
        };

        String codigoLijadora = orientacionLi + grosorLi;

        //Posición en la matriz según la posición de la lijadora.
        int fila = 0;
        int columna = 0;
        switch (posicion) {
            case IzSu -> {fila = 0; columna = 0;}
            case IzCe -> {fila = 1; columna = 0;}
            case IzIn -> {fila = 2; columna = 0;}
            case CeSu -> {fila = 0; columna = 1;}
            case CeCe -> {fila = 1; columna = 1;}
        }

        // Actualizar la matriz en la posición calculada.
        pieza.insertaEnOrden(fila, columna, codigoLijadora);
    }

}
