package taller.taller1;

import java.util.Scanner;

public class Main
{
    public static void main(String []args)
    {
        Scanner input = new Scanner(System.in);
        String texto;           
        System.out.print("Captura nombre: "); 
        texto = input.nextLine();
        System.out.print("Mi nombre es : "+texto);   


        double alto1,ancho1,profundo1;
        System.out.printf("\n\nAhora la caja padre"); 
        System.out.printf("\nCaptura el alto1 (cm): "); 
        alto1 = input.nextDouble();
        System.out.printf("Captura el ancho1 (cm): "); 
        ancho1 = input.nextDouble();
        System.out.printf("Captura el profundo1 (cm): "); 
        profundo1 = input.nextDouble();
        Caja caja1 = new Caja(alto1,ancho1,profundo1);  
       System.out.printf("\nVolumen de caja: %.2f cm^3", caja1.getVolumen() );


        double alto2,ancho2,profundo2;
        System.out.printf("\n\nAhora la caja hija"); 
        System.out.printf("\nCaptura el alto2 (cm): "); 
        alto2 = input.nextDouble();
        System.out.printf("Captura el ancho2 (cm): "); 
        ancho2 = input.nextDouble();
        System.out.printf("Captura el profundo2 (cm): "); 
        profundo2 = input.nextDouble();
        Caja caja2 = new Caja(alto2,ancho2,profundo2);  
       System.out.printf("\nVolumen de caja: %.2f cm^3", caja1.getVolumen() );

        input.close();

        System.out.printf("\nEl porcentaj es "+caja1.getPorcentaje(caja2));
    }


}


class Caja
{
    private double ancho;
    private double alto;
    private double profundo;
    
    public Caja(double ancho,double alto, double profundo)
    {
        this.ancho = ancho;
        this.alto = alto;
        this.profundo = profundo;
    }

    public double getVolumen()
    {
        return ancho*alto*profundo;
    }

    public double getSuperficie(){

      return 2*((this.ancho * this.alto)  + (this.alto * this.profundo) + (this.profundo * this.ancho));
    }

    public double getPorcentaje(Caja hijo){

        double volumenCajaPadre=this.getSuperficie();
        double volumenCajaHijo=hijo.getSuperficie();

        return (volumenCajaHijo / volumenCajaPadre)*100;

    }
}