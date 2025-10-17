package laboratorio.practica4;

/*
javac -d bin src/practica4/*.java
java -cp bin practica4.Main
*/


public class Hilo implements Runnable
{
    private Thread thread;
    private String nombre;
    private int iteraciones;
    private Recurso recurso;
    
    public Hilo(String nombre,int iteraciones,Recurso recurso)
    {
        this.nombre = nombre;
        this.iteraciones = iteraciones;
        this.recurso = recurso;
        //CONSTRUCTOR --> Thread(Runnable task, String name)
        thread = new Thread (this , this.nombre);
        thread.start();
    }
    
    @Override
    public void run()
    {
        int i,dato;        
        for( i = 0 ; i < iteraciones ; i++)
        {
            //INICIO SECCION CRITICA
            dato = recurso.get_dato();
            System.out.println(thread+" : LEER "+dato);
            dato = dato + 1;
            recurso.set_dato(dato);
            System.out.println(thread+" : ESCRIBIR "+dato);
            //FIN SECCION CRITICA
        }        
    }   
    
    public void esperar()
    {
        try{thread.join();}
        catch(InterruptedException e){}
    }
}

