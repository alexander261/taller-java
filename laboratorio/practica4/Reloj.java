package laboratorio.practica4;

import java.util.concurrent.*;
import java.util.Scanner;

public class Reloj implements Runnable {
    private Thread thread;
    private boolean printTime = false;

    private int segundos;
    private int minutos;
    private int horas;

    public Reloj() {
        this.horas = 23;
        this.minutos = 59;
        this.segundos = 56;

        thread = new Thread(this, "Reloj");

        thread.start();
    }

    @Override
    public void run() {
        boolean status = true;

        while (status) {

            try {

                if (printTime) {

                    printTime();

                }
                Thread.sleep(1000);
                updateTime();

            } catch (InterruptedException e) {
                System.out.println("reloj detenido");
                break;
            }

        }
    }

    public void onPrintTime() {
        this.printTime = true;
    }

    public boolean getStatusPrintTime(){
        return this.printTime;
    }
    public void offPrintTime() {
        this.printTime = false;
    }

    public boolean validateHour(int time) {
        if (time > 23 || time < 0) {
            return false;
        }

        return true;
    }

    public boolean validateMinute(int time) {
        if (time > 60 || time < 0) {
            return false;
        }

        return true;
    }

    public boolean validateSeconds(int time) {
        if (time > 60 || time < 0) {
            return false;
        }

        return true;
    }

    public boolean validateTime(int horas, int minutos, int segundos) {

        if (!validateHour(horas) || !validateMinute(minutos) || !validateSeconds(segundos)) {
            return false;
        }

        return true;
    }

    public void setTime(int horas, int minutos, int segundos) {

        if (!validateTime(horas, minutos, segundos)) {

            System.err.println("Hora No Valida");

            return;
        }

        this.segundos = segundos;
        this.minutos = minutos;
        this.horas = horas;

    }

    public void updateTime() {

        int totalSegundos = (horas * 60 * 60) + (minutos * 60) + segundos + 1;

        int horaEnSegundos = 3600;

        int horas = totalSegundos / horaEnSegundos;
        int minutos = ((totalSegundos % horaEnSegundos) / 60);
        int segundos = totalSegundos % 60;

        if (validateTime(horas, minutos, segundos)) {

            setTime(horas, minutos, segundos);

        } else {

            setTime(0, 0, 0);

        }

    }

    @Override
    public String toString() {
        return formatTime(this.horas) + ":" + formatTime(this.minutos) + ":" + formatTime(this.segundos);
    }

    public void printTime() {
        System.err.println(formatTime(this.horas) + ":" + formatTime(this.minutos) + ":" + formatTime(this.segundos)+""+printTime);
    }

    public String formatTime(int time) {
        if (time >= 10) {
            return "" + time + "";
        }

        return "0" + time;
    }

    public void esperar() {
        try {
            thread.join();
        } catch (InterruptedException e) {
        }
    }
}