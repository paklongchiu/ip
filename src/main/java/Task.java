/**
 * An abstract class that provides a basic template of a Task object
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor of Task class
     *
     * @param description description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Convert the task's status of marked/not marked into something printable
     *
     * @return a symbol that represents whether a task is marked or not
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Mark a task as done
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Mark a task as not done
     */
    public void markAsNotDone() {
        isDone = false;
    }

    /**
     * Converts the task to printable String argument
     *
     * @return a String representing the task
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
