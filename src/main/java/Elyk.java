import java.util.Scanner;

public class Elyk {
    public static int taskCounter = 0;
    public static int taskNum = 0;
    public static String input = "";
    public static String description = "";
    public static String from = "";
    public static String to = "";
    public static String by = "";
    public static Task[] taskList = new Task[100];
    public static Scanner command = new Scanner(System.in);

    public static void main(String[] args) {
        greet();

        while (true) {
            try {
                updateInput();
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
                case "todo":
                    taskList[taskCounter++] = new Todo(description);
                    inputTask();
                    break;
                case "deadline":
                    taskList[taskCounter++] = new Deadline(description, by);
                    inputTask();
                    break;
                case "event":
                    taskList[taskCounter++] = new Event(description, from, to);
                    inputTask();
                    break;
                default:
                    throw new ElykException();
                }
            } catch (ElykException e) {
                System.out.println(" Sorry :( I currently does not support this command, please try again.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println(" Hmm... There might be some missing information in your command...");
            }
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
        if (input.startsWith("mark") || input.startsWith("unmark")) {
            String[] words = input.split(" ");
            input = words[0];
            taskNum = Integer.parseInt(words[1]);
        } else if (input.startsWith("todo")) {
            description = input.substring(5);
            input = "todo";
        } else if (input.startsWith("deadline")) {
            int byPos = input.indexOf("/by");
            by = input.substring(byPos + 4);
            description = input.substring(9, byPos - 1);
            input = "deadline";
        } else if (input.startsWith("event")) {
            int fromPos = input.indexOf("/from");
            int toPos = input.indexOf("/to");
            to = input.substring(toPos + 4);
            from = input.substring(fromPos + 6, toPos - 1);
            description = input.substring(6, fromPos - 1);
            input = "event";
        }
    }

    public static void markTaskDone(int taskNum) {
        taskList[taskNum - 1].markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + taskList[taskNum - 1]);
    }

    public static void markTaskNotDone(int taskNum) {
        taskList[taskNum - 1].markAsNotDone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + taskList[taskNum - 1]);
    }

    public static void inputTask() {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + taskList[taskCounter - 1]);
        System.out.println("Now you have " + taskCounter + " tasks in the list.");
    }

    public static void printTask() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskCounter; i++) {
            System.out.println((i+1) + "." + taskList[i]);
        }
    }
}
