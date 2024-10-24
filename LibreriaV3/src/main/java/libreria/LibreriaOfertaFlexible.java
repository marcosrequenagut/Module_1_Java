package libreria;

public class LibreriaOfertaFlexible extends Libreria{
    private OfertaFlex ofertaFlex;

    public LibreriaOfertaFlexible(OfertaFlex of) {
        ofertaFlex = of;
    }

    public void setOferta(OfertaFlex of) {
        ofertaFlex = of;
    }

    public OfertaFlex getOferta() {
        return ofertaFlex;
    }

    @Override
    public void addLibro(String autor, String titulo, double precioBase) {
        Libro libro = new Libro(autor, titulo, precioBase);
        // Para saber si tiene descuento, miro si me sale 0 o no el descuento
        // Además depende de la oferta que me den
        double descuento = ofertaFlex.getDescuento(libro); // Esta es la inyeccion
        if (descuento > 0) {
            libro = new LibroEnOferta(autor, titulo, precioBase, descuento);
        }
        addLibro(libro);
    }

    @Override
    public String toString() {
        return ofertaFlex + super.toString();
    }
}
