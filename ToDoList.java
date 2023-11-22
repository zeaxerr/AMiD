import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<Task> tasks;
    private Scanner scanner;

    public ToDoList() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.run();
    }

    private void run() {
        int option;
        do {
            displayMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println(" ");
            System.out.println(" ");

            switch (option) {
                case 1:
                    addTask();
                    break;
                case 2:
                    markTaskAsCompleted();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    displayTasks();
                    break;
                case 5:
                    System.out.println("Koniec programu.");
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja. Wybierz ponownie.");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    break;
            }
        } while (option != 5);
    }

    private void displayMenu() {
        System.out.println("1. Dodaj nowe zadanie");
        System.out.println("2. Oznacz zadanie jako zakończone");
        System.out.println("3. Usuń zadanie");
        System.out.println("4. Wyświetl listę zadań");
        System.out.println("5. Wyjście");
        System.out.print("Wybierz opcję (1/2/3/4/5): ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    private void addTask() {
        System.out.print("Podaj nazwę zadania: ");
        String name = scanner.nextLine();
        System.out.print("Podaj opis zadania: ");
        String description = scanner.nextLine();

        Task task = new Task(name, description);
        tasks.add(task);

        System.out.println("Zadanie \"" + name + "\" zostało dodane do listy.");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    private void markTaskAsCompleted() {
        if (tasks.isEmpty()){
            displayTasks();
        }else{
            displayTasks();
            System.out.print("Podaj numer zadania do oznaczenia jako zakończone: ");
            int taskNumber = scanner.nextInt();

            if (isValidTaskNumber(taskNumber)) {
                Task task = tasks.get(taskNumber - 1);
                task.setCompleted(true);
                System.out.println("Zadanie \"" + task.getName() + "\" zostało oznaczone jako zakończone.");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            } else {
                System.out.println("Nieprawidłowy numer zadania.");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            }
        }
    }

    private void removeTask() {
        if (tasks.isEmpty()){
            displayTasks();
        }else{
            displayTasks();
            System.out.print("Podaj numer zadania do usunięcia: ");
            int taskNumber = scanner.nextInt();

            if (tasks.isEmpty()){
                System.out.println("(brak zadań)");
            }

            if (isValidTaskNumber(taskNumber)) {
                Task removedTask = tasks.remove(taskNumber - 1);
                System.out.println("Zadanie \"" + removedTask.getName() + "\" zostało usunięte z listy.");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            } else {
                System.out.println("Nieprawidłowy numer zadania.");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            }
        }
    }

    private void displayTasks() {
        System.out.println("Lista zadań:");
        if (tasks.isEmpty()) {
            System.out.println("(brak zadań)");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        }
    }

    private boolean isValidTaskNumber(int taskNumber) {
        return taskNumber >= 1 && taskNumber <= tasks.size();
    }
}
