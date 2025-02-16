import amigos.AmigoException;
import amigos.ClubParejas;
import amigos.ClubManager;
import amigos.Club;

import java.io.IOException;

public class Main {
    public static void main(String [] args)  {
//		ClubManager clubM = new ClubManager(new Club());
        ClubManager clubM = new ClubManager(new ClubParejas());
        try {
            clubM
				.setEntrada("data/socios.txt", "[ ,;]+")
                    //.setEntrada(null, "[ ,;]+")
                    //.setEntrada("data/socios.txt", "[ ,\\-;]+")
                    .setConsola(true)
                    //.setConsola(false)
 				.setSalida("data/salida.txt")
                //.setSalida(null)
                    .build();
        } catch (IOException e) {
            System.out.println("Error en la entrada/salida de datos");
        } catch (AmigoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
