import java.util.Scanner;

public class Elyk {
    public static int taskCounter = 0;
    public static int taskNum = 0;
    public static String input = "";
    public static Task[] taskList = new Task[100];
    public static Scanner command = new Scanner(System.in);

    public static void main(String[] args) {
        greet();
        updateInput();

        while (true) {
            switch (input) {
                case "bye":
                    sayBye();
                    System.exit(0);
                case "list":
                    printTask();
                    break;
                case "mark":
                    markTaskDone(taskNum);
                    break;
                case "unmark":
                    markTaskNotDone(taskNum);
                    break;
                default:
                    inputTask(input);
            }
            updateInput();
        }
    }

    public static void greet() {
        String greet = "Hello! I'm Elyk\n" +
                "What can I do for you?\n";
        System.out.println(greet);
    }

    public static void sayBye() {
        String bye = "Bye. Hope to see you again soon!";
        System.out.println(bye);
    }

    public static void updateInput() {
        input = command.nextLine();
        if (input.matches(".*\\d$")) {
            String[] words = input.split(" ");
            input = words[0];
            taskNum = Integer.parseInt(words[1]);
        }
    }

    public static void markTaskDone(int taskNum) {
        taskList[taskNum - 1].markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  [X] " + taskList[taskNum - 1].description);
    }

    public static void markTaskNotDone(int taskNum) {
        taskList[taskNum - 1].markAsNotDone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  [ ] " + taskList[taskNum - 1].description);
    }

    public static void inputTask(String taskName) {
        taskList[taskCounter++] = new Task(taskName);
        System.out.println("added: " + taskName);
    }

    public static void printTask() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskCounter; i++) {
            System.out.println((i+1) + ".[" + taskList[i].getStatusIcon() + "] " + taskList[i].description);
        }
    }
}


