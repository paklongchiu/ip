/**
 * Deals with making sense of the user command, i.e. converting it to actions, task no., task description, etc.
 */
public class Parser {
    /**
     * Convert user's input to an action command
     *
     * @param input line of input from user
     * @return command type to be executed
     */
    public static String updateCommand(String input) {
        if (input.equals("bye")) {
            return "bye";
        } else if (input.equals("list")) {
            return "list";
        } else if (input.startsWith("mark")) {
            return "mark";
        } else if (input.startsWith("unmark")) {
            return "unmark";
        } else if (input.startsWith("delete")) {
            return "delete";
        } else if (input.startsWith("todo")) {
            return "todo";
        } else if (input.startsWith("deadline")) {
            return "deadline";
        } else if (input.startsWith("event")) {
            return "event";
        } else {
            return "default";
        }
    }

    /**
     * Convert user's input to a specific task no.
     *
     * @param input line of input from user
     * @return task no. of the task user is referring to in the input
     */
    public static int getTaskNum(String input) {
        String[] words = input.split(" ");
        return Integer.parseInt(words[1]);
    }

    /**
     * Convert user's input to a specific task description
     *
     * @param input line of input from user
     * @param commandType command type to be executed
     * @return description of the task user is referring to in the input
     */
    public static String getDescription(String input, String commandType) {
        return switch (commandType) {
            case "todo" -> input.substring(5);
            case "deadline" -> {
                int byPos = input.indexOf("/by");
                yield input.substring(9, byPos - 1);
            }
            case "event" -> {
                int fromPos = input.indexOf("/from");
                yield input.substring(6, fromPos - 1);
            }
            default -> "";
        };
    }

    /**
     * Convert user's input to a specific deadline
     *
     * @param input line of input from user
     * @return deadline of the task user is referring to in the input
     */
    public static String getBy(String input) {
        int byPos = input.indexOf("/by");
        return input.substring(byPos + 4);
    }

    /**
     * Convert user's input to a specific start time of an event
     *
     * @param input line of input from user
     * @return start time of the event user is referring to in the input
     */
    public static String getFrom(String input) {
        int fromPos = input.indexOf("/from");
        int toPos = input.indexOf("/to");
        return input.substring(fromPos + 6, toPos - 1);
    }

    /**
     * Convert user's input to a specific end time of an event
     *
     * @param input line of input from user
     * @return end time of the event user is referring to in the input
     */
    public static String getTo(String input) {
        int toPos = input.indexOf("/to");
        return input.substring(toPos + 4);
    }
}
