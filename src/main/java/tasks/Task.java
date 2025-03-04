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

    /**
     * Returns a String representation of this task. X representing if the task has been completed
     * @return status of the task
     */
    public String getStatus(){
        return (isDone ? "[X] " + taskDescription : "[ ] " + taskDescription);
    }

    /**
     * Sets the status of the task. doneStatus should be true if the task is completed false otherwise
     * @param doneStatus boolean to show if the task is completed
     */
    public void setDoneStatus(boolean doneStatus){
        this.isDone = doneStatus;
    }

    /**
     * Return the description of the task
     * @return description of the task
     */
    public String getDescription(){
        return taskDescription;
    }

    /**
     * Return whether the task is completed
     * @return true if task is completed false otherwise
     */
    public boolean getisDone(){
        return isDone;
    }

    @Override 
    public String toString() {
        return getStatus();
    }
}
