package libreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria {
    private String [] autores;
    private double porDescuento;

    /// Crea una libreria en oferta
    /// @param pd porcentaje de descuento
    /// @param aeo array de nombre de autores en oferta
    public LibreriaOferta(double pd, String [] aeo) {
        super(); // es opcional
        porDescuento = pd;
        autores = aeo;
    }

    /// Cambia el porcentaje de descuento y los autorres en oferta
    /// @param pd nuevo porcentaje de descuento
    /// @param aeo nuevo array de autores
    public void setOferta(double pd, String [] aeo) {
        porDescuento = pd;
        autores = aeo;
    }

    /// @ return array de autores en oferta
    public String [] getOferta() {
        return autores;
    }

    /// @return porcentaje de decuento
    public double getDescuento() {
        return porDescuento;
    }

    /// Añade un libro a la biblioteca
    /// - Si es de un autor en oferta añade un libro en oferta
    /// - En otro caso, añade un libro
    /// @see Libreria#addLibro
    @Override
    public void addLibro(String autor, String titulo, double precioBase) {
        Libro libro = null;
        if (esAutorEnOferta(autor))
            libro = new LibroEnOferta(autor, titulo, precioBase, porDescuento);
        else
            libro = new Libro(autor, titulo, precioBase);
        addLibro(libro);
    }

    /// Determina si el autor está en oferta
    /// @return true si el autr esta en el array de autores en oferta
    private boolean esAutorEnOferta(String autor) {
        int pos = 0;
        while (pos < autores.length
                && !autores[pos].equalsIgnoreCase(autor))
            pos++;
        return pos < autores.length;
    }

    @Override
    public String toString() {
        return porDescuento + "%" + Arrays.toString(autores)+
                super.toString();
    }
}
