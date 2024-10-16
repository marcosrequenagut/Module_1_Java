package jarras;

public class Mesa {

    // Anidar la clase enum Posicion dentro de Mesa
    public enum Posicion {
        Izquierda,
        Derecha
    }

    // Atributos de la clase Mesa
    private Jarra jarraIzq;
    private Jarra jarraDer;

    public Mesa(Jarra jarraIzq, Jarra jarraDer) {
        this.jarraIzq = jarraIzq;  // Usar directamente la referencia de la jarra izquierda
        this.jarraDer = jarraDer;  // Usar directamente la referencia de la jarra derecha
    }

    // Métodos de la clase Mesa
    public int capacidad(Posicion pos) {
        if (pos == Posicion.Izquierda) {
            return jarraIzq.getCapacidad();
        } else {
            return jarraDer.getCapacidad();
        }
    }

    // Constructor que inicializa las jarras con capacidad y contenido inicial en caso de que no se haga manualmente
    public int contenido(Posicion pos) {
        if (pos == Posicion.Izquierda) {
            return jarraIzq.getContenido();
        } else {
            return jarraDer.getContenido();
        }
    }

    public void llena(Posicion pos) {
        if (pos == Posicion.Izquierda) {
            jarraIzq.llena();
        } else {
            jarraDer.llena();
        }
    }

    public void vacia(Posicion pos) {
        if (pos == Posicion.Izquierda) {
            jarraIzq.vacia();
        } else {
            jarraDer.vacia();
        }
    }

    public void llenaDesde(Posicion emisor) {
        if (emisor == Posicion.Izquierda) {
            jarraDer.llenaDesde(jarraIzq);
        } else {
            jarraIzq.llenaDesde(jarraDer);
        }
    }

    // Sobrescribir el método toString para mostrar las capacidades y contenidos de las jarras
    @Override
    public String toString() {
        return "M(" + jarraIzq.getCapacidad() + "," + jarraIzq.getContenido() + ")(" + jarraDer.getCapacidad() + "," + jarraDer.getContenido() + ")";
    }
}