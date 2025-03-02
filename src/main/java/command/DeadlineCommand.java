package command;

import tasks.Deadline;
import tasks.TaskManager;

public class DeadlineCommand extends Command {
    public DeadlineCommand(String[] arguments){
        super(arguments);
    }

    @Override
    public void execute() {
        String deadlineTaskDescription = arguments[0];
        String deadlineBy = arguments[1];
        Deadline deadlineTask = new Deadline(deadlineTaskDescription, deadlineBy);
        TaskManager.addTask(deadlineTask);
        System.out.println("Added this deadline task:\n  " + deadlineTask);
    }
}
