package amigos;

public class AmigoException extends RuntimeException {
    public AmigoException() {
        super(); // Llama al constructor vacío de RunTimeException
    }

    /// # Constructor
    /// @param message es el mnensaje que se muestra por pantalla al aparecer el error
    public AmigoException(String message) {
        super(message); // Llama al constructor RunTimeException con un string de RunRimeRxception
    }
}

