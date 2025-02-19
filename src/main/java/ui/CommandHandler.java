package ui;
import exceptions.InvalidCommandException;
import tasks.Deadline;
import tasks.Event;
import tasks.TaskManager;
import tasks.Todo;

public class CommandHandler {
    
    private static final String SEPERATOR = "-------------------------";

    private String command;
    private String[] arguments;

    public CommandHandler(String command, String[] arguments){
        this.command = command;
        this.arguments = arguments;
    }

    public boolean processCommand() throws InvalidCommandException{
        switch(command){
        case ("bye"):
            System.out.println("Goodbye, see you next time");
            return false;
        
        case ("list"):
            TaskManager.printTasks();
            System.out.println(SEPERATOR);
            break;
        
        case ("mark"):
            int markIndex;
            try {
                markIndex = Integer.parseInt(arguments[0].trim()) - 1;
                TaskManager.markTask(markIndex);
                System.out.println("Marked these:");
                System.out.println(TaskManager.getTaskAtIndex(markIndex).getStatus());
            } catch (NumberFormatException e) {
                System.out.println("Please input an integer");
            } catch (IndexOutOfBoundsException | NullPointerException e) {
                if (TaskManager.getCounter() < 1){
                    System.out.println("No tasks right now");
                } else {
                    System.out.println("Please input an integer between 1 and " + TaskManager.getCounter());
                }
            } 
            
            break;

        case ("unmark"):
            try {
                int unmarkIndex = Integer.parseInt(arguments[0].trim()) - 1;
                TaskManager.unmarkTask(unmarkIndex);
                System.out.println("Unmarked these:");
                System.out.println(TaskManager.getTaskAtIndex(unmarkIndex).getStatus());
            } catch (NumberFormatException e) {
                System.out.println("Please input an integer");
            } catch (IndexOutOfBoundsException | NullPointerException e) {
                if (TaskManager.getCounter() < 1){
                    System.out.println("No tasks right now");
                } else {
                    System.out.println("Please input an integer between 1 and " + TaskManager.getCounter());
                }             
            }
            break;

        case ("todo"):
            String toDoTaskDescription = arguments[0].trim();
            Todo toDoTask = new Todo(toDoTaskDescription);
            TaskManager.addTask(toDoTask);
            System.out.println("Added this todo task:\n  " + toDoTask);
            
            break;
            
        case ("deadline"):
            String deadlineTaskDescription = arguments[0];
            String deadlineBy = arguments[1];
            Deadline deadlineTask = new Deadline(deadlineTaskDescription, deadlineBy);
            TaskManager.addTask(deadlineTask);
            System.out.println("Added this deadline task:\n  " + deadlineTask);
            break;

        case ("event"):
            String eventTaskDescription = arguments[0];
            String eventFrom = arguments[1];
            String eventTo = arguments[2];
            Event eventTask = new Event(eventTaskDescription, eventFrom, eventTo);
            TaskManager.addTask(eventTask);
            System.out.println("Added this event task:\n  " + eventTask);
            break;
        default:
            throw new InvalidCommandException("No such command");
        }
        TaskManager.saveTasks();
        return true;
    }
} 
