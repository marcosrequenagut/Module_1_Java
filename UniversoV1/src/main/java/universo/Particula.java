package universo;
import rectas.*; // Añado las clases del paquete rectas, del proyecto Rectas

public class Particula {
    /// Atributos de la clase
    private double masa;
    private double radio; // Creo que es el radio al centro del universo
    private Vector velocidad;
    private Punto posicion;

    /// # Constructor de la clase
    /// @param p es la posición de la partícula
     /// @param v es el vector velocidad de la partícula
     /// @param m es la masa de la partícula
     /// @param r es el radio de la partícula
    public Particula(Punto p, Vector v, double m, double r) {
        posicion = p;
        velocidad = v;
        masa = m;
        radio = r;
    }

    /// # Calcula el movimiento de una particula cada instante de tiempo`dt`
    /// @param vz es una fuerza que se aplica a una partícula
     /// @param dt es el tiempo que se le aplica esa fuerza `vz`
     /// @return no devuelve nada
    public void mueve(Vector vz, double dt) {
        // Cálculo de la aceleración
        Vector aceleracion = vz.escalar(1/masa);

        // Cálculo de la velocidad final
        Vector velFinal = velocidad.sum(aceleracion.escalar(dt));

        // Cálculo de la poscion final
        Vector desplazamiento = velocidad.escalar(dt);
        double xFinal = posicion.x() + desplazamiento.x();
        double yFinal = posicion.y() + desplazamiento.y();
        Punto posFinal = new Punto(xFinal, yFinal);

        // Actualizo la posición y la velocidad
        this.posicion = posFinal;
        this.velocidad = velFinal;
    }

    /// # Devuelve el radio de la partícula
    /// @return `radio`
    public double radio() {
        return radio;
    }

    /// # Caclula la fuerza de atracción gravitatoria entre dos partículas
    /// @param part es la partícula emisora que hace fuerza sobre la receptora
    public Vector fuerzaDesde(Particula part) {
        double G = 6.67E-11;
        double distancia = posicion.distancia(part.posicion());
        //double distancia = this.radio - part.radio();

        Vector vector = new Vector(posicion, part.posicion());
        Vector director = vector.direccion();
        double numeroEscalar = (G * this.masa * part.masa) / Math.pow(distancia,2);

        Vector fuerza = director.escalar(numeroEscalar);
        return fuerza;
    }

    /// # Devuelve la posición de la partícula
    public Punto posicion() {
        return posicion;
    }

    /// # Representa convenientemente las caracterísitcas de una partícula
    @Override
    public String toString() {
        return "Particula{" +
                "masa : " + masa +
                ", radio : " + radio +
                ", velocidad : " + velocidad +
                ", posicion : " + posicion +
                '}';
    }
}
