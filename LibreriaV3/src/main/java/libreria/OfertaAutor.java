package libreria;

public class OfertaAutor implements  OfertaFlex{

    private double porDescuento;
    private String [] autores;
    public OfertaAutor(){}

    // Estoy obligado a  redefinir el getDescuento que es lo que me OBLIGA a poder ser implementado
    // por la clase OfertaFlex


    @Override
    public double getDescuento(Libro libro) {
        String  autor = libro.getAutor();
        int pos = 0;
        // IgnoreCase es para no distinguir entre may o minusculas
        // Minetras el autor de esa pos no coincide con el autor que he sacado del libro, sigue aumentando pos
        // Si no enontramos el autor, pos llegara hasta el final y pos = autores.lenght
        while (pos < autores.length
                && !autores[pos].equalsIgnoreCase(autor)){
            pos++;
        }
        // Si es menor he encontrado el autor entonces devuelve el descuento
        // Si no está no tiene descuento entonces devuelve 0
        return pos < autores.length ? porDescuento : 0;
    }

    @Override
    public String toString() {
        // Podria hacer String salida = Double.toString(porDescuento);
        String salida = porDescuento + "%["; // Al meterle el + "%" se convierte autom. en String
        for (int pos = 0; pos < autores.length; pos ++) {
            salida += autores[pos];
            if (pos < autores.length -1)
                salida += ";";
        }
        return salida + "]";

        // Si no hubieran los ; podríamos haber hecho :
        /*
        return posDescuento + "%" + Arra.toString(autores)
         */
    }
}
