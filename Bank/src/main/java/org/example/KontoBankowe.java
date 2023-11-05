package org.example;

public class KontoBankowe {
    public int numerKonta;
    public double saldo;
    public Klient wlascicielKonta;

    public KontoBankowe(int numerKonta, double saldo, Klient wlascicielKonta) {
        this.numerKonta = numerKonta;
        this.saldo = saldo;
        this.wlascicielKonta = wlascicielKonta;
    }

    public int getNumerKonta() {
        return numerKonta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Klient getWlascicielKonta() {
        return wlascicielKonta;
    }

    public void wplacSrodki(double kwota) {
        saldo += kwota;
    }

    public void wyplacSrodki(double kwota) {
        if (kwota <= saldo) {
            saldo -= kwota;
        } else {
            System.out.println("Brak wystarczających środków na koncie.");
        }
    }

    public void wyswietlInformacjeOKliencie() {
        System.out.println("Klient: " + wlascicielKonta.getNazwaKlienta());
        System.out.println("Numer identyfikacyjny klienta: " + wlascicielKonta.getNumerIdentyfikacyjny());
        System.out.println("Adres klienta: " + wlascicielKonta.getAdres());
    }

    public void wyswietlInformacjeOKoncie() {
        System.out.println("Numer konta: " + getNumerKonta());
        System.out.println("Saldo: " + getSaldo());
    }
}
