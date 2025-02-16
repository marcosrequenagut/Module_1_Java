package rectas;

// Esto es todo lo que necesito del vector, el extremo
// Porque suponemos que ya almacena el vector origen de coordenadas porque es un record
/// Crea un vector conociendo el punto extremo, el origen será el de coordenadas
/// @param extremo es el punto extremo
public record Vector(Punto extremo) {

    private static final double EPSILON = 0.000001;

    /// Crea un vector conocidas sus dos componentes
    /// @param x es la ordenada
    /// @param y es la abscisa
    public Vector (double x, double y){
        this(new Punto(x, y)); // Creamos el punto y llamamos al constructor principal con el punto ya construido
    }

    /// Crea un vector sabiendo un punto origen y un punto extremo
    /// @param origen es el punto origen
    /// @param extremo es el punto extremo
    public Vector (Punto origen, Punto extremo){
        this(extremo.x() - origen.x(), extremo.y() - origen.y()); // El this llama al constructor justo de arriba,
        // cuando el constructor se encuentra con los puntos llama al constructor principal, al record
    }

    /// Traslada el vector al punto org, haciendo que el origen pase a ser el punto org
    /// Solo sirve para vectores iniciales cuyo origen sea el origen de coordenadas
    /// He sacado una fórmula general para cualquier vector pero no la puedo usar porque necesito el
    /// origen del vector receptor y me parece que no lo tengo solo tengo el extremo por culpa del record(extremo),
    /// se supone que todo origen es el de coordenadas
    /// @param org es el nuevo origen del vector
    /// @return extremo_nuevo es un punto que muestra la nueva posición del punto extremo del vector
    public Punto extremoDesde(Punto org){
        double coord_x = extremo.x();
        double coord_y = extremo.y();
        Punto extremo_nuevo = new Punto(coord_x + org.x(), coord_y + org.y());

        return extremo_nuevo ;
    }

    /// Calcula el módulo del vector
    /// @return extremo().distancia(extremo) es el modulo del vector
    public double modulo(){
        return extremo().distancia(new Punto(0,0));
    }

    /// Calcula un vector unitario con la misma dirección y sentido que el receptor
    /// @return direccion es el vector unitario que devuelve
    public Vector direccion(){
        Punto org = new Punto(0,0); // Creo que no hace falta porque record ya lo inicializa pero no se como
        // pasalo como variable
        if (modulo() == 0){
            throw new RuntimeException("El modulo del vector es 0");
        }
        Punto extremo_direccion = new Punto(extremo.x()/modulo(), extremo.y()/modulo());
        Vector direccion = new Vector(org, extremo_direccion);
        return direccion;
    }

    /// Calcula la suma del vector receptor con un vector dado
    /// @return new Vector(new Punto(nuevo_x, nuevo_y)) es el nuevo vector suma
    public Vector sum(Vector vector){
        double vector_extremo_x = vector.extremo.x();
        double vector_extremo_y = vector.extremo.y();
        double nuevo_x = vector_extremo_x + extremo.x();
        double nuevo_y = vector_extremo_y + extremo.y();

        return new Vector(new Punto(nuevo_x, nuevo_y));
    }

    /// Calcula la diferencia del vector receptor con un vector dado
    /// @return new Vector(new Punto(nuevo_x, nuevo_y)) es el nuevo vector diferencia
    public Vector dif(Vector vector){
        double vector_extremo_x = vector.extremo.x();
        double vector_extremo_y = vector.extremo.y();
        double nuevo_x = extremo.x() - vector_extremo_x;
        double nuevo_y = extremo.y() - vector_extremo_y;

        return new Vector(new Punto(nuevo_x, nuevo_y));
    }

    public Punto extremo(){
        return extremo;
    }

    public double x(){
        return extremo.x();
    }

    public double y(){
        return extremo.y();
    }

    /// Comprueba si dos vectores son paralelos
    /// @return (dy >= dx - EPSILON && dy <= dx + EPSILON) es `True` si se cumple la condición y `False` si no se cumple
    public boolean esParaleloA(Vector vector){
        double dx = extremo.x() / vector.extremo.x();
        double dy = extremo.y() / vector.extremo.y();

        return (dy >= dx - EPSILON && dy <= dx + EPSILON);
    }

    /// Calcula el vector ortogonal
    /// @returnnew Vector(-extremo.y(), extremo.x()) es el nuevo vector ortogonal
    public Vector ortogonal(){
        return new Vector(-extremo.y(), extremo.x());
    }

    /// Calculo el producto de un escalar por el vector
    /// @return new Vector(new Punto(extremo.x() * escalar,extremo.y() * escalar)) es el nuevo vector
    public Vector escalar (double escalar){
        return new Vector(new Punto(extremo.x() * escalar,extremo.y() * escalar));
    }

    @Override
    public String toString(){
        return "(" + extremo.x() + " , " + extremo.y() + ")";
    }

}
