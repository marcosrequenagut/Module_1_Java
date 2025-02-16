package fabrica.maquinas;

import fabrica.Pieza;
import fabrica.posiciones.Grosor;
import fabrica.posiciones.Posicion;

public class Taladradora implements Maquina {
    private Posicion posicion;
    private Grosor grosor;

    /// Constructor Taladradora. Crea la máquina taladradora con los parámetros posicion y grosor indicado
    /// @param pos posicion de la taladradora
    /// @param gr grosor de la taladradora
    public Taladradora(Posicion pos, Grosor gr){
        posicion = pos;
        grosor = gr;
    }
    //uso: Taladradora(Posicion.CeCe,Grosor.Grueso)
    /// Transforma la información pasada como argumentos en el main para modificar la pieza al actuar una taladradora
    @Override
    public void actua(Pieza pieza) {
        String grosorTa = switch (grosor) {
            case Fino -> "1";
            case Medio -> "2";
            case Grueso -> "3";
            //default -> "Grosor no válido";  // no hace falta ponerlo xque es un enum!!!
        };
        String codigoTaladradora = "TL" + grosorTa;

        //Posición en la matriz según la posición de la taladradora.
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
        pieza.insertaEnOrden(fila, columna, codigoTaladradora);

    }



}
