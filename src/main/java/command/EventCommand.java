package command;

import tasks.Event;
import tasks.TaskManager;

public class EventCommand extends Command {

    public EventCommand(String[] arguments){
        super(arguments);
    }

    @Override
    public void execute() {
        String eventTaskDescription = arguments[0];
        String eventFrom = arguments[1];
        String eventTo = arguments[2];
        Event eventTask = new Event(eventTaskDescription, eventFrom, eventTo);
        TaskManager.addTask(eventTask);
        System.out.println("Added this event task:\n  " + eventTask);
    }
    
}
