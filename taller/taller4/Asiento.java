package taller.taller4;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Asiento {

    private boolean status;
    private int x;
    private int y;

    public Asiento(int x, int y) {

        this.x = x;
        this.y = y;

    }

    public boolean getStatus(){
        return status;
    }

    public void reservar() {
        this.status = true;
    }

    public void cancelarReserva() {
        this.status = false;
    }

    @Override
    public String toString() {
        return "[" + (this.status ? "X" : " ") + "]";
    }
}