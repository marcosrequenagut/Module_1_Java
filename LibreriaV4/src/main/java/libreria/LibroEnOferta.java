package libreria;

public class LibroEnOferta extends Libro {
    private double porDescuento;

    /// Crea un libro en oferta
    /// @param au autor
     /// @param ti titulo
     /// @param pb precio base
     /// @param pd porcentaje de descuento
    public LibroEnOferta(String au, String ti, double pb, double pd) {
        super(au,ti,pb);
        porDescuento = pd;
    }

    /// @return porcentaje de descuento
    public double getDescuento() {
        return porDescuento;
    }

    /// Redefinición del precio total
    /// @return  precio total con descuentos
    @Override
    public double getPrecioFinal() {
        double pf = super.getPrecioFinal();
        return pf - pf * porDescuento/100;
    }

    @Override
    public String toString() {
        return "(" + getAutor()+";"
                + getTitulo()+";"
                + getPrecioBase()+";"
                + porDescuento + "%;"
                + (getPrecioBase()*porDescuento/100) + ";"
                + IVA +"%;"
                + getPrecioFinal() + ")";
    }
}
