import java.util.Scanner;

/**
 * Deals with all the interactions with the user, mainly getting the input from user and output messages
 * corresponding to the command requested by user.
 */
public class Ui {
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Reads the next line of input from user
     *
     * @return the next command
     */
    public String getNextCommand() {
        return scanner.nextLine();
    }

    /**
     * Prints an error message according to a certain error
     *
     * @param errorMessage the error message intended to be printed
     */
    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    /**
     * Greets the user at the beginning of the program
     */
    public void greet() {
        String greet = "Hello! I'm Elyk\n" +
                "What can I do for you?\n";
        System.out.println(greet);
    }

    /**
     * Says bye to user before exiting the program
     */
    public void sayBye() {
        String bye = "Bye. Hope to see you again soon!";
        System.out.println(bye);
    }

    /**
     * Prints a message w.r.t. the task being marked done
     *
     * @param task
     */
    public void markTaskDone(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task);
    }

    /**
     * Prints a message w.r.t. the task being marked not done
     *
     * @param task
     */
    public void markTaskNotDone(Task task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task);
    }

    /**
     * Prints a message w.r.t. the task being added and shows the current total no. of tasks
     *
     * @param task
     * @param taskCounter
     */
    public void inputTask(Task task, int taskCounter) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + taskCounter + " tasks in the list.");
    }

    /**
     * Prints a message w.r.t. the task being deleted and shows the current total no. of tasks
     *
     * @param task
     * @param taskCounter
     */
    public void deleteTask(Task task, int taskCounter) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + taskCounter + " tasks in the list.");
    }

    /**
     * Prints a line of message before displaying all the tasks
     */
    public void printTasks() {
        System.out.println("Here are the tasks in your list:");
    }

    /**
     * Prints a single task according to its index in the TaskList
     *
     * @param task
     * @param i
     */
    public void printIndividualTask(Task task, int i) {
        System.out.println((i+1) + "." + task);
    }
}
