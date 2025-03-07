package tasks;

/**
 * A deadline task that stores the deadline of this task
 */
public class Deadline extends Task {
    
    private String by;

    /**
     * Constructs a deadline task with the description and time it should be completed by
     * @param description A String to describe the task
     * @param by A String with the Deadline of the task
     * @see #Deadline(String description, String by, boolean isDone)
     */
    public Deadline(String description, String by){
        super(description);
        this.by = by;
    }

    public Deadline(String description, String by, boolean isDone){
        super(description, isDone);
        this.by = by;
    }

    /**
     * Return the deadline of this task specified by the user
     * @return deadline to complete the task by
     */
    public String getBy(){
        return by;
    }

    @Override
    public String getStatus(){
        return "[D]" + super.getStatus() + " (by: " + by + ")";
    }
}
