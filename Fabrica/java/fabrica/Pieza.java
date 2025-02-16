package fabrica;
import java.util.List;

public class Pieza {
    private String[][][] pieza;
    public static final List<String> ordenMarcas = List.of("LN", "LE", "LS", "LO", "FV", "FH", "FI", "FD", "TL");

    /// Constructor pieza.
    /// Una pieza es una matriz 3x3 que en cada posición tiene un array de longitud 9 (el número máximo de máquinas que puede tener cada cuadro)
    public Pieza() {
        this.pieza = new String[3][3][9];
    }

    public String[][][] getPieza() {
        return pieza;
    }

    public void setPieza(String[][][] pieza) {
        this.pieza = pieza;
    }

    /// Añadir una marca en orden pasando como argumento la posicion y la máquina a añadir
    /// la lista `ordenMarcas` indica el orden que deben de seguir las máquinas al ser introducidas
    /// Se tiene el cuenta que cualquier marca desaparece por otra igual y del mismo tipo o grosor superior
    /// También se tiene en cuenta que cualquier lija fina desaparece si en el mismo cuadro hay un taladro grueso
    public void insertaEnOrden(int fila, int columna, String marca) {

        String[] posicionMarca = pieza[fila][columna];  //contenido actual de cada cuadrado

        int indice = ordenMarcas.indexOf(marca.substring(0, 2)); //posicion de la máquina pasada como argumento en la lista ordenMarcas
        if (indice == -1) {
            throw new IllegalArgumentException("Marca no válida: " + marca); //por si marca no es válida
        }

        boolean reemplazada = false; // Para saber si se hizo una sustitución

        ///Cualquier	marca	desaparece	por	otra igual	y	del	mismo	tipo	de	grosor	superior
        if (posicionMarca[indice] != null) {  //existe una marca del mismo tipo en ese cuadro
            int grosorViejo = Integer.parseInt(posicionMarca[indice].substring(2));
            int grosorNuevo = Integer.parseInt(marca.substring(2));
            if (grosorNuevo > grosorViejo) {
                posicionMarca[indice] = marca;  //solo se reemplaza si la nueva es mayor
                                                // x ejemplo reemplaza LN1 por LN3, pero si existiese LN3 , no se reemplazaría si la nueva fuese LN1
            }
            reemplazada = true;
        }
        //si no existe una marca del mismo tipo se agrega la nueva marca
        if (!reemplazada) {
            posicionMarca[indice] = marca;
        }

        ///Cualquier lija fina desaparece si en el mismo cuadro hay un taladro grueso
        if (marca.equals("TL3")){
            int indiceBorrar = ordenMarcas.indexOf(("LN"));
            if(posicionMarca[indiceBorrar]!= null)
                posicionMarca[indiceBorrar]=null;
        }
        pieza[fila][columna] = posicionMarca;  //actualizar los cambios en pieza
    }


    /// Representación específica de la pieza
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append("|");
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 9; k++) {
                    if (pieza[i][j][k]!= null) {
                        sb.append(pieza[i][j][k]);
                    } else {
                        sb.append("   ");
                    }
                }
                sb.append("|");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}





