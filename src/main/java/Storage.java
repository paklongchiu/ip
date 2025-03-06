import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static final String DATA_FOLDER = "./data";
    private static final String DATA_FILE = DATA_FOLDER + "/elyk.txt";

    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();

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
                        tasks.add(task);
                    }
                }
            }
            scanner.close();

        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }

        return tasks;
    }

    public static void saveTasks(ArrayList<Task> tasks) {
        try {
            FileWriter writer = new FileWriter(DATA_FILE);
            for (Task task : tasks) {
                writer.write(convertTaskToString(task) + "\n");
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static String convertTaskToString(Task task) {
        StringBuilder sb = new StringBuilder();

        if (task instanceof Todo) {
            sb.append("T");
        } else if (task instanceof Deadline) {
            sb.append("D");
        } else if (task instanceof Event) {
            sb.append("E");
        }

        sb.append(" | ").append(task.isDone ? "1" : "0");
        sb.append(" | ").append(task.description);

        if (task instanceof Deadline) {
            sb.append(" | ").append(((Deadline) task).by);
        } else if (task instanceof Event) {
            sb.append(" | ").append(((Event) task).from);
            sb.append(" | ").append(((Event) task).to);
        }

        return sb.toString();
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
