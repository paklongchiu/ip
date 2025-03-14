/**
 * A child class of Task class that only contains the description of the tasks
 */
public class Todo extends Task {
    /**
     * Constructor of Todo class
     *
     * @param description description of the task
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Converts the task to printable String argument
     *
     * @return a String representing the task
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}