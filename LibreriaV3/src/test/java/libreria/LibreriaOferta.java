package libreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria{
    /// Variables de estancia
    private String[] autores;
    private double porDescuento;

    /// @param pd es el porcentaje de descuento
    /// @param aeo son los autores en oferta
    public LibreriaOferta(double pd, String [] aeo){
        super(); // Es opcional.
        // Si no llamo al constructor Padre es como si lo llamara pero sin argumentos super().
        porDescuento = pd;
        autores = aeo;
    }

    /// Permite cambiar la oferta
    public void setOferta(double pd, String [] aeo){
        porDescuento = pd;
        autores = aeo;
    }

    public String [] getOferta(){
        return autores;
    }

    public double getDescuento(){
        return porDescuento;
    }

    /// Redefinición del método de librería
    @Override
    public void addLibro(String autor, String titulo, double precioBase){
        // No hay problema si le doy un libro o un libro en oferta por el polimorfismo
        Libro libro = null;
        if (esAutorEnOferta(autor)){
            libro = new LibroEnOferta(autor, titulo, precioBase, porDescuento);
            // Añado el libro, para ello cambio el método addLibro como protected para poder acceder a él.
        } else
            libro = new Libro(autor, titulo, precioBase);
        addLibro(libro);
    }

    private boolean esAutorEnOferta(String autor){
        int pos = 0;

        // Me muevo mientras pos < autores.length y mientras el autor no coincida con el autor que me han dado
        // Seguiré hasta que llegue al final o hasta que coincida.
        while(pos < autores.length && !autores[pos].equalsIgnoreCase(autor))
            pos++;

        // Si la posicion es menor es que SI se ha salido antes de llegar al final, es porque el autor que me han dado
        // coincide con el que esta en descuento en el array de autores. Luego hay autor en oferta
        return pos < autores.length;
    }

    @Override
    public String toString(){
        // El metodo Arrays.toString me pone el array bonito
        // Añado la lista , que es el toString de la clase padre. El padre muestra un string con la lista de libros.
        return porDescuento + "%" + Arrays.toString(autores)
                + super.toString();
    }

}
