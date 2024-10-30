package com.example.samochod;

public class HelloApplication {
    private String nazwaMarki;
    private String nazwaModelu;
    private int rokWydania;
    private double liczbaKilometrow;

    public HelloApplication(String nazwaMarki, String nazwaModelu, int rokWydania, double liczbaKilometrow) {
        this.nazwaMarki = nazwaMarki;
        this.nazwaModelu = nazwaModelu;
        this.rokWydania = rokWydania;
        this.liczbaKilometrow = liczbaKilometrow;
    }
    public HelloApplication() {
        this("Brak danych", "Brak danych", 0, 0.0);
    }
    public void pokazSzczegoly() {
        System.out.println("Marka: " + nazwaMarki);
        System.out.println("Model: " + nazwaModelu);
        System.out.println("Rok wydania: " + rokWydania);
        System.out.println("Przebieg: " + liczbaKilometrow + " km");
    }
    public void zaktualizujPrzebieg(double nowyPrzebieg) {
        if (nowyPrzebieg >= liczbaKilometrow) {
            liczbaKilometrow = nowyPrzebieg;
        } else {
            System.out.println("Nowy przebieg nie może być mniejszy od aktualnego.");
        }
    }
    public boolean czyJestStarszyNiz(int rok) {
        return rokWydania < rok;
    }

    public static void main(String[] args) {
        HelloApplication auto = new HelloApplication("Fiucik", "Punto EVO!!", 2011, 283000.00);
        auto.pokazSzczegoly();

        auto.zaktualizujPrzebieg(99999999999.0);
        auto.pokazSzczegoly();

        boolean starsze = auto.czyJestStarszyNiz(2015);
        System.out.println("Czy auto jest starsze niż 2015? " + starsze);

        HelloApplication autoNew = new HelloApplication();
        autoNew.pokazSzczegoly();
    }
}
