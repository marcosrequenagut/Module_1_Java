package genetico;

/// Constructor de AGUniforme
public class AGUniforme extends AlgoritmoGenetico{
    public AGUniforme(int tam_pobl, int tam_indi, int pasos, double probMutacion, Problema problema){
        super(tam_pobl, tam_indi, pasos, probMutacion, problema);
    }

    /// # Genera un nuevo cromosoma ("pseudoaleatoriamente") a partir de otros dos dados como argumento.
    /// ## El valor de cada gen del cromosoma del individuo generado se selecciona aleatoriamente de uno de sus progenitores.
    /// @param cr1 es un cromosoma paado como argumento.
     /// @param cr2 es otro cromosoma pasado como argumento.
     /// @return `cr3` es el nuevo cromosoma creado mediante la recombinación de `cr1` y `cr2`.
    @Override
    protected Cromosoma recombinar(Cromosoma cr1, Cromosoma cr2) {
        Cromosoma cr3 = new Cromosoma(cr1.getLongitud(), false);
        for (int i = 0; i < cr1.getLongitud(); i++) {
            if (Cromosoma.gna.nextInt(2) == 0)
                cr3.setGen(i, cr1.getGen(i));
            else
                cr3.setGen(i, cr2.getGen(i));
        }
        return cr3;
    }
}
