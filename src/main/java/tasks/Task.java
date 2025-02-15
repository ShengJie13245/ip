package tasks;

public abstract class Task{
    protected String taskDescription;
    protected boolean isDone;

    public Task(String description){
        this.taskDescription = description;
        this.isDone = false;
    }

    public String getStatus(){
        return (isDone ? "[X] " + taskDescription : "[ ] " + taskDescription);
    }

    public void setDoneStatus(boolean doneStatus){
        this.isDone = doneStatus;
    }

    @Override 
    public String toString() {
        return getStatus();
    }
}
