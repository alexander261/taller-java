package laboratorio.practica4;

/*
javac -d bin src/practica4/*.java
java -cp bin practica4.Main
*/



public class Recurso
{
    private int dato;
    
    public Recurso(int dato)
    {
        this.dato = dato;
    }
    
    public int get_dato()
    {
        return dato;
    }
    
    public void set_dato(int dato)
    {
        this.dato = dato;
    }

}