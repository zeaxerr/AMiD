package org.example;

public class Main {
    public static void main(String[] args) {
        Klient klient1 = new Klient("Jan Dzieciol", 1, "ul. Dabrowskiego 1");
        Klient klient2 = new Klient("Anna Maria Nowakowa", 2, "ul. Swiatowa 2123");

        KontoBankowe konto1 = new KontoBankowe(101, 1000.0, klient1);
        KontoBankowe konto2 = new KontoBankowe(102, 500.0, klient2);

        konto1.wplacSrodki(1000.0);
        konto1.wyplacSrodki(2000.0);

        konto2.wplacSrodki(300.0);
        konto2.wyplacSrodki(700.0);

        konto1.wyswietlInformacjeOKliencie();
        konto1.wyswietlInformacjeOKoncie();

        konto2.wyswietlInformacjeOKliencie();
        konto2.wyswietlInformacjeOKoncie();
    }
}
