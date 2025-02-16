package universo;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

///Ejercicio Challenge UniversoV2
/// @author   David Ortiz, Juan Marcos Requena, Juan Manuel Burgueño, Silvia Aguirre
/// @version 1.0


/// Lee los datos del fichero
/// Crea un universo a partir de los datos recogidos en las primeras 4 líneas y de las partículas formadas con los demás datos del fichero

/// @param universo compuesto por un array de partículas y el radio del universo
/// @param dt es el delta de tiempo de cada animación
/// @param sleep es el lapsus de tiempo que se mantiene una animación en pantalla
/// @return devuelve un objeto de tipo DatosUniverso

public record DatosUniverso(Universo universo, double dt, int sleep) {
    public static DatosUniverso leeDatos(String s) throws IOException {
        try (Scanner scanner = new Scanner(Path.of(s))) {

            int numeroParticulas = Integer.parseInt(scanner.next()); //Para leer los datos numéricos sin importar que los decimales sean con , o con .
            double radioUniverso = Double.parseDouble(scanner.next());
            double incrementoTiempo = Double.parseDouble(scanner.next());
            int tiempoAnimaciones = Integer.parseInt(scanner.next());

            // Crea una lista en la que se almacenarán particulas al crearlas
            List<Particula> particulas = new ArrayList<>();

            for (int i = 0; i < numeroParticulas; i++) {
                try {
                    double posX = Double.parseDouble(scanner.next());
                    double posY = Double.parseDouble(scanner.next());
                    double vecX = Double.parseDouble(scanner.next());
                    double vecY = Double.parseDouble(scanner.next());
                    double masa = Double.parseDouble(scanner.next());
                    double radio = Double.parseDouble(scanner.next());

                    rectas.Punto posicion = new rectas.Punto(posX, posY);
                    rectas.Vector velocidad = new rectas.Vector(vecX, vecY);
                    Particula particula = new Particula(posicion, velocidad, masa, radio);
                    particulas.add(particula); //Añade la particula a la lista
                } catch (InputMismatchException e) {
                    System.err.printf("Error al leer los datos de la partícula %d\n", i + 1);
                    System.err.println("Error: "+e);
                }
            }
            Particula[] particulasArray = particulas.toArray(new Particula[0]); //Devuelve un array que se ajusta automáticamente al tamaño actual de la lista particulas
            // Convierte la lista en array para poder pasarselo como argumento a universo
            Universo universo = new Universo(particulasArray, radioUniverso);
            return new DatosUniverso(universo, incrementoTiempo, tiempoAnimaciones);
        }
    }
}
