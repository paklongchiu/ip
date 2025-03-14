/**
 * A child class of Task class that contains the description, start and end time of the tasks
 */
public class Event extends Task {

    protected String from;
    protected String to;

    /**
     * Constructor of Event class
     *
     * @param description description of the task
     * @param from start time of the task
     * @param to end time of the task
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Converts the task to printable String argument
     *
     * @return a String representing the task
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}