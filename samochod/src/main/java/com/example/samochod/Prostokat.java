package com.example.samochod;

public class Prostokat {
    private double dlugosc;
    private double szerokosc;

    public Prostokat() {
        this.dlugosc = 15.0;
        this.szerokosc = 15.0;
    }

    public Prostokat(double dlugosc, double szerokosc) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
    }

    public double obliczPole() {
        return dlugosc * szerokosc;
    }

    public double obliczObwod() {
        return 2 * (dlugosc + szerokosc);
    }

    public void zwiekszWymiary(double procent) {
        dlugosc += dlugosc * procent / 100;
        szerokosc += szerokosc * procent / 100;
    }

    public void zmniejszWymiary(double procent) {
        dlugosc -= dlugosc * procent / 100;
        szerokosc -= szerokosc * procent / 100;
    }

    public double getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(double dlugosc) {
        this.dlugosc = dlugosc;
    }

    public double getSzerokosc() {
        return szerokosc;
    }

    public void setSzerokosc(double szerokosc) {
        this.szerokosc = szerokosc;
    }

    public static void main(String[] args) {
        Prostokat prostokat1 = new Prostokat();
        Prostokat prostokat2 = new Prostokat(5.0, 3.0);

        System.out.println("Prostokąt 1:");
        System.out.println("Długość: " + prostokat1.getDlugosc());
        System.out.println("Szerokość: " + prostokat1.getSzerokosc());
        System.out.println("Pole: " + prostokat1.obliczPole());
        System.out.println("Obwód: " + prostokat1.obliczObwod());

        prostokat1.zwiekszWymiary(50);
        System.out.println("Po zwiększeniu wymiarów o 50%:");
        System.out.println("Długość: " + prostokat1.getDlugosc());
        System.out.println("Szerokość: " + prostokat1.getSzerokosc());
        System.out.println("Pole: " + prostokat1.obliczPole());
        System.out.println("Obwód: " + prostokat1.obliczObwod());

        prostokat1.zmniejszWymiary(300);
        System.out.println("Po zmniejszeniu wymiarów o 25%:");
        System.out.println("Długość: " + prostokat1.getDlugosc());
        System.out.println("Szerokość: " + prostokat1.getSzerokosc());
        System.out.println("Pole: " + prostokat1.obliczPole());
        System.out.println("Obwód: " + prostokat1.obliczObwod());

        System.out.println("\nProstokąt 2:");
        System.out.println("Długość: " + prostokat2.getDlugosc());
        System.out.println("Szerokość: " + prostokat2.getSzerokosc());
        System.out.println("Pole: " + prostokat2.obliczPole());
        System.out.println("Obwód: " + prostokat2.obliczObwod());
    }
}
