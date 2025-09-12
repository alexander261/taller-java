package taller.taller3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class Persona implements Comparable<Persona> {

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    @Override
    public String toString() {
        return "[" + this.nombre + "," + this.edad + "]";
    }

    @Override
    public boolean equals(Object obj) {
        // SI ES LA MISMA REFERENCIA/OBJETO
        if (this == obj)
            return true;
        // SI EL OBJETO RECIBIDO ES DEL MISMO TIPO DE CLASE
        if (obj == null || getClass() != obj.getClass())
            return false;
        // CASTEAR AL TIPO DE CLASE Y COMPARAR ATRIBUTOS
        // NO NECESARIAMENTE SE REQUIERE COMPARAR TODOS
        Persona otro = (Persona) obj;
        if (nombre != null && nombre.equals(otro.getNombre()))
            return true;
        return false;
    }

    @Override
    public int compareTo(Persona otro) {
        int result = nombre.compareToIgnoreCase(otro.getNombre());
        if (result == 0)
            return Integer.compare(getEdad(), otro.getEdad());
        return result;
    }

    public static Comparator<Persona> COMPARAR_NOMBRE() {
        return new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.compareTo(p2);
            }
        };
    }

    public static Comparator<Persona> COMPARAR_EDAD() {
        return new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                int result = Integer.compare(p1.getEdad(), p2.getEdad());
                if (result == 0)
                    return p1.compareTo(p2);
                return result;
            }
        };
    }
}
