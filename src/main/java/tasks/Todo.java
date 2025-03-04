package tasks;

/**
 * A Todo task that saves the task to be completed
 */
public class Todo extends Task{
    
    /**
     * Constructs a Todo task with it description
     * @param description A String to describe the Todo task
     * @see #Todo(String, boolean) 
     */
    public Todo(String description){
        super(description);
    }

    public Todo(String description, boolean isDone){
        super(description, isDone);
    }

    @Override
    public String getStatus(){
        return "[T]" + super.getStatus();
    }

}