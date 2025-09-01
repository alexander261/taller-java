
package laboratorio.practica2;

import java.util.Comparator;

public class Materia implements Comparable<Materia> {
    private String nombre;
    private int codigo;
    private int creditos;

    public Materia(String nombre, int codigo, int creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public int getCreditos() {
        return this.creditos;
    }

    @Override
    public String toString() {
        return "[" + this.codigo + "-" + this.nombre + "-" + this.creditos + "]";
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Materia otro = (Materia) obj;

        return this.codigo == otro.getCodigo();
    }

    @Override
    public int compareTo(Materia materia) {

        return Integer.compare(this.codigo, materia.getCodigo());
    }

    public static Comparator<Materia> compareToCreditos() {

        return new Comparator<Materia>() {
            @Override
            public int compare(Materia m1, Materia m2) {
                int result = Integer.compare(m1.getCreditos(), m2.getCreditos());

                return result == 0 ? m1.compareTo(m2) : result;
            }
        };
    }

    public static Comparator<Materia> comparatoNombres() {

        return new Comparator<Materia>() {
            @Override
            public int compare(Materia m1, Materia m2) {

                // int result = m1.getNombre().compareTo(m2.getNombre());
                int result = m1.getNombre().compareToIgnoreCase(m2.getNombre());

                return result == 0 ? m1.compareTo(m2) : result;
            }
        };
    }

    public static Comparator<Materia> comparatoCodigo(){
        return new Comparator<Materia>(){
            @Override
            public int compare(Materia m1,Materia m2){
                return m1.compareTo(m2);
            }
        };
    }

}