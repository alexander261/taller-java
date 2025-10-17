package laboratorio.practica4;

/*
javac -d bin src/practica4/*.java
java -cp bin practica4.Main
*/


import java.util.concurrent.*;

public class HiloSem implements Runnable
{
    private Thread thread;
    private String nombre;
    private int iteraciones;
    private Recurso recurso;
    private Semaphore sem;
    
    public HiloSem(String nombre,int iteraciones,Recurso recurso,Semaphore sem)
    {
        this.nombre = nombre;
        this.iteraciones = iteraciones;
        this.recurso = recurso;
        this.sem = sem;
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
            try
            {
                System.out.println(nombre+" esperando permiso >:( ...");
                sem.acquire();
                System.out.println("\n"+nombre+" permiso obtenido :)");                
                //INICIO SECCION CRITICA
                dato = recurso.get_dato();
                dato = dato + 1;
                recurso.set_dato(dato);
                System.out.println("ESCRIBIR -> "+dato);
                //FIN SECCION CRITICA
            } 
            catch (InterruptedException exc) 
            {
                System.out.println(exc);
            }    
            System.out.println(nombre+" libero permiso");
            sem.release();
        }
    }   
    
    public void esperar()
    {
        try{thread.join();}
        catch(InterruptedException e){}
    }
}

