public class Parser {
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

    public static int getTaskNum(String input) {
        String[] words = input.split(" ");
        return Integer.parseInt(words[1]);
    }

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

    public static String getBy(String input) {
        int byPos = input.indexOf("/by");
        return input.substring(byPos + 4);
    }

    public static String getFrom(String input) {
        int fromPos = input.indexOf("/from");
        int toPos = input.indexOf("/to");
        return input.substring(fromPos + 6, toPos - 1);
    }

    public static String getTo(String input) {
        int toPos = input.indexOf("/to");
        return input.substring(toPos + 4);
    }
}
