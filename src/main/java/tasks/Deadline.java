package tasks;

public class Deadline extends Task {
    
    private String by;

    public Deadline(String description, String by){
        super(description);
        this.by = by;
    }

    public Deadline(String description, String by, boolean isDone){
        super(description, isDone);
        this.by = by;
    }

    public String getBy(){
        return by;
    }

    @Override
    public String getStatus(){
        return "[D]" + super.getStatus() + " (by: " + by + ")";
    }
}
