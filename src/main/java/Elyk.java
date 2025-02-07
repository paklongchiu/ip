import java.util.Scanner;

public class Elyk {
    public static int counter = 0;
    public static String[] taskList = new String[100];
    public static Scanner command = new Scanner(System.in);

    public static void main(String[] args) {
        String greet = "Hello! I'm Elyk\n" +
                "What can I do for you?\n";
        String bye = "Bye. Hope to see you again soon!";

        System.out.println(greet);
        String input = command.nextLine();
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                printTask();
            } else {
                inputTask(input);
            }
            input = command.nextLine();
        }

        System.out.println(bye);
    }

    public static void inputTask(String taskName) {
        taskList[counter++] = taskName;
        System.out.println("added: " + taskName);
    }

    public static void printTask() {
        for (int i = 0; i < counter; i++) {
            System.out.println((i+1) + ". " + taskList[i]);
        }
    }
}


