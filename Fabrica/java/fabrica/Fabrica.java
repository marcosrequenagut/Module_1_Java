package fabrica;
import fabrica.maquinas.*;
import fabrica.posiciones.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

///Ejercicio Challenge Fábrica
/// @author   David Ortiz, Juan Marcos Requena, Juan Manuel Burgueño, Silvia Aguirre
/// @version 1.0

/// Una fábrica dispone de cuatro tipos distintos de máquinas que actúan sobre una pieza transformándola.
/// rotadoras, fresadoras, lijadoras  y taladradoras.
/// La estructura de una pieza es de 3x3 cuadros (es decir una matriz 3x3) y cada máquina actúa en cada uno de esos cuadros.
/// Cada cuadro se ha definido como un array de Strings, por lo que la estructura de la pieza sería String[][][]

public class Fabrica {
    private List<Maquina> maquinas;
    private static final Random alea = new Random();


    /// Constructores fábrica.
    /// Uno vacío, y otro con una lista de máquinas pasada como argumento
    public Fabrica(List<Maquina> maquinas){
        this.maquinas = maquinas;
    }
    public Fabrica(){
        this(new ArrayList<>());
    }

    /// Devuelve las máquinas que componen la fábrica y en el orden en que actúan
    public List<Maquina> maquinas(){
        return maquinas;
    }
    ///Agrega una máquina
    public void agrega(Maquina maquina){
        maquinas.add(maquina);

    }
    /// Crea una fábrica formada por máquinas aleatorias con el número de máquinas indicado como argumento.
    /// Teniendo en cuenta que la primera máquina no pueda ser una rotadora
    /// -que todas las máquinas tienen la misma probabilidad de aparecer
    /// -y que no tiene sentido rotar una máquina para volver a rotarla en sentido contrario inmediatamente después

    public static Fabrica aleatoria(int numFabricas){
        Fabrica fabrica = new Fabrica();
        Maquina primera=crearMaquina(alea.nextInt(3));
        fabrica.agrega(primera);
        Maquina anterior=primera;

        for (int i = 1; i <numFabricas; i++) {
            Maquina maquina;
            do{
                maquina = crearMaquina(alea.nextInt(4));
            }while (anterior instanceof Rotadora && maquina instanceof Rotadora && sentido(anterior,maquina));
            //si la máquina anterior es una rotadora y la actual también, comprueba que no giren en sentido opuesto
            fabrica.agrega(maquina);
            anterior=maquina; //actualiza anterior a la última fábrica metida para comprobarlo con todas las máquinas siguientes
        }
        return fabrica; //devuelve la fábrica completa con todas las máquinas agregadas
    }

    /// Comprueba si dos rotadoras giran en la misma dirección
    private static boolean sentido(Maquina anterior, Maquina maquina) {
        Rotadora anteriorRot= (Rotadora) anterior;  //es seguro castear a Rotadora ya que se comprueba que anterior y maquina son instancias de Rotadora en el while
        Rotadora maquinaRot= (Rotadora) maquina;
        return anteriorRot.getSentido().equals(maquinaRot.getSentido());

    }

    /// Selecciona un tipo de máquina según el número aleatorio `aleat`.
    private static Maquina crearMaquina(int aleat) {
        switch (aleat) {
            case 0:
                return new Fresadora(getPosicion(), getOrFresa(), getGrosor());
            case 1:
                return new Lijadora(getPosicion(), getOrLija(), getGrosor());
            case 2:
                return new Taladradora(getPosicion(), getGrosor());
            case 3:
                return new Rotadora(alea.nextBoolean() ? Sentido.Horario : Sentido.Antihorario);
            default:
                throw new IllegalStateException("Tipo de máquina no válido .");
        }
    }

    private static OrLija getOrLija() {
        OrLija[] orLijas=OrLija.values();  //coge los valores del enum OrLijas
        return orLijas[alea.nextInt(orLijas.length)];
    }
    private static OrFresa getOrFresa() {
        OrFresa[] orFresas=OrFresa.values(); //coge los valores del enum OrFresa
        return orFresas[alea.nextInt(orFresas.length)];
    }

    private static Grosor getGrosor() {
        Grosor[] grosores = Grosor.values(); //coge los valores del enum Grosor
        return grosores[alea.nextInt(grosores.length)];
    }

    private static Posicion getPosicion() {
        Posicion[] posiciones = Posicion.values(); //coge los valores del enum Posicion
        return posiciones[alea.nextInt(posiciones.length)];
    }




}
