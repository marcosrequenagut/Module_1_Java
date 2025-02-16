package amigos;

import java.util.Objects;

public record Pareja(Persona uno, Persona otro) {
    /// # Dos parejas son iguales cuando sus nombres están intercambiados
    @Override
    public int hashCode(){
        return Objects.hash(uno.getNombre().toLowerCase(), otro.getNombre().toLowerCase());
    }

    /// # Dos parejas son iguales cuando sus nombres están intercambiados
    /// 1. pablo-marcos sería la misma pareja que marcos-pablo
    @Override
    public boolean equals(Object o) {
        return (o instanceof Pareja(Persona pUno, Persona pOtro)
        && (uno.getNombre().equalsIgnoreCase(pOtro.getNombre()))
        && (otro.getNombre().equalsIgnoreCase(pUno.getNombre())));
    }
}
