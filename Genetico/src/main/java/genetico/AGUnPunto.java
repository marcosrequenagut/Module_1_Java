package genetico;

public class AGUnPunto extends AlgoritmoGenetico {

    /// Constructor de AGUnPunto
    public AGUnPunto(int tam_pobl, int tam_indi, int pasos, double probMutacion, Problema problema){
        super(tam_pobl,tam_indi, pasos, probMutacion, problema);
    }

    /// # Genera un nuevo cromosoma como combinación de otros dos dados como argumento.
    /// 1. Se crea un número aleatorio `z`.
    /// 1. El individuo resultante se crea con los primeros `z` genes de `cr1`
    /// y los restantes genes perteneces a `cr2`.
    /// @param cr1 es un cromosoma paado como argumento.
     /// @param cr2 es otro cromosoma pasado como argumento.
     /// @return `cr3` es el nuevo cromosoma creado mediante la recombinación de `cr1` y `cr2`.
    @Override
    protected Cromosoma recombinar(Cromosoma cr1, Cromosoma cr2){
        int z = Cromosoma.gna.nextInt(cr1.getLongitud()); // Numero aleatorio entre 0 y long cromosoma.
        Cromosoma cr3 = new Cromosoma(cr1);

        // Creo un cromosoma cr3 igual al  cr1
        // Hasta la posicion del gen z, cr3 sera igual a cr1
        // A partir de ahí cr3 será igual a cr2
        // Se supone que todos los cromosomas tienen la misma longitud pero ns si está bien
        for (int i = z; i < cr3.getLongitud(); i++) {
            cr3.setGen(i, cr2.getGen(i));
        }
        return cr3;
    }
}
