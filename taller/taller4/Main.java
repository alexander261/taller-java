package taller.taller4;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Main {

    private static Scanner input = new Scanner(System.in);;
    private static int ren = 12;
    private static int col = 15;
    private static Asiento[][] sala = new Asiento[ren][col];
    private static TreeMap<String, Asiento> asientos_mapeados = new TreeMap<String, Asiento>();

    public static void main(String[] arg) {
        inicializarSala();
        menu();
    }

    public static boolean valoresValidos(String[] asientos, boolean validarReservasiones) {

        if (asientos.length == 0) {
            System.err.println("Sin Asientos");
            return false;
        }

        Asiento busqueda;

        for (String valor : asientos) {

            busqueda = asientos_mapeados.get(valor);

            if (busqueda == null) {
                System.err.println("Asiento no encontrado: " + valor);
                return false;
            }

            if (busqueda.getStatus() && validarReservasiones) {
                System.err.println("El asiento ya se encuentra reservado: " + valor);
                return false;
            }

        }

        return true;
    }

    public static String inputAsientos() {

        System.out.print("Asientos: ");
        String line = input.nextLine();

        String nombre = input.nextLine();

        return nombre;
    }

    public static String[] getAsientos(String text) {

        String[] temp = text.split(",");
        String[] asientos = new String[temp.length];

        int i = 0;
        for (String string : temp) {

            asientos[i] = string.trim();
            i++;
        }

        return asientos;
    }

    public static void inicializarSala() {

        int i, j;

        char[] ren_base = new char[1];
        String identificador;

        // CREAR ASIENTO Y AGREGARLOS AL MAPA
        for (i = 0; i < ren; i++) {
            for (j = 0; j < col; j++) {
                // CREAR ASIENTO
                sala[i][j] = new Asiento(i, j);
                ren_base[0] = (char) ('A' + i);

                // CREAR CLAVES
                // A1,A2,A3... B1,B2,B3... C1...
                identificador = new String(ren_base) + Integer.toString(1 + j);

                // RELACIONAR CLAVE CON ASIENTO (MAPEAR)
                asientos_mapeados.put(identificador, sala[i][j]);
            }
        }
    }

    public static void mostrarSala() {
        int i, j;

        for (j = 0; j < col; j++) {
            if (j >= 10)
                System.out.print("  " + (j + 1));
            else
                System.out.print("   " + (j + 1));
        }

        System.out.print("\n");
        for (i = 0; i < ren; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (j = 0; j < col; j++) {
                System.out.print(sala[i][j] + " ");
            }
            System.out.print("\n");
        }

    }

    public static void reservar() {

        String stringAsientos = inputAsientos();

        String[] asientos = getAsientos(stringAsientos);

        if (!valoresValidos(asientos, true)) {
            return;
        }

        Asiento busqueda;

        for (String asiento : asientos) {

            busqueda = asientos_mapeados.get(asiento);

            busqueda.reservar();

        }

        if (asientos.length == 1) {

            System.err.println("Asiento reservado");

        } else {

            System.err.println("Asientos reservados");

        }
    }

    public static void cancelarReserva() {

        String stringAsientos = inputAsientos();

        String[] asientos = getAsientos(stringAsientos);

        if (!valoresValidos(asientos, false)) {
            return;
        }

        Asiento busqueda;

        for (String asiento : asientos) {

            busqueda = asientos_mapeados.get(asiento);

            busqueda.cancelarReserva();

        }

        if (asientos.length == 1) {

            System.err.println("Reserva Cancelada");

        } else {

            System.err.println("Reservas Canceladas");

        }

    }

    public static void menu() {
        char opcion;

        do {
            System.out.println("[++MENU PRINCIPAL++]\n");
            System.out.println("[1] Consultar");
            System.out.println("[2] Reservar");
            System.out.println("[3] Cancelar Reserve");
            System.out.println("[4] Salir");

            System.out.print("\n OPCION: ");

            opcion = selec_opcion();
            switch (opcion) {
                case '1':

                    mostrarSala();

                    break;
                case '2':

                    reservar();

                    break;
                case '3':
                    cancelarReserva();
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