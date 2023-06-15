import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.loadTasksFromFile();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Was möchten Sie tun?");
            System.out.println("1. Aufgabe hinzufügen");
            System.out.println("2. Aufgabe entfernen");
            System.out.println("3. Aufgaben anzeigen");
            System.out.println("4. Beenden");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Zeilenumbruch verbrauchen

            switch (choice) {
                case 1:
                    System.out.print("Geben Sie die Aufgabe ein: ");
                    String task = scanner.nextLine();
                    todoList.addTask(task);
                    break;
                case 2:
                    System.out.print("Geben Sie den Index der zu entfernenden Aufgabe ein: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Zeilenumbruch verbrauchen
                    todoList.removeTask(index - 1);
                    break;
                case 3:
                    todoList.displayTasks();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Ungültige Eingabe.");
                    break;
            }
        }
    }
}
