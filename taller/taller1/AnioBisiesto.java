package taller.taller1;
import java.util.Scanner;


public class AnioBisiesto
{

    public static void main(String []args)
    {

        Scanner input = new Scanner(System.in);
        System.out.print("Captura el anio: "); 
        int valueAnio = input.nextInt();
        input.close();

        Anio anio = new Anio(valueAnio);

        if(getStatusAnio(anio)){
            System.out.printf("\nEl anio es bisiesto");
        }else{

            System.out.printf("\nEl anio NO es bisiesto");
        }

    }


    public static boolean getStatusAnio(Anio anio){
        
        if(!anio.getStatusPaso1()){
            
            return anio.getStatusPaso5();
        }

        if(!anio.getStatusPaso2()){

            return anio.getStatusPaso4();
        }

        if(!anio.getStatusPaso3()){

            return anio.getStatusPaso5();
        }

        return anio.getStatusPaso4();
    }
}

class Anio
{
    public int anio;

    public Anio(int anio)
    {
        this.anio = anio;
    }

    public boolean getStatusPaso1(){
                
        if(this.anio % 4 == 0){
            return true;
        }

        return false;
    }

    public boolean getStatusPaso2(){
                if(this.anio % 100 == 0){
            return true;
        }

        return false;

    }

    public boolean getStatusPaso3(){
                if(this.anio % 400 == 0){
            return true;
        }

        return false;

    }

     
    public boolean getStatusPaso4(){
        return true;

    }


    public boolean getStatusPaso5(){
        return false;

    }

}

