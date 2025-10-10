package laboratorio.practica3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.io.Serializable;

public class Usuario implements Serializable,Comparable<Usuario>{

    private String nombre;
    private String apellido;
    private String correo;
    private String username;
    private String password;

    public Usuario(String nombre,String apellido,String correo,String username,String password){
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.username = username;
        this.password = password;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getCorreo(){
        return correo;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString() {
        return "[" + this.nombre + "," + this.apellido + "]";
    }

    @Override
    public int compareTo(Usuario otro) {
        int result = username.compareToIgnoreCase(otro.getUsername());
        if (result == 0)
            return apellido.compareToIgnoreCase(otro.getApellido());
        return result;
    }

    public static Comparator<Usuario> COMPARAR_USUARIO(){
        return new Comparator<Usuario>(){
            @Override
            public int compare(Usuario p1,Usuario p2){
                int resultCorreo = p1.correo.compareToIgnoreCase(p2.getCorreo());
                int resultUsername = p1.username.compareToIgnoreCase(p2.getUsername());

                if(resultCorreo == 0 || resultUsername == 0){
                    return 0;
                }

                return resultCorreo;
            }
        };
    }

    public static Comparator<Usuario> COMPARAR_CORREOS_LOGIN(){

        return new Comparator<Usuario>(){
            @Override
            public int compare(Usuario p1,Usuario p2){

                int resultPassword = p1.password.compareToIgnoreCase(p2.getPassword());
                if(resultPassword != 0){
                    return resultPassword;
                }

                return p1.correo.compareToIgnoreCase(p2.getCorreo());
            }
        };
    }

     
    public static Comparator<Usuario> COMPARAR_USERNAMES_LOGIN(){

        return new Comparator<Usuario>(){
            @Override
            public int compare(Usuario p1,Usuario p2){

                int resultPassword = p1.password.compareToIgnoreCase(p2.getPassword());
                if(resultPassword != 0){
                    return resultPassword;
                }

                return p1.username.compareToIgnoreCase(p2.getUsername());
            }
        };
    }
    public static Comparator<Usuario> COMPARAR_CREDENCIALES(){
        return new Comparator<Usuario>(){
            @Override
            public int compare(Usuario p1,Usuario p2){
                int resultPassword = p1.password.compareToIgnoreCase(p2.getPassword());
                
                if(resultPassword != 0){
                    return resultPassword;
                }

                int resultUsername = p1.username.compareToIgnoreCase(p2.getUsername());

                if(resultUsername == 0){
                    return resultUsername;
                }

                int resultCorreo = p1.correo.compareToIgnoreCase(p2.getCorreo());

                return resultCorreo;
            }
        };
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Usuario otro = (Usuario) obj;

        // boolean statusUsername =  this.username == otro.getUsername();
        // if(!statusUsername){
        //     return false;
        // }
        // return this.correo == otro.getCorreo();

        int status1 = username.compareToIgnoreCase(otro.getUsername());
        int status2 = correo.compareToIgnoreCase(otro.getCorreo());

        if(status1 == 0 || status2 == 0){
            return true;
        }

        return false;
    }

}
