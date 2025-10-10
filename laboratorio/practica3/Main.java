package laboratorio.practica3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

import java.io.*;
import java.util.*;

public class Main {
    private static TreeSet<Usuario> usuarios;
    private static Scanner input;
    private static String usernameSession;
    private static String correoSession;

    public static void main(String[] args) {

        crearFile();

        usuarios = new TreeSet<>(Usuario.COMPARAR_USUARIO());

        deserializar();

        menu();

        serializarLista();

    }

    public static void loginPorCorreo(String correo) {

        usernameSession = null;
        correoSession = correo;
        menuSession();

    }

    public static void loginPorUsername(String username) {
        usernameSession = username;
        correoSession = null;

        menuSession();

    }

    public static void login() {

        String credencialUser = inputCredencialUser();
        String credencialPassword = inputCredencialPassword();

        TreeSet<Usuario> listCorreosTemp = new TreeSet<>(Usuario.COMPARAR_CORREOS_LOGIN());
        listCorreosTemp.addAll(usuarios);

        boolean statusCorreo = listCorreosTemp.contains(new Usuario(
                "nombre",
                "apellido",
                credencialUser,
                "username",
                credencialPassword));

        if (statusCorreo) {

            System.out.println("\n********************************");
            System.out.println("Credenciales Validas");
            System.out.println("********************************\n");

            loginPorCorreo(credencialUser);

            return;

        }

        TreeSet<Usuario> listUsernameTemp = new TreeSet<>(Usuario.COMPARAR_USERNAMES_LOGIN());
        listUsernameTemp.addAll(usuarios);

        boolean statusUsername = listUsernameTemp.contains(new Usuario(
                "nombre",
                "apellido",
                "correo",
                credencialUser,
                credencialPassword));

        if (statusUsername) {

            System.out.println("\n********************************");
            System.out.println("Credenciales Validas");
            System.out.println("********************************\n");

            loginPorUsername(credencialUser);

            return;

        }

        System.out.println("\n********************************");
        System.out.println("Credenciales Invalidas");
        System.out.println("********************************\n");
    }

    public static void addUsuario() {
        String nombre = inputNombre();

        String apellido = inputApellido();

        String correo = inputCorreo();

        String username = inputUsername();

        String password = inputPassword();

        Usuario usuario = new Usuario(
                nombre,
                apellido,
                correo,
                username,
                password);

        boolean status = usuarios.add(usuario);

        if (!status) {
            System.out.println("\nCorreo o Usuario ya existe\n");
            System.out.println("Quiere Capturar de nuevo la informacion");

            System.out.println("0 - Cancelar Registro ");
            System.out.println("1 - Capturar Informacion ");
            System.out.print("Opcion: ");
            char opcion = selec_opcion();

            if (opcion == '1') {
                addUsuario();
                return;
            }

            return;
        } else {

            System.out.println("\n********************************");
            System.out.println("Usuario Registrado Correctamente");
            System.out.println("********************************\n");
            return;
        }
    }

    public static boolean removeUsuario() {
        return true;
    }

    public static String inputNombre() {
        System.out.print("Nombre: ");
        String line = input.nextLine();
        return input.nextLine();
    }

    public static String inputApellido() {
        System.out.print("Apellido: ");
        return input.nextLine();
    }

    public static String inputCredencialUser() {
        System.out.print("Correo o Usuario: ");
        String line = input.nextLine();
        return input.nextLine();
    }

    public static String inputCredencialPassword() {
        System.out.print("Contrasenia: ");
        return input.nextLine();
    }

    public static String inputCorreo() {
        System.out.print("Correo: ");
        return input.nextLine();
    }

    public static String inputUsername() {
        System.out.print("Username: ");
        return input.nextLine();
    }

    public static String inputPassword() {
        System.out.print("Contrasenia: ");
        return input.nextLine();
    }

    public static void menu() {
        char opcion;
        input = new Scanner(System.in);

        do {
            // MENU
            System.out.println("[++MENU PRINCIPAL++]\n");
            System.out.println("[1] INICIAR SESSION");
            System.out.println("[2] REGISTRAR");
            System.out.println("[3] TERMINAR");
            System.out.print("\n OPCION: ");

            opcion = selec_opcion();
            switch (opcion) {
                case '1':
                    login();
                    break;
                case '2':

                    deserializar();

                    addUsuario();

                    serializarLista();

                    break;
                default:
                    break;
            }
        } while (opcion != '3');

    }

    public static void menuSession() {
        char opcion;

        do {
            // MENU
            System.out.println("[++MENU SESSION++]\n");
            System.out.println("[1] CERRAR SESSION");
            System.out.println("[2] MOSTRAR INFORMACION");
            System.out.println("[3] EDITAR NOMBRE");
            System.out.println("[4] EDITAR APELLIDO");
            System.out.println("[5] EDITAR CONTRASENIA");
            System.out.println("[6] ELIMINAR CUENTA");

            System.out.print("\n OPCION: ");

            opcion = selec_opcion();
            switch (opcion) {
                case '1':

                    System.out.println("\n********************************");
                    System.out.println("SESSION CERRADA");
                    System.out.println("********************************\n");
                    break;
                case '2':

                    mostrarInfoUsuarioSession();

                    break;

                case '3':
                    deserializar();

                    updateNombre();
                    serializarLista();

                    break;
                case '4':
                    deserializar();

                    updateApellido();
                    serializarLista();

                    break;
                case '5':
                    deserializar();

                    updatePassword();
                    serializarLista();

                    break;
                case '6':
                    deserializar();

                    removeUsuarioSession();
                    serializarLista();

                    opcion = '1';

                    break;
                default:
                    break;
            }
        } while (opcion != '1');
    }

    public static void updateNombre() {

        Usuario user = buscarUsuarioSession();
        if (user == null) {
            return;
        }

        String nombre = inputNombre();

        user.setNombre(nombre);

        System.out.println("Informacion Actualizada\n");
        return;
    }

    public static void updateApellido() {
        Usuario user = buscarUsuarioSession();
        if (user == null) {
            return;
        }

        System.out.print("Apellido: ");
        String line = input.nextLine();
        String apellido = input.nextLine();

        user.setApellido(apellido);

        System.out.println("Informacion Actualizada\n");
        return;
    }

    public static void updatePassword() {
        Usuario user = buscarUsuarioSession();
        if (user == null) {
            return;
        }

        System.out.print("Pasword: ");
        String line = input.nextLine();
        String pasword = input.nextLine();

        user.setPassword(pasword);

        System.out.println("Informacion Actualizada\n");
        return;
    }

    public static Usuario buscarUsuarioSession() {
        if (usernameSession != null) {
            for (Usuario user : usuarios) {
                if (user.getUsername().equalsIgnoreCase(usernameSession)) {
                    return user;
                }
            }
        } else if (correoSession != null) {
            for (Usuario user : usuarios) {
                if (user.getCorreo().equalsIgnoreCase(correoSession)) {
                    return user;
                }
            }
        }
        return null;
    }

    public static void mostrarInfoUsuarioSession() {

        Usuario user = buscarUsuarioSession();
        if (user == null) {
            return;
        }

        printUsuario(user);
    }

    public static boolean removeUsuarioSession() {
        Usuario user = buscarUsuarioSession();
        if (user == null) {
            return false;
        }

        boolean removed = usuarios.remove(user);
        if (removed) {
            System.out.println("\n********************************");
            System.out.println("Cuenta eliminada correctamente");
            System.out.println("********************************\n");
            usernameSession = null;
            correoSession = null;
        } else {
            System.out.println("No se pudo eliminar la cuenta.");
        }
        return removed;
    }

    public static void printUsuario(Usuario usuario) {
        System.out.println("Nombre : " + usuario.getNombre() + "");
        System.out.println("Apellido : " + usuario.getApellido() + "");
        System.out.println("Correo : " + usuario.getCorreo() + "");
        System.out.println("Usuario : " + usuario.getUsername() + "");
        System.out.println("Contrasenia : " + usuario.getPassword() + "");
    }

    public static char selec_opcion() {
        // TRIM REMUEVE LOS ESPACIOS y CHARAT EXTRAE EL PRIMER CARACTER
        return input.next().trim().charAt(0);
    }


    public static void crearFile() {


        String rutaArchivo = "Usuario.txt"; 


        File archivo = new File(rutaArchivo);


        if (archivo.exists()) {
            return;
        } 

        try (FileOutputStream fos = new FileOutputStream("Usuario.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {

        } catch (Exception e) {

            System.out.println("Archivo Creado");

        }
    }

    public static void serializarLista() {

        try (FileWriter fw = new FileWriter("Usuario.txt", false)) {

            fw.write("");

        } catch (IOException e) {

            e.printStackTrace();

        }

        try (FileOutputStream fos = new FileOutputStream("Usuario.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            // RECORRER LA LISTA DE USUARIOS
            for (Usuario usuario : usuarios) {
                // ESCRIBIR USUARIO EN ARCHIVO
                oos.writeObject(usuario);
            }
            System.out.println("\nObjeto serializado exitosamente en Usuario.txt");

            System.out.printf("\n LISTA: %s", usuarios);

        } catch (IOException e) {
            System.out.println("ERROR AL SERIALIZAR");
            e.printStackTrace();
        }
    }

    public static void deserializar() {

        try (FileInputStream fis = new FileInputStream("Usuario.txt");
                ObjectInputStream ois = new ObjectInputStream(fis)) {

            Usuario usuario;

            // LEER EL USUARIOS DEL ARCHIVO
            while ((usuario = (Usuario) ois.readObject()) != null) {
                // AGREGAR USUARIO A LISTA
                usuarios.add(usuario);
            }

        } catch (EOFException e) {
            // System.out.println("FIN DE ARCHIVO");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR AL DESERIALIZAR");
            e.printStackTrace();
        }
        System.out.printf("\n LISTA: %s", usuarios);
    }

}