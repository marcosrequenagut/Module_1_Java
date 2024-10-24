package libreria;

public class OfertaPrecio implements OfertaFlex{

    private double porDescuento;
    private double umbralPrecio;

    // Le doy valor a los atributos en el constructor
    // Les doy valores a las variables de instancia porque luego me van a hacer falta
    // saber los valores en el detDescuento
    public OfertaPrecio(double pd, double up) {
        porDescuento = pd;
        umbralPrecio = up;
    }

    /// Si el precio es mayor que el umbral tiene descuento si no, no.
    public double getDescuento(Libro libro) {
        return libro.getPrecioBase() >= umbralPrecio? porDescuento : 0;
    }

    @Override
    public String toString () {
        return porDescuento + "%(" + umbralPrecio + ")";
    }
}
