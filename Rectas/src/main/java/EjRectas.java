import rectas.*;

import java.util.Optional;

public class EjRectas {
    public static void main(String[] args) {

        //Punto p1 = new Punto(0,0);
        //Punto p2 = new Punto(8,0);
        //Punto p3 = new Punto(4,6);
        //Punto p4 = new Punto(4,0);

        Punto p1 = new Punto(-1.14, -0.95);
        Punto p2 = new Punto(12.78, 3.95);
        Punto p3 = new Punto(1.54, 5.19);
        Punto p4 = new Punto(13.96, 0.33);


        double altura = p4.distancia(p3);
        double base = p1.distancia(p2);
        double area = base * altura / 2;

        System.out.println("Area: " + area);

        Recta r1_2 = new Recta(p1,p2);
        Recta r1_3 = new Recta(p3,p4);

        Optional<Punto> interseccion = r1_2.interseccionCon(r1_3);
        System.out.println("Interseccion en el punto: " + interseccion);
        System.out.println("Vector director: " + r1_3.director());
    }
}
