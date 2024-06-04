import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();            //creating tasks list to have every tasks
        ArrayList<String> competedtasks= new ArrayList<>();     // creating completed tasks list
        ArrayList<String> Pendingtasks= new ArrayList<>();    // creating pending task list
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- ToDo List Application ---");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Delete Task");
            System.out.println("4. Display all Task");
            System.out.println("5. Pending Task");
            System.out.println("6. Completed Task");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    tasks.add(taskDescription);                    //adding task to tasks list
                    Pendingtasks.add(taskDescription);            // adding  the task to pendingtask list
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    System.out.println(tasks);
                    System.out.println("Enter task index to mark as completed: ");
                    int completedIndex = scanner.nextInt();
                    if (completedIndex >= 0 && completedIndex < tasks.size()) {
                        competedtasks.add(tasks.get(completedIndex));                              //adding task to completed list
                        Pendingtasks.remove(tasks.get(completedIndex));                            //removing task from pending since its completed   
                        System.out.println(tasks.get(completedIndex)+" ------Task marked as completed: "  );
                    } else {
                        System.out.println("Invalid task index.");
                    }
                    break;
                case 3:
                    System.out.println(tasks);
                    System.out.print("Enter task index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    if (deleteIndex >= 0 && deleteIndex < tasks.size()) { 
                        Pendingtasks.remove(tasks.get(deleteIndex));             //deleting the task from all the list
                        competedtasks.remove(tasks.get(deleteIndex));
                        System.out.println(tasks.get(deleteIndex)+" -----Task deleted successfully!");
                        tasks.remove(deleteIndex);
                    } else {
                        System.out.println("Invalid task index.");
                    }
                    break;
                case 4:
                    System.out.println(tasks);
                    break;
                case 5:
                    System.out.println(Pendingtasks);
                    break;
                case 6:
                    System.out.println(competedtasks);
                    break;        
                case 7:
                    System.out.println("Exiting ToDo List Application. Have a great day :) ");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
