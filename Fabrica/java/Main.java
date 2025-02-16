import fabrica.*;
import fabrica.maquinas.Taladradora;
import fabrica.posiciones.*;
import gui.Gui;
import fabrica.Fabrica;
import fabrica.maquinas.Fresadora;
import fabrica.maquinas.Rotadora;
import fabrica.maquinas.Lijadora;

public class Main {
    public static void main(String[] args) {
        //Crear la fabrica (vacía, sin maquinas)
        Fabrica f = new Fabrica();
        //Agregar todas las maquinas que se quieran a f (la fabrica)
        f.agrega(new Fresadora(Posicion.IzSu, OrFresa.Vertical, Grosor.Medio));
        f.agrega(new Fresadora(Posicion.IzCe, OrFresa.Diagonal, Grosor.Medio));
        f.agrega(new Fresadora(Posicion.IzIn, OrFresa.Vertical,Grosor.Medio));
        f.agrega(new Rotadora(Sentido.Antihorario));
        f.agrega(new Lijadora(Posicion.CeSu, OrLija.Norte,Grosor.Fino));
        f.agrega(new Fresadora(Posicion.CeSu,OrFresa.Diagonal, Grosor.Grueso));
        f.agrega(new Rotadora(Sentido.Antihorario));
        f.agrega(new Fresadora(Posicion.CeCe, OrFresa.Diagonal,Grosor.Medio));
        f.agrega(new Taladradora(Posicion.IzCe,Grosor.Medio));
        f.agrega(new Rotadora(Sentido.Antihorario));
        f.agrega(new Fresadora(Posicion.CeSu, OrFresa.Vertical, Grosor.Fino));
        f.agrega(new Fresadora(Posicion.IzIn, OrFresa.Vertical, Grosor.Medio));
        f.agrega(new Rotadora(Sentido.Horario));
        f.agrega(new Lijadora(Posicion.IzCe, OrLija.Sur,Grosor.Grueso));
        f.agrega(new Fresadora(Posicion.CeCe, OrFresa.Diagonal, Grosor.Fino));
        f.agrega(new Lijadora(Posicion.IzSu, OrLija.Sur,Grosor.Medio));
        f.agrega(new Fresadora(Posicion.IzCe, OrFresa.Vertical, Grosor.Medio));
        f.agrega(new Fresadora(Posicion.IzSu,OrFresa.Diagonal, Grosor.Grueso));

        //crear la pieza (matriz 3x3)
        Pieza p = new Pieza();
        Gui gui = new Gui(f, p);
        gui.muestra();
        System.out.println(p);
    }
}
