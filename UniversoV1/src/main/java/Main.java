import gui.PanelUniverso;
import universo.Particula;
import universo.Universo;
import rectas.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame app = new JFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelUniverso pu = new PanelUniverso();
        app.setContentPane(pu);
        app.setSize(1024,1024);
        app.setVisible(true);
        //ejemplo1(pu,7500,5);
        ejemplo2(pu,7500,10);
        //ejemplo3(pu,7500,3);
        //ejemplo4(pu,7500,1);
    }

    public static void ejemplo1(PanelUniverso pu, double dt, int sleep) {
        Particula[] parts = {
                new Particula(new Punto(0, 4.5e10), new Vector(1e4, 0), 1.5e30, 8e9)
                , new Particula(new Punto(0, -4.5e10), new Vector(-1e4, 0), 1.5e30, 8e9)
        };
        Universo un = new Universo(parts, 6E10);
        simula(pu,un,dt,sleep);
    }


    public static void ejemplo2(PanelUniverso pu, double dt, int sleep) {
        Particula[] parts = {
                new Particula(new Punto(0,4.5e10), new Vector(3e4,0), 2.999e30, 5e9)
                ,new Particula(new Punto(0,-4.5e10), new Vector(-3e4,0), 2.999e30, 5e9)
                ,new Particula(new Punto(0, 0), new Vector(0.05e4,0), 6.97e24, 2.5e9)
        };
        Universo un = new Universo(parts, 7E10);
        simula(pu,un,dt,sleep);
    }

    public static void ejemplo3(PanelUniverso pu, double dt, int sleep) {
        Particula[] parts = {
                new Particula(new Punto(-3.5e10, 0), new Vector(0,  1.4e3), 3e28, 5e9)
                ,new Particula(new Punto(  -1e10, 0), new Vector(0,  1.64e4), 3e28, 5e9)
                ,new Particula(new Punto(   1e10, 0), new Vector(0, -1.64e4), 3e28, 5e9)
                ,new Particula(new Punto( 3.5e10, 0), new Vector(0, -1.4e3), 3e28, 5e9)
        };
        Universo un = new Universo(parts, 6E10);
        simula(pu,un,dt,sleep);
    }


    public static void ejemplo4(PanelUniverso pu, double dt, int sleep) {
        Particula[] parts = {
                new Particula(new Punto(-3.5e10, 0), new Vector(0,  1.4e3),  3e28, 5e9)
                ,new Particula(new Punto(  -1e10, 0), new Vector(0,  1.645e4), 3e28, 5e9)
                ,new Particula(new Punto(   1e10, 0), new Vector(0, -1.645e4), 3e28, 5e9)
                ,new Particula(new Punto( 3.5e10, 0), new Vector(0, -1.4e3),  3e28, 5e9)
        };
        Universo un = new Universo(parts, 6E10);
        simula(pu,un,dt,sleep);
    }

    public static void simula(PanelUniverso pu, Universo un, double dt, int sleep) {
        while(true) {
            un.avanza(dt);
            pu.pinta(un.particulas(), un.radio());
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
