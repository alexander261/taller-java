package taller.taller3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Main {
    private static Scanner input;
    private static TreeSet<Persona> conjunto;

    public static void main(String[] args) {

        conjunto = new TreeSet<>(Persona.COMPARAR_NOMBRE());

        menu();
    }

    public static boolean addPersona(){
        System.out.println("Datos de la Persona:");
        
        String nombre = getValueNombre();
        int edad = getValueEdad();

        Persona temp = new Persona(nombre,edad);

        return conjunto.add(temp);
    }

    public static void mostrarPersonas(){

        System.out.print("Lista de Personas (Ordenadas por Nombre y Edad): \n");
        System.out.printf("%s", conjunto);
        System.out.print("\n\n");
    }

    public static void mostrarConjuntoPersonas(){
        System.out.print("Ingrese el rango a buscar\n");
        
        System.out.print("Rango minimo nombre: ");
        char charInicioNombre = selec_opcion();
        String inicioNombre = charInicioNombre + "";


        System.out.print("Rango maximo nombre: ");
        char charFinNombre = selec_opcion();
        charFinNombre = (char)(charFinNombre + 1);
        String finNombre = charFinNombre + "";


        System.out.print("Rango minimo edad: ");
        int inicioEdad = input.nextInt();

        System.out.print("Rango maximo edad: ");
        int finEdad = input.nextInt();

        //System.err.println("INICIO: "+inicioNombre+" FIN: "+finNombre+" INICIO: "+inicioEdad+" FIN: "+finEdad+"");

        Persona desde = new Persona(inicioNombre, inicioEdad);
        Persona hasta = new Persona(finNombre, finEdad);

        TreeSet<Persona> personasPorNombre = (TreeSet)conjunto.subSet(desde, true, hasta,false);

        TreeSet<Persona> personasPorEdad = new TreeSet<>(Persona.COMPARAR_EDAD());
        personasPorEdad.addAll(personasPorNombre);

        TreeSet<Persona> filtroEdad = (TreeSet)personasPorEdad.subSet(desde, true, hasta,true);
        System.out.println("Personas: " + filtroEdad);

    }

    public static String getValueNombre() {

        System.out.print("Nombre: ");

        String line = input.nextLine();
        String nombre = input.nextLine();

        return nombre;
    }

    public static int getValueEdad() {

        System.out.print("Edad: ");
        int edad = input.nextInt();
        input.nextLine();
        return edad;
    }

    public static void menu() {
        char opcion;
        input = new Scanner(System.in);

        do {
            // MENU
            System.out.println("[++MENU PRINCIPAL++]\n");
            System.out.println("[1] REGISTRAR PERSONA");
            System.out.println("[2] MOSTRAR PERSONAS REGISTRADAS");
            System.out.println("[3] FILTRAR POR RANGO");
            System.out.println("[4] TERMINAR");
            System.out.print("\n OPCION: ");

            opcion = selec_opcion();
            switch (opcion) {
                case '1':
                    if(addPersona()){
                        System.out.println("Persona Agregada correctamente");   
                    }else{

                        System.out.println("Persona duplicada");
                    }
                    break;
                case '2':
                    mostrarPersonas();
                    break;
                case '3':
                    mostrarConjuntoPersonas();
                    break;
                default:
                    break;
            }
        } while (opcion != '4');
    }

    public static char selec_opcion() {
        // TRIM REMUEVE LOS ESPACIOS y CHARAT EXTRAE EL PRIMER CARACTER
        return input.next().trim().charAt(0);
    }
}
