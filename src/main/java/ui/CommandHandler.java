package ui;

import command.ByeCommand;
import command.DeadlineCommand;
import command.DeleteCommand;
import command.EventCommand;
import command.ListCommand;
import command.MarkCommand;
import command.TodoCommand;
import command.UnmarkCommand;
import exceptions.InvalidCommandException;
import tasks.TaskManager;

public class CommandHandler {

    private String command;
    private String[] arguments;

    public CommandHandler(String command, String[] arguments){
        this.command = command;
        this.arguments = arguments;
    }

    public boolean processCommand() throws InvalidCommandException{
        switch(command){
        case ("bye"):
            ByeCommand bye = new ByeCommand();
            bye.execute();
            return false;
        
        case ("list"):
            ListCommand list = new ListCommand();
            list.execute();
            break;
        
        case ("mark"):
            MarkCommand mark = new MarkCommand(arguments);
            mark.execute();
            break;

        case ("unmark"):
            UnmarkCommand unmark = new UnmarkCommand(arguments);
            unmark.execute();
            break;
            
        case ("delete"):
            DeleteCommand delete = new DeleteCommand(arguments);
            delete.execute();
            break;

        case ("todo"):
            TodoCommand todo = new TodoCommand(arguments);
            todo.execute();
            break;
            
        case ("deadline"):
            DeadlineCommand deadline = new DeadlineCommand(arguments);
            deadline.execute();
            break;

        case ("event"):
            EventCommand event = new EventCommand(arguments);
            event.execute();
            break;
        default:
            throw new InvalidCommandException("No such command");
        }
        TaskManager.saveTasks();
        return true;
    }
} 
