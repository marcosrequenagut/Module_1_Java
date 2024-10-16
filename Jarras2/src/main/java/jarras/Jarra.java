package jarras;

public class Jarra{
    private int contenido, capacidad;

    public Jarra(){
        this.contenido = 0;
        this.capacidad = capacidad;
    }
    public Jarra(int a, int b){
        contenido = a;
        capacidad = b;
    }

    public int getCapacidad(){
        return capacidad;
    }
    public int getContenido(){
        return contenido;
    }
    public void llena(){
        this.contenido = capacidad;
    }
    public int vacia(){
        contenido = 0;
        return contenido;
    }
    public void llenaDesde(Jarra otrajarra){
        int restante_j1 = this.capacidad - this.contenido;
        if (otrajarra.getContenido() > restante_j1){
            this.contenido = this.capacidad;
            otrajarra.contenido = otrajarra.getContenido() - restante_j1;
        } else {
            this.contenido = otrajarra.getContenido() + this.contenido;
            otrajarra.vacia();
        }
    }
    public String toString(){ //Para ver la variable punto de una manera bonita, es una clase que ya existe
        return "Contenido:" + contenido + " " + "Capacidad: " + capacidad;
    }

}