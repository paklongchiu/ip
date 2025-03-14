import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private static final String DATA_FOLDER = "./data";
    private static final String DATA_FILE = DATA_FOLDER + "/elyk.txt";

    public static TaskList loadTasks() {
        TaskList tasks = new TaskList();

        try {
            File directory = new File(DATA_FOLDER);
            if (!directory.exists()) {
                directory.mkdir();
            }

            File file = new File(DATA_FILE);
            if (!file.exists()) {
                file.createNewFile();
                return tasks;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    Task task = parseTaskFromString(line);
                    if (task != null) {
                        tasks.addTask(task);
                    }
                }
            }
            scanner.close();

        } catch (IOException e) {
            System.out.println("There is an error while loading data :(" + e.getMessage());
        }

        return tasks;
    }

    public static void saveTasks(TaskList tasks) {
        try {
            FileWriter writer = new FileWriter(DATA_FILE);
            for (Task task : tasks.getTaskList()) {
                writer.write(convertTaskToString(task) + "\n");
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("There is an error while saving data :(" + e.getMessage());
        }
    }

    private static String convertTaskToString(Task task) {
        StringBuilder stringBuilder = new StringBuilder();

        if (task instanceof Todo) {
            stringBuilder.append("T");
        } else if (task instanceof Deadline) {
            stringBuilder.append("D");
        } else if (task instanceof Event) {
            stringBuilder.append("E");
        }

        stringBuilder.append(" | ").append(task.isDone ? "1" : "0");
        stringBuilder.append(" | ").append(task.description);

        if (task instanceof Deadline) {
            stringBuilder.append(" | ").append(((Deadline) task).by);
        } else if (task instanceof Event) {
            stringBuilder.append(" | ").append(((Event) task).from);
            stringBuilder.append(" | ").append(((Event) task).to);
        }

        return stringBuilder.toString();
    }

    private static Task parseTaskFromString(String line) {
        String[] parts = line.split(" \\| ");

        if (parts.length < 3) {
            return null;
        }

        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        Task task = switch (type) {
            case "T" -> new Todo(description);
            case "D" -> new Deadline(description, parts[3]);
            case "E" -> new Event(description, parts[3], parts[4]);
            default -> null;
        };

        if (task != null && isDone) {
            task.markAsDone();
        }

        return task;
    }
}
