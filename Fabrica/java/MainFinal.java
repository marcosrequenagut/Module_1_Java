import fabrica.*;
import fabrica.maquinas.Taladradora;
import fabrica.posiciones.*;
import gui.Gui;
import fabrica.Fabrica;
import fabrica.maquinas.Fresadora;
import fabrica.maquinas.Rotadora;
import fabrica.maquinas.Lijadora;

public class MainFinal {
    public static void main(String[] args) {
        //Crear la fabrica (vacía, sin maquinas)
        Fabrica f = new Fabrica();
        //Agregar todas las maquinas que se quieran a f (la fabrica)
        f.agrega(new Fresadora(Posicion.IzIn, OrFresa.Diagonal, Grosor.Grueso));
        f.agrega(new Rotadora(Sentido.Horario));
        f.agrega(new Taladradora(Posicion.IzSu,Grosor.Grueso));
        f.agrega(new Fresadora(Posicion.IzSu, OrFresa.Horizontal, Grosor.Medio));
        f.agrega(new Taladradora(Posicion.CeSu,Grosor.Medio));
        f.agrega(new Fresadora(Posicion.CeSu, OrFresa.Horizontal, Grosor.Medio));
        f.agrega(new Taladradora(Posicion.CeCe,Grosor.Grueso));
        f.agrega(new Rotadora(Sentido.Horario));
        f.agrega(new Rotadora(Sentido.Horario));
        f.agrega(new Lijadora(Posicion.CeCe, OrLija.Norte,Grosor.Grueso));
        f.agrega(new Lijadora(Posicion.CeCe, OrLija.Oeste,Grosor.Medio));
        f.agrega(new Fresadora(Posicion.IzCe, OrFresa.Vertical, Grosor.Medio));
        f.agrega(new Taladradora(Posicion.IzCe,Grosor.Fino));
        f.agrega(new Lijadora(Posicion.CeSu, OrLija.Este,Grosor.Medio));


        //crear la pieza (matriz 3x3)
        Pieza p = new Pieza();
        Gui gui = new Gui(f, p);
        gui.muestra();
        System.out.println(p);
    }
}
