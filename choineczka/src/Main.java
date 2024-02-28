import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę poziomów choinki: ");
        int n = scanner.nextInt();

        rysujChoinke(n);
        rysujDrzewo(n);
    }

    static void rysujChoinke(int poziomy) {
        for (int i = 0; i < poziomy; i++) {
            for (int j = 0; j < poziomy - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("X");
            }
            System.out.println();
        }
    }

    static void rysujDrzewo(int poziomy) {
        for (int i = 0; i < poziomy / 3; i++) {
            for (int j = 0; j < poziomy - 1; j++) {
                System.out.print(" ");
            }
            System.out.println("X");
        }
    }
}
