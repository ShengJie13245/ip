package tasks;

public class Deadline extends Task {
    
    private String by;

    public Deadline(String description, String by){
        super(description);
        this.by = by;
    }

    @Override
    public String getStatus(){
        return "[D]" + super.getStatus() + " (by: " + by + ")";
    }
}
