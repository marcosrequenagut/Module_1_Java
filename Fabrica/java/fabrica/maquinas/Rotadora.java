package fabrica.maquinas;

import fabrica.Pieza;
import fabrica.posiciones.*;

import static fabrica.Pieza.ordenMarcas;

public class Rotadora implements Maquina {
    private Sentido sentido;

    /// Constructor Fresadora. Crea la máquina rotadora con el parámetro sentido indicado
    /// @param sentido sentido de la rotadora
    public Rotadora(Sentido sentido) {
        this.sentido = sentido;
    }
    public Sentido getSentido() {
        return sentido;
    }


    @Override
    public void actua(Pieza pieza) {
        String[][][] matriz = pieza.getPieza(); //matriz es una referencia al objeto pieza dentro de Pieza.
        String[][][] rotada = new String[3][3][9]; //matriz vacía llena de nulls.

        //Rotacion de la matriz 3x3
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String[] rotadaMaquina = new String[9];
                rotadaMaquina = calcularRotada(matriz[i][j]);  //rotar cada máquina de cada cuadrado
                if (sentido == Sentido.Horario) {
                    rotada[j][2 - i] = rotadaMaquina;
                } else {
                    rotada[2 - j][i] = rotadaMaquina;
                }
            }
        } pieza.setPieza(rotada);
    }

    //Rotar cada máquina de cada cuadro de la pieza dependiendo del sentido
    private String[] calcularRotada(String[] original){
        String[] rotadaMaquina = new String[9];
        for (String m : original) {
            if (m!=null) {
                if (sentido == Sentido.Horario) {
                    String nuevo = sentidoHorario(m);
                    int indice = ordenMarcas.indexOf(nuevo.substring(0,2));
                    rotadaMaquina[indice] = nuevo;
                } else {
                    String nuevo = sentidoAntiHorario(m);
                    int indice = ordenMarcas.indexOf(nuevo.substring(0,2));
                    rotadaMaquina[indice] = nuevo;
                }
            }
        }
        return rotadaMaquina;
    }

    private String sentidoHorario (String m){
        String maquina = m.substring(0, 2); //para coger la orientacion sin el grosor (el grosor no cambia al rotar)
        String numero = m.substring(2);
        return switch (maquina) {
            case "LN" -> "LE" + numero; //lija norte -> lija este
            case "LE" -> "LS" + numero; //lija este -> lija sur
            case "LS" -> "LO" + numero; //lija sur -> lija oeste
            case "LO" -> "LN" + numero; //lija oeste -> lija norte
            case "FV" -> "FH" + numero; //fresadora vertical -> fresadora horizontal
            case "FD" -> "FI" + numero; //fresadora diagonal derecha -> fresadora diagonal izquierda
            case "FI" -> "FD" + numero; //fresadora diagonal izquierda -> fresadora diagonal derecha
            case "FH" -> "FV" + numero; //fresadora horizontal -> fresadora vertical
            default -> m; //si no hay ninguna máquina en el cuadrado, se queda igual
        };

    }

    private String sentidoAntiHorario (String m) {
        String maquina = m.substring(0, 2); //para coger la orientacion sin el grosor (el grosor no cambia al rotar)
        String numero = m.substring(2);
        return switch (maquina) {
            case "LN" -> "LO" + numero; //lija norte -> lija oeste
            case "LE" -> "LN" + numero; //lija este -> lija norte
            case "LS" -> "LE" + numero; //lija sur -> lija este
            case "LO" -> "LS" + numero; //lija oeste -> lija sur
            case "FV" -> "FH" + numero; //fresadora vertical -> fresadora horizontal
            case "FD" -> "FI" + numero; //fresadora diagonal derecha -> fresadora diagonal izquierda
            case "FI" -> "FD" + numero; //fresadora diagonal izquierda -> fresadora diagonal derecha
            case "FH" -> "FV" + numero; //fresadora horizontal -> fresadora vertical
            default -> m; //si no hay ninguna máquina en el cuadrado, se queda igual
        };
    }

}



