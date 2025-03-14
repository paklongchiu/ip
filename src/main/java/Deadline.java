/**
 * A child class of Task class that contains the description and deadline of the tasks
 */
public class Deadline extends Task {

    protected String by;

    /**
     * Constructor of Deadline class
     *
     * @param description descriptionof the task
     * @param by deadline of the task
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Converts the task to printable String argument
     *
     * @return a String representing the task
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
