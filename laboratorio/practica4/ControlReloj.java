
package laboratorio.practica4;

import java.util.Scanner;

import java.util.concurrent.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ControlReloj implements Runnable {
    private Scanner input;

    private Reloj reloj;

    public ControlReloj(Reloj reloj) {

        Thread teclado = new Thread(this);
        this.reloj = reloj;
        teclado.start();
    }

    @Override
    public void run() {

        input = new Scanner(System.in);

        input.nextLine();

        System.err.println("FIN");

        reloj.offPrintTime();

    }
}