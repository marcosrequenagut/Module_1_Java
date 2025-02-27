package libreria;

import java.util.ArrayList;
import java.util.Arrays;

/// @author Juan Marcos Requena
 /// @version 1.0

public class Libreria {
    private Libro[] libros; // Todavia no tengo ningun array esto es un gancho que me permite coger un array de libro
    private int num_Libros;
    private static final int TAM_DEFECTO = 16; // Es una constante final, se escriben en mayuscula en general

    /// Constructor de libros
    public Libreria() {
        this(TAM_DEFECTO); // Llama al de abajo y define un libro usando el de abajo con tamaño = TAM_DEFECTO
    }

    /// Constructir de libros con otro posible tamaño
    public Libreria(int tam){
        libros = new Libro[tam];
        num_Libros = 0;
    }

    public void addLibro(String titulo, String autor, double precioBase){
        Libro libro = new Libro(autor, titulo, precioBase);
        addLibro(libro);
    }

    private void addLibro(Libro libro){
        int pos = posicionLibro(libro.getAutor(), libro.getTitulo());
        if (pos < 0){
            // El libro no está, hay que añadirlo pero antes compruebo si la libreria está o no llena
            aseguraQueCabe();
            libros[num_Libros] = libro;
            num_Libros++;
        } else {
            libros[pos] = libro;
        }
    }

    /// Me devuelve en qué posición está el libro
    /// Si devuelve -1 es que no está

    private int posicionLibro(String autor, String titulo){
        int pos = 0;

        // Se coge un while porque el bucle puede que pare antes
        while (pos < num_Libros &&
                (!libros[pos].getTitulo().equalsIgnoreCase(titulo)
                 || !libros[pos].getAutor().equalsIgnoreCase(autor)))
                pos++;

        // Muy importante entenderlo este return operador ternario
        return (pos == num_Libros)? - 1 : pos; // Si es cierto lo de dentro enseña -1 y sino enseña pos
    }

    private void aseguraQueCabe(){
        if (num_Libros == libros.length){
            libros = Arrays.copyOf(libros, num_Libros*2); //Cojo el array libros y lo copio a otro arrray con longituf doble
        }
    }

    public double getPrecioBase(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        return (pos < 0)? 0 : libros[pos].getPrecioBase(); // pos<0? si lo es devuelve 0 sino devuelve lo otro
    }

    public double getPrecioFinal(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        return (pos < 0)? 0 : libros[pos].getPrecioFinal(); // pos<0? si lo es devuelve 0 sino devuelve lo otro
    }

    public void remLibro(String autor, String titulo){
        int pos =

    }
}