package amigos;

import java.util.Objects;

public class Persona implements Comparable<Persona>{

    /// # Atributos de la clase
    private String nombre;
    private Persona amigo;

    /// # Constructor de la clase: Asocia el nombre a la persona
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    /// @return devuelve el nombre de la persona
    public String getNombre() {
        return nombre;
    }

    /// @return devuelve el amigo de la persona
    public Persona getAmigo() {
        return amigo;
    }

    /// # Dos personas son iguales cuando sus nombres coinciden sin importar las mayúsculas o minúsculas
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Persona p)
                && (p.nombre.equalsIgnoreCase(nombre));
    }

    /// # Compara dos personas por su nombre
    /// @param p es la persona a comparar con la receptora
    @Override
    public int compareTo(Persona p) {
        int resultado = nombre.compareTo(p.nombre);
        return resultado;
    }

    /// # Asocia un amigo a cierta persona
    /// @param am es el amigo que se asocia
     /// @return no devuelve nada
    public void setAmigo(Persona am) {
        amigo = am;
    }

    /// # Representa los resultados convenientemente
    public String toString() {
        if (amigo == null)
            return nombre + " :le regala a: sin amigo";
        else
            return nombre + " :le regala a:" + amigo.getNombre();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase());
    }
}
