package laboratorio.practica2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
        private static Scanner input;
        private static ArrayList<Materia> lista;

        public static void main(String[] args) {

                lista = new ArrayList<>();

                menu();
        }

        public static String getValueNombre(){
                      
                System.out.print("Nombre: ");
                
                String line = input.nextLine();
                String nombre = input.nextLine();

                return nombre;
        }

        public static int getValueCodigo(){
         
                System.out.print("Codigo: ");
                int codigo = input.nextInt();
                 input.nextLine();
                return codigo;       
        }

        public static int getValueCreditos(){
                
                System.out.print("Creditos: ");
                int creditos = input.nextInt();
                 input.nextLine();
                return creditos;
        }

        public static boolean addMateria() {
                System.out.println("Datos de la Materia:");

                String nombre = getValueNombre();

                int codigo = getValueCodigo();

                int creditos = getValueCreditos();

                Materia temp = new Materia(nombre, codigo, creditos);

                if (lista.contains(temp)) {
                        return false;
                }

                lista.add(temp);
                return true;
        }

        public static boolean removeMateria() {
                System.out.println("Ingrese el codigo de materia a eliminar");
                int codigo = input.nextInt();

                Materia temp = new Materia("", codigo, 0);

                if (!lista.contains(temp)) {
                        return false;
                }

                lista.remove(temp);

                return true;
        }

        public static void menu() {
                char opcion;
                input = new Scanner(System.in);

                do {
                        // MENU
                        System.out.println("[++MENU PRINCIPAL++]\n");
                        System.out.println("[0] REGISTRAR MATERIA");
                        System.out.println("[1] ELIMINAR MATERIA CODIGO");
                        System.out.println("[2] MOSTRAR LISTA DE MATERIAS");
                        System.out.println("[3] ORDENAR POR CODIGO");
                        System.out.println("[4] ORDENAR POR NOMBRE");
                        System.out.println("[5] ORDENAR POR CREDITOS");
                        System.out.println("[6] TERMINAR");
                        System.out.print("\n OPCION: ");

                        opcion = selec_opcion();
                        switch (opcion) {
                                case '0':
                                        if (addMateria()) {
                                                System.out.println("Materia guarda correctamente\n");
                                        } else {
                                                System.out.println("Codigo de materia duplicado\n");
                                        }

                                        break;
                                case '1':
                                        if (removeMateria()) {
                                                System.out.println("Materia eliminada correctamente");
                                        } else {
                                                System.out.println("Codigo de materia no encontrado");
                                        }
                                        break;
                                case '2':
                                        System.out.print("Lista de materias: \n");
                                        System.out.printf("%s", lista);
                                        System.out.print("\n\n");


                                        break;
                                case '3':

                                        lista.sort(Materia.comparatoCodigo());

                                        System.out.print("Lista de materias (Ordenadas por codigo): \n");
                                        System.out.printf("%s", lista);
                                        System.out.print("\n\n");

                                        break;
                                case '4':

                                        lista.sort(Materia.comparatoNombres());

                                        System.out.print("Lista de materias (Ordenadas por nombre): \n");
                                        System.out.printf("%s", lista);
                                        System.out.print("\n\n");

                                        break;
                                case '5':

                                        lista.sort(Materia.compareToCreditos());

                                        System.out.print("Lista de materias (Ordenadas por creditos): \n");
                                        System.out.printf("%s", lista);
                                        System.out.print("\n\n");

                                        break;
                                case '6':
                                        break;
                                default:
                                        break;
                        }
                } while (opcion != '6');
        }

        public static char selec_opcion() {
                // TRIM REMUEVE LOS ESPACIOS y CHARAT EXTRAE EL PRIMER CARACTER
                return input.next().trim().charAt(0);
        }
}
