package org.uma.mbd;

import jarras.Jarra;
import jarras.Mesa;

public class Main{
    public static void main(String[] args) {
        Jarra j1 = new Jarra(0, 5);
        Jarra j2 = new Jarra(0,7);
        j1.vacia();
        j2.llena();
        System.out.println("Jarra 1: " + j1);
        System.out.println("Jarra 2: " + j2);
        j1.llenaDesde(j2);
        System.out.println("\nJarra 1: " + j1);
        System.out.println("Jarra 2: " + j2);
        j1.vacia();
        j1.llenaDesde(j2);
        System.out.println("\nJarra 1: " + j1);
        System.out.println("Jarra 2: " + j2);
        j2.llena();
        System.out.println("\nJarra 1: " + j1);
        System.out.println("Jarra 2: " + j2);
        j1.llenaDesde(j2);
        System.out.println("\nJarra 1: " + j1);
        System.out.println("Jarra 2: " + j2);
        j1.vacia();
        j1.llenaDesde(j2);
        System.out.println("\nJarra 1: " + j1);
        System.out.println("Jarra 2: " + j2);
        j2.llena();
        System.out.println("\nJarra 1: " + j1);
        System.out.println("Jarra 2: " + j2);
        j1.llenaDesde(j2);
        System.out.println("\nJarra 1: " + j1);
        System.out.println("Jarra 2: " + j2);
        j1.vacia();
        System.out.println("\nJarra 1: " + j1);
        System.out.println("Jarra 2: " + j2);
        j1.llenaDesde(j2);
        System.out.println("\nJarra 1: " + j1);
        System.out.println("Jarra 2: " + j2);

        Jarra jm1 = new Jarra(0,5);
        Jarra jm2 = new Jarra(0,7);
        Mesa mesa = new Mesa(jm1,jm2);
        System.out.println("\n" + mesa);

        // Llena la jarra izq desde la der
        mesa.llenaDesde(Mesa.Posicion.Derecha);
        System.out.println(mesa);

        mesa.vacia(Mesa.Posicion.Izquierda);
        System.out.println(mesa);

        mesa.llenaDesde(Mesa.Posicion.Derecha);
        System.out.println(mesa);

        mesa.llena(Mesa.Posicion.Derecha);
        System.out.println(mesa);

        mesa.llenaDesde(Mesa.Posicion.Derecha);
        System.out.println(mesa);

        mesa.vacia(Mesa.Posicion.Izquierda);
        mesa.llenaDesde(Mesa.Posicion.Derecha);
        System.out.println(mesa);

        mesa.llenaDesde(Mesa.Posicion.Derecha);
        System.out.println(mesa);

        System.out.println("Programa acabado ya que el contenido de la jarra derecha es de 1");

    }
}