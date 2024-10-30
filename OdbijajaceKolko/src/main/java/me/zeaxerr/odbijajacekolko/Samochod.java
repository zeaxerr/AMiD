package me.zeaxerr.odbijajacekolko;

public class Samochod {
    // Składowe klasy
    private String marka;
    private String model;
    private int rokProdukcji;
    private double przebieg;

    // Konstruktor z wartościami początkowymi
    public Samochod(String marka, String model, int rokProdukcji, double przebieg) {
        this.marka = marka;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.przebieg = przebieg;
    }

    // Konstruktor domyślny
    public Samochod() {
        this.marka = "";
        this.model = "";
        this.rokProdukcji = 0;
        this.przebieg = 0.0;
    }

    // Metoda wyświetlająca informacje o samochodzie
    public void wyswietlInformacje() {
        System.out.println("Marka: " + marka);
        System.out.println("Model: " + model);
        System.out.println("Rok produkcji: " + rokProdukcji);
        System.out.println("Przebieg: " + przebieg + " km");
    }

    // Metoda aktualizująca przebieg samochodu
    public void zaktualizujPrzebieg(double nowyPrzebieg) {
        if (nowyPrzebieg >= przebieg) {
            przebieg = nowyPrzebieg;
        } else {
            System.out.println("Nowy przebieg nie może być mniejszy od aktualnego.");
        }
    }

    // Metoda sprawdzająca, czy samochód jest starszy niż podany rok
    public boolean czyJestStarszyNiz(int rok) {
        return rokProdukcji < rok;
    }

    // Gettery i settery (opcjonalnie)
    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(int rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public double getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(double przebieg) {
        this.przebieg = przebieg;
    }
}
