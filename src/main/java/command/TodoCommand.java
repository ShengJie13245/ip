package command;

import tasks.TaskManager;
import tasks.Todo;

public class TodoCommand extends Command {
    public TodoCommand(String[] arguments){
        super(arguments);
    }

    @Override
    public void execute(){
        String toDoTaskDescription = arguments[0].trim();
        Todo toDoTask = new Todo(toDoTaskDescription);
        TaskManager.addTask(toDoTask);
        System.out.println("Added this todo task:\n  " + toDoTask);        
    }
}
