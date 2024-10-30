package com.example.demo2;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Samochod extends Application{
    private String marka;
    private String model;
    private int rokProdukcji;
    private double przebieg;

    public Samochod(String marka, String model, int rokProdukcji, double przebieg) {
        this.marka = marka;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.przebieg = przebieg;
    }

    public Samochod() {
        this.marka = "";
        this.model = "";
        this.rokProdukcji = 0;
        this.przebieg = 0.0;
    }

    public void wyswietlInformacje() {
        System.out.println("Marka: " + marka);
        System.out.println("Model: " + model);
        System.out.println("Rok produkcji: " + rokProdukcji);
        System.out.println("Przebieg: " + przebieg + " km");
    }

    public void zaktualizujPrzebieg(double nowyPrzebieg) {
        if (nowyPrzebieg >= przebieg) {
            przebieg = nowyPrzebieg;
        } else {
            System.out.println("Nowy przebieg nie może być mniejszy od aktualnego.");
        }
    }

    public boolean czyJestStarszyNiz(int rok) {
        return rokProdukcji < rok;
    }

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
    @Override
    public void start(Stage stage) throws Exception {

    }
}