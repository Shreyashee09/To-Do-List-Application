import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    static class Task {
        String description;
        boolean isCompleted;

        Task(String description) {
            this.description = description;
            this.isCompleted = false;
        }

        public void markComplete() {
            this.isCompleted = true;
        }

        @Override
        public String toString() {
            return (isCompleted ? "[✓] " : "[ ] ") + description;
        }
    }

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1 -> addTask();
                case 2 -> deleteTask();
                case 3 -> markTaskAsComplete();
                case 4 -> displayTasks();
                case 5 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    static void printMenu() {
        System.out.println("\n--- TO-DO LIST MENU ---");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Mark Task as Complete");
        System.out.println("4. Display Tasks");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    static void addTask() {
        System.out.print("Enter task description: ");
        String desc = scanner.nextLine();
        tasks.add(new Task(desc));
        System.out.println("Task added.");
    }

    static void deleteTask() {
        displayTasks();
        System.out.print("Enter task number to delete: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    static void markTaskAsComplete() {
        displayTasks();
        System.out.print("Enter task number to mark as complete: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markComplete();
            System.out.println("Task marked as complete.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is empty!");
        } else {
            System.out.println("\nYour Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
