package universo;
import rectas.*;

/// # Define las características de Universo
/// @param particulas es el array de particulas que conforman el universo
 /// @param radio es el radio del universo
public record Universo(Particula[] particulas, double radio) {

    /// # Simula la modificación de las posiciones y de las velocidades de la partículas tras un tiempo `dt`
    /// @param dt es el tiempo que transcurre entre modificación
    /// @return no devuelve nada
    public void avanza(double dt){
        Vector[] vectorFuerza = new Vector[particulas.length];
        // Inicializo el array de vectores
        for (int i = 0; i < particulas.length; i++) {
            vectorFuerza[i] = new Vector(0, 0);
        }

        for (int i = 0; i < particulas.length; i++) {
            for (int j = 0; j < particulas.length; j++) {
                if (i != j) {
                    vectorFuerza[i] = vectorFuerza[i].sum(particulas[i].fuerzaDesde(particulas[j]));
                }
            }
            // Cuando ya he calculado la fuerza que se ejerce en la partícula 'i' por todas
            // las demás partículas, ahora si que puedo moverla, teniendo en cuenta
            // esa suma de fuerzas y el tiempo que la quiero mover dt
            particulas[i].mueve(vectorFuerza[i],dt);
        }
    }
}
