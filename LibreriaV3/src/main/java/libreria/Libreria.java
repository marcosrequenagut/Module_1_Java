package libreria;

import java.util.ArrayList;
import java.util.List;

/// @author Juan Marcos Requena
 /// @version 2.0

public class Libreria {
    private List<Libro> libros; // Todavia no tengo ningun array esto es un gancho que me permite coger un array de libro

    /// Crea una libreria.
    public Libreria(){
        libros = new ArrayList<Libro>();
    }

    /// Agrega un libro a la libreria
    public void addLibro(String autor, String titulo, double precioBase){
        Libro libro = new Libro(autor, titulo, precioBase);
        addLibro(libro);
    }

    /// Agrega un libro a la lista de libros
    /// - Si ya está se sustituye.
    /// - Si no está se añade
    /// @param libro a agregar
    protected void addLibro(Libro libro){
        int pos = posicionLibro(libro.getAutor(), libro.getTitulo());
        if (pos < 0){
            libros.add(libro);
        } else { // El libro está.
            libros.set(pos,libro); // Cambio el libro que hay en esa posición por `libro`.
        }
    }

    /// Localiza la posición de un libro con `autor`
    /// Me devuelve en qué posición está el libro
    /// Si devuelve -1 es que no está
    /// @return  la posición del libro en el array
    private int posicionLibro(String autor, String titulo){
        int pos = 0;

        // Se coge un while porque el bucle puede que pare antes
        while (pos < libros.size() &&
                (!libros.get(pos).getTitulo().equalsIgnoreCase(titulo) // libors.get(pos): me da el libro que está en esa posición.
                        || !libros.get(pos).getAutor().equalsIgnoreCase(autor)))
            pos++;

        // Muy importante entenderlo este return operador ternario
        return (pos == libros.size())? - 1 : pos; // Si es cierto lo de dentro enseña -1 y sino enseña pos
    }

    /// Calcula el precio de base de un libro conocido `autor`
    public double getPrecioBase(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        return (pos < 0)? 0 : libros.get(pos).getPrecioBase(); // pos<0? si lo es devuelve 0 sino devuelve lo otro
    }

    /// Calcula el precio de base de un libro conocido `autor`
    ///
    public double getPrecioFinal(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        return (pos < 0)? 0 : libros.get(pos).getPrecioFinal(); // pos<0? si lo es devuelve 0 sino devuelve lo otro
    }

    /// Elimina un libro de la librería conocido `autor` y `titulo.
    /// Se debe mantener el orden de los libros.
    /// @param autor del libro
     /// @param titulo del libro
    public void remLibro(String autor, String titulo){
        int pos = posicionLibro(autor, titulo);
        if (pos >= 0)  // El libro está
            libros.remove(pos);
    }

    @Override
    public String  toString(){
        return libros.toString();
    }
}