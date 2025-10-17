package laboratorio.practica4;

import java.util.Scanner;

import java.util.concurrent.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static Reloj reloj;
    private static ControlReloj controlReloj;

    public static void main(String[] args) {

        reloj = new Reloj();
        controlReloj = new ControlReloj(reloj);

        menu();

    }

    public static void updateTime() {
        // String line = input.nextLine();

        System.out.println("Ingrese la hora: ");
        int horas = input.nextInt();

        System.out.println("Ingrese los minutos: ");
        int minutos = input.nextInt();

        System.out.println("Ingrese los segundos: ");
        int segundos = input.nextInt();

        if (!reloj.validateHour(horas)) {
            System.err.println("Hora No Valida");

            return;
        }
        if (!reloj.validateMinute(minutos)) {
            System.err.println("minutos No Validos");

            return;
        }
        if (!reloj.validateSeconds(segundos)) {
            System.err.println("Segundos No Validos");

            return;
        }

        reloj.setTime(horas, minutos, segundos);

        System.out.println("Hora Actualizada Correctamente");

    }

    public static void menu() {

        System.out.println("[++MENU PRINCIPAL++]\n");
        System.out.println("[1] Ver Hora");
        System.out.println("[2] Configurar");
        System.out.println("[3] Salir");

        System.out.print("\n OPCION: ");

        String opcion = selectOpcion();

        switch (opcion) {
            case "1":

                reloj.onPrintTime();

                break;
            case "2":

                break;
            default:
                break;
        }

        // do {
        // switch (opcion) {
        // case '1':

        // reloj.onPrintTime();

        // // controlReloj.on();
        // // reloj.onPrintTime();

        // break;
        // case '2':

        // // reloj.esperar();
        // // updateTime();

        // break;
        // default:
        // break;
        // }
        // } while (opcion != '3');

    }
    public static String selectOpcion() {
        return input.nextLine();
    }

}
