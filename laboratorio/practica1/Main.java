package laboratorio.practica1;

import java.util.Scanner;

public class Main
{
    public static void main(String []args)
    {
        double alto,ancho,profundo;
        Scanner input = new Scanner(System.in);
        Caja [] cajas = new Caja[5];

        int n=5;
        cajas = setValoresCajas(cajas,n,input);

        int status=1;
        while(status==1){

            int opcion = getOpcion(input);
            cajas = orderAsc(cajas,n,opcion);
            showCajas(cajas,n);

            if(opcion == 5){
                status=0;
            }
        }
        

        input.close();
    }

    public static int getOpcion(Scanner input){

        System.out.printf("1 - Mostrar orden por ancho\n");
        System.out.printf("2 - Mostrar orden por alto\n");
        System.out.printf("3 - Mostrar orden por profundo\n"); 
        System.out.printf("4 - Mostrar orden por volumen\n");
        System.out.printf("5 - Salir\n");
        int opcion = input.nextInt();
        return opcion;
    }

    public static Caja[] setValoresCajas(Caja [] cajas,int n,Scanner input){
        for(int i=0; i < n;i++){

            System.out.printf("\nValores Caja "+(i+1)+"\n"); 

            double alto = getAlto(input);
            double ancho = getAncho(input);
            double profundo = getProfundo(input);

            cajas[i] = new Caja(ancho,alto,profundo);
        }

        return cajas;
    }

    public static Caja [] orderAsc(Caja [] cajas,int n,int opcion){

        for(int j = 0; j < n; j++){

            for(int i = 0; i < n-1; i++){

                Caja temp = new Caja(cajas[i].getAncho(),cajas[i].getAlto(),cajas[i].getProfundo());


                switch(opcion){

                    case 1://ANCHO
                        if(cajas[i].getAncho() > cajas[i+1].getAncho()){
                            cajas[i] = cajas[i+1];
                            cajas[i+1] = temp;
                        }
                        break;
                    case 2://ALTO
                        if(cajas[i].getAlto() > cajas[i+1].getAlto()){
                            cajas[i] = cajas[i+1];
                            cajas[i+1] = temp;
                        }
                        break;
                    case 3://PROFUNDO
                        if(cajas[i].getProfundo() > cajas[i+1].getProfundo()){
                            cajas[i] = cajas[i+1];
                            cajas[i+1] = temp;
                        }
                        break;
                    case 4://VOLUMEN
                        if(cajas[i].getVolumen() > cajas[i+1].getVolumen()){
                            cajas[i] = cajas[i+1];
                            cajas[i+1] = temp;
                        }
                        break;

                }


            }
        }

        return cajas;
    }

    public static void showCajas(Caja [] cajas,int n){

        for(int i=0; i < n; i++){
            System.out.printf("\nCaja "+(i+1)+"\n");            
            System.out.printf("Ancho : "+cajas[i].getAncho()+"\n");
            System.out.printf("Alto : "+cajas[i].getAlto()+"\n");
            System.out.printf("Profundo : "+cajas[i].getProfundo()+"\n");
            System.out.printf("Volumen : "+cajas[i].getVolumen()+"\n");

        }
    }

    public static String getNombre(Scanner input){
        
        String texto;           
        System.out.print("Captura nombre: "); 
        texto = input.nextLine();
        System.out.print("Mi nombre es : "+texto);   
        return texto;
    }

    public static double getAlto(Scanner input){

        System.out.printf("\nCaptura el alto (cm): "); 
        double alto = input.nextDouble();

        return alto;
    }

    public static double getAncho(Scanner input){

        System.out.printf("Captura el ancho (cm): "); 
        double ancho = input.nextDouble();

        return ancho;
    }

    public static double getProfundo(Scanner input){

        System.out.printf("Captura el profundo (cm): "); 
        double profundo = input.nextDouble();

        return profundo;
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

    public double getAncho(){
        return this.ancho;
    }

    public double getAlto(){
        return this.alto;
    }

    public double getProfundo(){
        return this.profundo;
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