public class Elyk {
    public static int taskNum = 0;
    public static String input = "";
    public static String description = "";
    public static String from = "";
    public static String to = "";
    public static String by = "";
    public static String keyword = "";
    private static Storage storage;
    private static TaskList taskList;
    private static Ui ui;

    public Elyk(String elykFile) {
        ui = new Ui();
        storage = new Storage(elykFile);
        taskList = storage.loadTasks();
    }

    public static void main(String[] args) {
        new Elyk("data/Elyk.txt").run();
    }

    public void run() {
        ui.greet();

        while (true) {
            try {
                input = ui.getNextCommand();
                String commandType = Parser.updateCommand(input);
                switch (commandType) {
                case "bye":
                    ui.sayBye();
                    System.exit(0);
                case "list":
                    ui.printTasks();
                    for (int i = 0; i < taskList.size(); i++) {
                        ui.printIndividualTask(taskList.getTask(i), i);
                    }
                    break;
                case "mark":
                    taskNum = Parser.getTaskNum(input);
                    Task doneTask = taskList.getTask(taskNum - 1);
                    doneTask.markAsDone();
                    ui.markTaskDone(doneTask);
                    storage.saveTasks(taskList);
                    break;
                case "unmark":
                    taskNum = Parser.getTaskNum(input);
                    Task notDoneTask = taskList.getTask(taskNum - 1);
                    notDoneTask.markAsNotDone();
                    ui.markTaskNotDone(notDoneTask);
                    storage.saveTasks(taskList);
                    break;
                case "delete":
                    taskNum = Parser.getTaskNum(input);
                    Task deletedTask = taskList.removeTask(taskNum - 1);
                    ui.deleteTask(deletedTask, taskList.size());
                    storage.saveTasks(taskList);
                    break;
                case "todo":
                    description = Parser.getDescription(input, "todo");
                    Task addedTodo = taskList.addTask(new Todo(description));
                    ui.inputTask(addedTodo, taskList.size());
                    storage.saveTasks(taskList);
                    break;
                case "deadline":
                    description = Parser.getDescription(input, "deadline");
                    by = Parser.getBy(input);
                    Task addedDeadline = taskList.addTask(new Deadline(description, by));
                    ui.inputTask(addedDeadline, taskList.size());
                    storage.saveTasks(taskList);
                    break;
                case "event":
                    description = Parser.getDescription(input, "event");
                    from = Parser.getFrom(input);
                    to = Parser.getTo(input);
                    Task addedEvent = taskList.addTask(new Event(description, from, to));
                    ui.inputTask(addedEvent, taskList.size());
                    storage.saveTasks(taskList);
                    break;
                case "find":
                    keyword = Parser.getKeyword(input);
                    TaskList foundTasks = taskList.findMatchingTasks(keyword);
                    ui.printMatchingTasks();
                    for (int i = 0; i < foundTasks.size(); i++) {
                        ui.printIndividualTask(foundTasks.getTask(i), i);
                    }
                    break;
                default:
                    throw new ElykException();
                }
            } catch (ElykException e) {
                ui.printErrorMessage(" Sorry :( I currently does not support this command, please try again.");
            } catch (IndexOutOfBoundsException e) {
                ui.printErrorMessage(" Hmm... There might be some missing information in your command...");
            }
        }
    }
}
