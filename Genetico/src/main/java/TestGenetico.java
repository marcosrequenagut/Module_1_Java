import genetico.*; // Importo todas las clases del paquete

public class TestGenetico {

    static final int TAM_POBLACION = 20;
    static final int PASOS_GA = 400;
    static final int LONG_CROMOSOMA = 50;

    static final double PROB_MUT = 0.02;

    public static void main(String[] args) {
        Problema problema = new OneMax();
        System.out.println("---------------------------------------------------");
        System.out.println("--- Se usa OneMax() para el cálculo del fitness ---");
        System.out.println("---------------------------------------------------");

        AlgoritmoGenetico ga1 = new AGUnPunto(TAM_POBLACION, LONG_CROMOSOMA,
                PASOS_GA, PROB_MUT, problema);
        Individuo solucion1 = ga1.ejecuta();
        System.out.println("\nSolución 1:" + solucion1);

        AlgoritmoGenetico ga2 = new AGUniforme(TAM_POBLACION, LONG_CROMOSOMA,
                PASOS_GA, PROB_MUT, problema);
        Individuo solucion2 = ga2.ejecuta();
        System.out.println("Solución 2:" + solucion2);

        Problema problema2 = new CeroMax();
        System.out.println("\n----------------------------------------------------");
        System.out.println("--- Se usa CeroMax() para el cálculo del fitness ---");
        System.out.println("----------------------------------------------------");

        AlgoritmoGenetico ga1_2 = new AGUnPunto(TAM_POBLACION, LONG_CROMOSOMA,
                PASOS_GA, PROB_MUT, problema2);
        Individuo solucion1_2 = ga1_2.ejecuta();
        System.out.println("\nSolución 1:" + solucion1_2);

        AlgoritmoGenetico ga2_2 = new AGUniforme(TAM_POBLACION, LONG_CROMOSOMA,
                PASOS_GA, PROB_MUT, problema2);
        Individuo solucion2_2 = ga2_2.ejecuta();
        System.out.println("Solución 2:" + solucion2_2);


    }
}
