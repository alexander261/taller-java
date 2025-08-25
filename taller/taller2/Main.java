package taller.taller2;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        int status = 1;
        int value;
        int indice;

        while (status == 1) {

            int opcion = getOpcion(input);

            switch (opcion) {
                case 1:
                    mostrarLista(list);
                    break;
                case 2:

                    System.out.printf("\nIngrese su valor: ");
                    value = input.nextInt();

                    list = agregarValor(list, new Integer(value));
                    break;
                case 3:

                    System.out.printf("\nIngrese su valor: ");
                    value = input.nextInt();

                    System.out.printf("\nIngrese el indice: ");
                    indice = input.nextInt();

                    if (indice <= list.size()+1) {
                        list = agregarValorPorIndice(list, new Integer(value), indice);

                    } else {
                        System.out.printf("\n Indice no valido \n\n");
                    }

                    break;
                case 4:
                    System.out.printf("\nIngrese el indice: ");
                    indice = input.nextInt();

                    if (indice <= list.size()) {
                        list = eliminarValorPorIndice(list, indice);

                    } else {
                        System.out.printf("\n Indice no valido \n\n");
                    }

                    break;
                case 5:
                    System.out.printf("\nIngrese su valor: ");
                    value = input.nextInt();

                    list = eliminarValor(list, new Integer(value));
                    break;
                case 6:
                    Integer total = getTotal(list);
                    System.out.printf("\nSuma Total :" + total + " \n");
                    break;
                case 7:

                    list = vaciarLista(list);
                    status = 0;
                    break;
            }

        }

        input.close();

    }

    public static int getOpcion(Scanner input) {

        System.out.printf("1 - Mostrar ArrayList:\n");
        System.out.printf("2 - Agregar valor:\n");
        System.out.printf("3 - Agregar valor en posición:\n");
        System.out.printf("4 - Eliminar en base Índice:\n");
        System.out.printf("5 - Eliminar en base Valor:\n");
        System.out.printf("6 - Sumatoria:\n");
        System.out.printf("7 - Salir\n");

        System.out.printf("Ingrese su opcion:");

        int opcion = input.nextInt();

        return opcion;
    }

    public static void mostrarLista(ArrayList<Integer> list) {

        System.out.println("\nColeccion de numeros -> \n" + list);
        System.out.printf("Total de valores :" + (list.size()) + "\n");
    }

    public static ArrayList<Integer> agregarValor(ArrayList<Integer> list, Integer value) {

        list.add(value);

        return list;
    }

    public static Integer getTotal(ArrayList<Integer> list) {

        int length = list.size();
        Integer total = 0;

        for (int i = 0; i < length; i++) {
            total += list.get(i);
        }

        return total;
    }

    public static ArrayList<Integer> vaciarLista(ArrayList<Integer> list) {
        list.clear();

        return list;
    }

    public static ArrayList<Integer> agregarValorPorIndice(ArrayList<Integer> list, Integer value, int indice) {

        ArrayList<Integer> nuevaLista = new ArrayList<>();
        int length = list.size();

        for (int i = 0; i < length; i++) {

            if (i == indice) {

                nuevaLista.add(value);

            }

            nuevaLista.add(list.get(i));
        }

        return nuevaLista;
    }

    public static ArrayList<Integer> eliminarValorPorIndice(ArrayList<Integer> list, int indice) {

        ArrayList<Integer> nuevaLista = new ArrayList<>();

        int length = list.size();

        for (int i = 0; i < length; i++) {

            if (i != indice) {

                nuevaLista.add(list.get(i));

            }

        }

        return nuevaLista;
    }

    public static ArrayList<Integer> eliminarValor(ArrayList<Integer> list, Integer value) {

        list.remove(value);

        return list;
    }

}
