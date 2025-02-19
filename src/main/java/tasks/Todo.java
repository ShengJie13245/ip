package tasks;

public class Todo extends Task{
    
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