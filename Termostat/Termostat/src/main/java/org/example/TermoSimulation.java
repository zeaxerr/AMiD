package org.example;

import java.util.Scanner;

class Termostat {
    private double actTemp = 20.0;
    private double setTemp = 22.0;
    private boolean heatingOn = false;
    private boolean heatingOff = false;

    public void heatingOn() {
        heatingOn = true;
        heatingOff = false;
        System.out.println("Włączono ogrzewanie.");
    }

    public void coolingOn() {
        heatingOff = true;
        heatingOn = false;
        System.out.println("Włączono chłodzenie.");
    }

    public void heatingOff() {
        heatingOn = false;
        System.out.println("Wyłączono ogrzewanie.");
    }

    public void coolingOff() {
        heatingOff = false;
        System.out.println("Wyłączono chłodzenie.");
    }

    public void checkTemp() {

        if (actTemp < setTemp && !heatingOn) {
            heatingOn();
        } else if (actTemp > setTemp && !heatingOff) {
            heatingOn();
            coolingOn();
        } else if (actTemp == setTemp) {
            heatingOff();
            coolingOff();

        }
    }

    public void changeTemp(double newTemp) {
        setTemp = newTemp;
        System.out.println("Ustawiona temperatura zmieniona na " + newTemp + " stopni Cels.");
    }

    public void simulate()
    {
        while(actTemp < setTemp || actTemp > setTemp)
        {
            if (heatingOn)
            {
                actTemp += 0.5;
            }
            else if (heatingOff)
            {
                actTemp -= 0.5;
            }
            System.out.println("Aktualna temperatura: " + actTemp + " stopni Cels.");
            checkTemp();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
public class TermoSimulation
{
    public static void main(String[] args)
    {
        Termostat termostat = new Termostat();
        termostat.simulate();

        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nową temperature");
        String temperatura1 = scan.nextLine();
        float temperatura2 = Float.parseFloat(temperatura1);
        termostat.changeTemp(temperatura2);
        termostat.simulate();
    }
}
