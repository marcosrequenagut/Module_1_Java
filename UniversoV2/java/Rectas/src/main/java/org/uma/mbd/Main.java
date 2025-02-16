package org.uma.mbd;
import rectas.Vector;
import rectas.Punto;

public class Main {
    public static void main(String[] args) {
        double distancia;
        Punto pto = new Punto(3,4);
        Punto pto2 = new Punto(0,0);
        Punto pto3 = new Punto(1,2);
        distancia = pto.distancia(pto2);
        System.out.println("Distancia = " + distancia);

        Vector v1 = new Vector(pto);
        Vector v2 = new Vector(pto3, pto);
        System.out.println("V1 = " + v1);
        System.out.println("V2 = " + v2);

        System.out.println(v1.extremoDesde(pto3));

        System.out.println("Modulo = " + v1.modulo());

        System.out.println("Vector unitario: " + v1.direccion());

        System.out.println("Vector suma: " + v1.sum(v2));

        System.out.println("Vector resta: " + v1.dif(v2));

        System.out.println(v1.extremo());

        System.out.println("¿Es paralelo v1 a v2?: " + v1.esParaleloA(v2));

        System.out.println("Vector ortogonal: " + v1.ortogonal());

        double m = 4;
        System.out.println("Multiplicacion por escalar: " + v1.escalar(1/m));

        System.out.println("Distancia entre p1 y p2: " + pto.distancia(pto2));
    }
}