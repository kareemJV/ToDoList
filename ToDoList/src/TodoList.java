import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoList {
    private static final String FILE_NAME = "todolist.txt";
    private List<String> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        saveTasksToFile();
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            saveTasksToFile();
        } else {
            System.out.println("Ungültiger Index.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Die ToDo-Liste ist leer.");
        } else {
            System.out.println("ToDo-Liste:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String task : tasks) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der Liste: " + e.getMessage());
        }
    }

    public void loadTasksFromFile() {
        tasks.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(line);
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Laden der Liste: " + e.getMessage());
        }
    }
}

