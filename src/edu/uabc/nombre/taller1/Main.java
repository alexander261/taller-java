// ARCHIVO MAIN.C
// PARA COMPILAR: javac Main.java
// PARA EJECUTAR: java Main
package src.edu.uabc.nombre.taller1;
import java.util.Scanner;

public class Main
{
	public static void main(String []args)
	{
		int x,y;
		Scanner input = new Scanner(System.in);
		System.out.print("Captura valor de x: ");
		x = input.nextInt();
		System.out.print("Captura valor de y: ");
		y = input.nextInt();
		System.out.printf("Resultado de x * y = %d",x*y);
	
	}
}