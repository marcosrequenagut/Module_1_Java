package rectas;

import java.util.Optional;

public record Recta(Vector director, Punto pto) {

    public Recta(Vector director, Punto pto){
        this.director = director;
        this.pto = pto;
    }

    /// Tengo mis dudas aqui, creo que tengo que desplazar la recta de alguna manera
    public Recta(Punto pto1, Punto pto2){
        this(new Vector(pto1,pto2).direccion(), pto1);
    }

    public boolean esParalelaA(Recta recta1) {
        if (this.director.esParaleloA(recta1.director)) {
            return true;
        } else
            return false;
    }

    public Recta paralelaPor (Punto pto1) {
        Vector vector = new Vector(pto, pto1);
        return new Recta(vector.direccion(), pto1);
    }

    public Recta perpendicularPor(Punto pto1){
        Recta r = new Recta(director, pto);
        Vector vector_ortogonal = director.ortogonal();
        return new Recta(vector_ortogonal, pto1);
    }

    public double distanciaDesde (Punto pto1) {
        Recta r = new Recta(director, pto);
        Recta recta_perpendicular = r.perpendicularPor(pto1);
        Optional<Punto> punto_interseccion = r.interseccionCon(recta_perpendicular);

        // Si no hay intersección, lanzar una excepción o retornar un valor por defecto
        Punto punto = punto_interseccion.orElseThrow(() ->
                new IllegalArgumentException("No hay intersección entre las rectas"));
        return pto1.distancia(punto);
    }

    public boolean contieneA(Punto pto1) {
        Recta r = new Recta(director, pto);
        Vector vector1 = new Vector(pto, pto1);

        // Si el vector formado por pto1 y pto es proporcional al vector director de mi recta, significa que
        // el punto está en la recra
        return vector1.direccion() == director;
    }

    public Optional<Punto> interseccionCon(Recta r) {

        // Si son paralelas devuelvo Null con .empty(), es un método de Optional<>
        if (this.esParalelaA(r)) {
            return Optional.empty();
        }

        double a = this.Implicita().a();
        double b = this.Implicita().b();
        double c = this.Implicita().c();

        double a_r =  r.Implicita().a();;
        double b_r = r.Implicita().b();
        double c_r = r.Implicita().c();

        // Calcular el determinante para asegurarse de que no sea cero
        double determinantePrincipal = determinante(a, b, a_r, b_r);
        if (determinantePrincipal == 0) {
            return Optional.empty();  // Si el determinante es cero, las rectas son paralelas o coincidentes
        }

        return Optional.of(new Punto(determinante(-c, b, -c_r, b_r) / determinante(a, b, a_r, b_r),
                determinante(a, -c, a_r, -c_r) / determinante(a, b, a_r, b_r)));
    }

    public Implicita Implicita(){
        double a = director.y();
        double b = -director.x();
        double c = -(a * pto.x() + b * pto.y());

        return new Implicita(a,b,c);
    }
    private double determinante(double a11, double a12, double a21, double a22){
        return (a11*a22-a12*a21);
    }
}
