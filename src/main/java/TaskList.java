import java.util.ArrayList;

/**
 * Contains the task list represented by "tasks" and operations related to it, e.g. to add/delete task in the list
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Default constructor of a Task List object
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a specific task to the task list
     *
     * @param task task added to the task list
     * @return the task added to the task list
     */
    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    /**
     * Removes a specific task from the task list
     *
     * @param index index of the task removed from the task list
     * @return the task removed from the task list
     */
    public Task removeTask(int index) {
        return tasks.remove(index);
    }

    /**
     * Gets a specific task from the task list
     *
     * @param index index of the task obtained from the taskList
     * @return the task obtained from the taskList
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Gets the size of the task list
     *
     * @return size of the task list
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Gets a task list in the form of ArrayList<Task>
     *
     * @return an ArrayList<Task> object representing the full task list
     */
    public ArrayList<Task> getTaskList() {
        return tasks;
    }
}