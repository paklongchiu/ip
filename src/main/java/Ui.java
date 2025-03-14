import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public String getNextCommand() {
        return scanner.nextLine();
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void greet() {
        String greet = "Hello! I'm Elyk\n" +
                "What can I do for you?\n";
        System.out.println(greet);
    }

    public void sayBye() {
        String bye = "Bye. Hope to see you again soon!";
        System.out.println(bye);
    }

    public void markTaskDone(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task);
    }

    public void markTaskNotDone(Task task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task);
    }

    public void inputTask(Task task, int taskCounter) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + taskCounter + " tasks in the list.");
    }

    public void deleteTask(Task task, int taskCounter) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + taskCounter + " tasks in the list.");
    }

    public void printTasks() {
        System.out.println("Here are the tasks in your list:");
    }

    public void printIndividualTask(Task task, int i) {
        System.out.println((i+1) + "." + task);
    }
}
