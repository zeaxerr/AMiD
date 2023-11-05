package org.example;

public class Klient {
    private String nazwaKlienta;
    private int numerIdentyfikacyjny;
    private String adres;

    public Klient(String nazwaKlienta, int numerIdentyfikacyjny, String adres) {
        this.nazwaKlienta = nazwaKlienta;
        this.numerIdentyfikacyjny = numerIdentyfikacyjny;
        this.adres = adres;
    }

    public String getNazwaKlienta() {
        return nazwaKlienta;
    }

    public int getNumerIdentyfikacyjny() {
        return numerIdentyfikacyjny;
    }

    public String getAdres() {
        return adres;
    }
}
