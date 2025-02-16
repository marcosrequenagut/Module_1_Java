package amigos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.IntStream;

public class Club {
    protected Set<Persona> socios; // Conjunto ordenado de los socios del club

    /// # Constructor que inicializa la estructura `socios`
    public Club() {
        socios = new TreeSet<>(); // Uso este porque dice que tienen que estar ordenados
    }

    /// # Comprueba si todas las posiciones de un array de enteros han sido cambiadas
    /// 1. El array `lista` es un array de enteros que inicialmente estaba ordenado crecientemente empezando en el 0
    /// 1. Se comprueba si se ha desordenado por completo mirando si las posciones inciales coindicen con las finales
    /// 1. Se usa el bucle for porque es un caso muy concreto y se saben cuales son las posiciones inciales
    /// @param lista es un array de números enteros
     /// @return no devuelve nada
    private static boolean hayCoincidencias(List<Integer> lista) {
        // Se compara de esa manera porque sabemos que lista es una lista de enteros del 0 al lista.size()
        for (int i = 0; i < lista.size(); i++) {
            if (i == lista.get(i))
                return true; // Si coincide una antes de recorrer la lista, se devuelve true
        }
        return false; // Si no coindice ninguna, terminará el bucle y devolverá false
    }

    /// # Escribe uno a uno el nombre del socio y a quién le va a regalar
    /// @param pw indica que se va a escribir texto en cierto destino, ya sea por consola o en un fichero de salida
     /// @return no devuelve nada
    public void presentaAmigos(PrintWriter pw) {
        for (Persona p : socios) {
            pw.println(p);
        }
    }

    /// # Escribe en un fichero de salida
    /// @param fSalida es el nombre del fichero de salida
     /// @return no devuelve nada
    public void presentaAmigos(String fSalida) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(fSalida)){
            presentaAmigos(pw);
        }
    }

    /// # A cada socio le asocia un amigo para dar el regalo
    /// 1. Se crea una lista `posAmigos` de números enteros ordenados
    /// 1. Se baraja esa lista hasta que ninguna posición de la nueva lista coincida con la inicial
    /// 1. Usando esa nueva lista se le asocia un amigo a cada socio
    /// @return no devuelve nada
    protected void hacerAmigos() {
        List<Integer> posAmigos = new ArrayList<>(IntStream.range(0,socios.size())
                .boxed() // Convierto de int a integer
                .toList()); // Convierto a lista
        // Barajo la lista hasta que nigún índice quede en su posición inicial
        posAmigos = barajarLista(posAmigos);
        List<Persona> listaSocios = socios.stream().toList();
        for (int i = 0; i < posAmigos.size(); i++) {
            listaSocios.get(i).setAmigo(listaSocios.get(posAmigos.get(i)));
        }
    }

    /// # Baraja una lista hasta que no haya coincidencias con la lista inicial
    /// @param posAmigos es la lista que se baraja
     /// @return devuelve la lista barajada sin ninguna coincidencia
    private List<Integer> barajarLista(List<Integer> posAmigos) {
        do {
            Collections.shuffle(posAmigos);
        } while (hayCoincidencias(posAmigos));
        return posAmigos;
    }

    /// # Lee un fichero y lo desglosa según los delimitadores
    /// @param fEntrada es el nombre/ruta del fichero de entrada
     /// @param delim son los delimitadores usados para desglosar el fichero
     /// @return no devuelve nada
    public void lee(String fEntrada, String delim) throws IOException {
        for (String datosPersonas : Files.readAllLines(Path.of(fEntrada))) {
            leeSocios(datosPersonas, delim);
        }
    }

    /// # Desglosa cada linea del fichero palabra por palabra
    /// ## Añade esas palabras al conjunto `socios`
    /// @param linea es cada linea del fichero
     /// @param delim son los delimitadores usados para desglosar las líneas
     /// @return no devuelve nada
    private void leeSocios(String linea, String delim) {
        try (Scanner sc = new Scanner(linea)) {
            sc.useDelimiter(delim);
            while (sc.hasNext()){
                String nombre = sc.next();
                creaSocioDesdeString(nombre);
            }
        }
    }

    /// # Añade los nombres de los socios al conjunto `socios`
    /// @param nombre de cada socio
     /// @return no devuelve nada
    protected void creaSocioDesdeString(String nombre) {
        socios.add(new Persona(nombre));
    }

}
