package libreria;

/// LibroEnOferta es subclase de Libro
public class LibroEnOferta extends Libro{
    private double porDescuento;

    public LibroEnOferta(String au, String ti, double pb, double pd){
        //  Lo 1 que hay que hacer es llamar al constructor de la clase padre.
        // Los constructores super() tienen que tener distintos nombres o tipos de argumentos
        super(au,ti,pb);
        // Queda guardarme el pd
        porDescuento = pd;
    }

    public double getDescuento(){
        return porDescuento;
    }

    @Override
    public double getPrecioFinal(){
        double pf = super.getPrecioFinal(); // Calculo el precio final como si fuera un libro, uso el
        // super. para acceder al método del padre.
        return pf - pf * porDescuento/100;
    }

    @Override
    public String toString(){
        // Ppodría poner super.getAutor, si no pongo super por vinculacion dinamica lo buscara en LibroEnOferta pero
        // como no está ps coje el del padre
        // Tal como está el enunciado no podemos poner el iva, lo que podemos hacer es poner el iva como protected
        // Con el protected solo el hijo tiene acceso al IVA, es como si fuera una variable del hijo tbm.
        return "(" + getAutor() + ";"
                + getTitulo() + ";"
                + getPrecioFinal() + ";"
                + porDescuento + "%;"
                + (getPrecioBase()*porDescuento/100)
                + IVA + "%;"
                + getPrecioFinal() + ")";
    }
}
