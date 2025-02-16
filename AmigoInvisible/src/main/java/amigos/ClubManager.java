package amigos;

import java.io.IOException;
import java.io.PrintWriter;

public class ClubManager {
    /// # Atributos de la clase
    private String fEntrada;
    private String delimitadores;
    private String fSalida;
    private boolean consola;
    private Club club;

    /// # Constructor de la clase
    public ClubManager(Club club) {
        this.club = club;
    }

    /// # Proporciona el nombre del fichero de entrada y el delimitador
    /// @param fEntrada es el nombre del fichero
     /// @param delim es el delimitador
     /// @return devuelve el receptor, un objeto de la clase ClubManager
    public ClubManager setEntrada(String fEntrada, String delim) {
        this.fEntrada = fEntrada;
        delimitadores = delim;
        return this;
    }

    /// # Proporciona el nombre del fichero de salida
    /// @param salida es el nombre del fichero
     /// @return devuelve el receptor, un objeto de la clase ClubManager
    public ClubManager setSalida(String salida) {
        fSalida = salida;
        return this;
    }

    /// # Comprueba si el fichero de entrada es null o si hay alguna salida ya sea por pantalla o por fichero
    /// @return no devuelve nada
    private void verify() {
        if (fEntrada == null)
            throw new AmigoException("No hay fichero de entrada");
        if (fSalida == null && !consola)
            throw new AmigoException("No hay salida ni a fichero ni a consola");
    }

    /// # Proporciona una salida por consola
    /// @param consola indica si la salida será por consola (`consola = true`) o no
     /// @return devuelve un objeto de la clase ClubManager
    public ClubManager setConsola(boolean consola) {
        this.consola = consola;
        return this;
    }

    /// # Lee el fichero, asigna un amigo a cada socio y presenta los datos por consola y/o en un fichero de salida
    /// ## Verifica que los valores en las variables de instancia son correctos con `verify()`
    /// @return no devuelve nada
    public void build() throws IOException {
        verify();
        club.lee(fEntrada,delimitadores);
        club.hacerAmigos();
        if (fSalida != null)
            club.presentaAmigos(fSalida);
        if (consola)
            try (PrintWriter pw = new PrintWriter(System.out, true)) {
                club.presentaAmigos(pw);
            }
    }
}
