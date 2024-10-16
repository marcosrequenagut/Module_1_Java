package libreria;
/// @author Juan Marcos Requena
/// @version 1.0
public class Libro {
    private String titulo;
    private String autor;
    private double precioBase;
    private static double IVA = 10; // Lo pongo static porque es el mismo siempre

    /// Crea un libro
    /// @param au autor
    /// @param ti titulo
    /// @param pb precio base

    public Libro(String au, String ti, double pb){
        autor = au;
        titulo = ti;
        precioBase = pb;
    }

    // Estas cosas tan simples no hace falta comentarlas
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    /// Calcula el precio con IVA
    public double getPrecioFinal(){
        return precioBase + precioBase*IVA/100;
    }
    @Override
    public String toString(){
        return "(" + autor + ";" + titulo + ";" + precioBase +
                ";" + IVA + ";" + getPrecioFinal() + ")";
    }
}

