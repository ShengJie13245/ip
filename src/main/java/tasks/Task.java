package tasks;

public abstract class Task{
    protected String taskDescription;
    protected boolean isDone;

    public Task(String description){
        this.taskDescription = description;
        this.isDone = false;
    }

    public Task(String description, boolean isDone){
        this.taskDescription = description;
        this.isDone = isDone;
    }

    public String getStatus(){
        return (isDone ? "[X] " + taskDescription : "[ ] " + taskDescription);
    }

    public void setDoneStatus(boolean doneStatus){
        this.isDone = doneStatus;
    }

    public String getDescription(){
        return taskDescription;
    }

    public boolean getisDone(){
        return isDone;
    }

    @Override 
    public String toString() {
        return getStatus();
    }
}
