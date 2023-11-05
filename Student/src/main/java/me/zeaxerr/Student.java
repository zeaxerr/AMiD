package me.zeaxerr;

public class Student {
    private String imie;
    private String nazwisko;
    private double ocena;
    private char plec;
    private String kierunek;
    private boolean zaliczenie;

    public Student(String imie, String nazwisko, double ocena, char plec, String kierunek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ocena = ocena;
        this.plec = plec;
        this.kierunek = kierunek;
    }

    public void WyswietlInformacje() {
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Ocena: " + ocena);
        System.out.println("Płeć: " + plec);
        System.out.println("Kierunek: " + kierunek);
        System.out.println("Zdalx?: " + SprawdzZaliczenie());
    }

    public void ZmienKierunek(String nowyKierunek) {
        this.kierunek = nowyKierunek;
        System.out.println(imie + " " + nazwisko + " zmienil kierunek na: " + nowyKierunek);
    }

    public void ZmienOcene(double nowaOcena) {
        this.ocena = nowaOcena;
        System.out.println(imie + " " + nazwisko + " otrzymal ocene " + nowaOcena);
    }

    public void ZmienImie(String noweImie) {
        this.imie = noweImie;
    }

    public void ZmienNazwisko(String noweNazwisko) {
        this.nazwisko = noweNazwisko;
    }

    public boolean SprawdzZaliczenie() {
        if(ocena<=1.75){
            zaliczenie = false;
        } else {
            zaliczenie = true;
        }
        return zaliczenie;
    }

    public void UstawPlec(char nowaPlec) {
        this.plec = nowaPlec;
    }

    public static double ObliczSredniaOcen(Student[] studenci) {
        double sumaOcen = 0;
        int liczbaStudentow = studenci.length;
        for (Student student : studenci) {
            sumaOcen += student.ocena;
        }
        return sumaOcen / liczbaStudentow;
    }

    public static double WyswietlSredniaOcenaKierunku(Student[] studenci, String kierunek) {
        double sumaOcen = 0;
        int liczbaStudentowNaKierunku = 0;
        for (Student student : studenci) {
            if (student.kierunek.equals(kierunek)) {
                sumaOcen += student.ocena;
                liczbaStudentowNaKierunku++;
            }
        }
        if (liczbaStudentowNaKierunku > 0) {
            return sumaOcen / liczbaStudentowNaKierunku;
        } else {
            return 0.0;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Jan", "Kowalski", 5.9, 'M', "Informatyka");
        student1.WyswietlInformacje();
        student1.ZmienKierunek("Elektronika");
        student1.ZmienOcene(6.0);
        student1.ZmienImie("Mareczek");
        student1.ZmienNazwisko("Nowak");
        student1.UstawPlec('M');

        Student student2 = new Student("Anna Maria", "Kowalska", 1.74, 'K', "Informatyka");

        Student[] studenci = {student1, student2};
        student1.WyswietlInformacje();

        student2.WyswietlInformacje();
        System.out.println("Średnia ocena wszystkich studentów: " + ObliczSredniaOcen(studenci));
        System.out.println("Średnia ocena kierunku Informatyka: " + WyswietlSredniaOcenaKierunku(studenci, "Informatyka"));
    }
}

