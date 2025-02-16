package amigos;

import java.util.*;
import java.util.stream.IntStream;

public class ClubParejas extends Club{
    /// # Atributos de la clase
    private Set<Pareja> parejas;

    /// # Constructor que incializa los atributos
    public ClubParejas() {
        parejas = new HashSet<>();
    }

    /// # Añade los socios y las parejas a sus respectivos arrays
    /// 1. Los nombres pueden venir o no separados por guiones
    /// 1. Los nombres con guiones se guardan en una variable nueva denominada parejas
    /// 1. Si me un string: nombre1-nombre2, los tengo que separar para crear la pareja
    /// @param nombre es el nombre de cada socio, o puede ser el string de una pareja qeu contiene dos o más nombres separados por un guión
     /// @return no devuelve nada
    @Override
    protected void creaSocioDesdeString(String nombre) {
        if (nombre.contains("-")){
            List<Persona> personaPareja = new ArrayList<>();
            try (Scanner sc = new Scanner(nombre)) {
                sc.useDelimiter("\\-");
                while (sc.hasNext()){
                    String nombre1 = sc.next();
                    socios.add(new Persona(nombre1));
                    personaPareja.add(new Persona(nombre1));
                }
            }
            // Creo todas las posibles parejas teniendo en cuenta que a-b es igual a b-a
            for (int i = 0; i < personaPareja.size(); i++){
                for (int j = i + 1; j < personaPareja.size(); j++) {
                    parejas.add(new Pareja(personaPareja.get(i),personaPareja.get(j)));
                }
            }
        } else
            socios.add(new Persona(nombre));
    }

    /// # A cada socio le asocia un amigo para dar el regalo
    /// 1. Se crea una lista `posAmigos` de números enteros ordenados
    /// 1. Se baraja esa lista hasta que ninguna posición de la nueva lista coincida con la inicial
    /// 1. Usando esa nueva lista se le asocia un amigo a cada socio
    /// 1. Se tiene en cuenta que los individuos que formen parejas no pueden regalarse entre sí
    /// 1. Si al barajar la lista coincide que un individuo es amigo de su pareja, se repite todo el procedimiento de nuevo
    /// @return no devuelve nada
    @Override
    protected void hacerAmigos() {
        boolean condicion = false;
        do {
            List<Integer> posAmigos = new ArrayList<>(IntStream.range(0, socios.size())
                    .boxed() // Convierto de int a integer
                    .toList()); // Convierto a lista
            // Barajo la lista hasta que nigún índice quede en su posición inicial
            posAmigos = barajarLista(posAmigos);
            List<Persona> listaSocios = socios.stream().toList();
            for (int i = 0; i < posAmigos.size(); i++) {
                // Comparo si nombre1 y amigo1 son pareja
                Persona nombre1 = listaSocios.get(i);
                Persona amigo1 = listaSocios.get(posAmigos.get(i));
                if (parejas.contains(new Pareja(nombre1, amigo1))) {
                    condicion = false;
                } else {
                    listaSocios.get(i).setAmigo(listaSocios.get(posAmigos.get(i)));
                    condicion = true;
                }
            }
        } while (!condicion);
    }

    /// # Baraja una lista hasta que ninguna posición coincida con la lista inicial
    /// @param posAmigos es la lista que se baraja
     /// @return devuelve la lista barajada sin ninguna coincidencia
    private List<Integer> barajarLista(List<Integer> posAmigos) {
        do {
            Collections.shuffle(posAmigos);
        } while (hayCoincidencias(posAmigos));
        return posAmigos;
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
}
