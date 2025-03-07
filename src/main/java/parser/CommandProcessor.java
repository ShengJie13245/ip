package parser;

import command.ByeCommand;
import command.DeadlineCommand;
import command.DeleteCommand;
import command.EventCommand;
import command.FindCommand;
import command.ListCommand;
import command.MarkCommand;
import command.TodoCommand;
import command.UnmarkCommand;
import exceptions.InvalidCommandException;
import tasks.TaskManager;

/**
 * A command handler to process the command given to the chatbot
 */
public class CommandProcessor {

    private String command;
    private String[] arguments;

    /**
     * Constructs a command handler for further processing of the command. The arguments field should contain
     * values relative to the command   
     * @param command A single word string that tells the chatbot what to do
     * @param arguments An array of strings containing information to be used when processing the command
     */
    public CommandProcessor(String command, String[] arguments){
        this.command = command;
        this.arguments = arguments;
    }

    /**
     * Process and execute this command
     * @return false if bye command was used else true
     * @throws InvalidCommandException
     */
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
        
        case ("find"):
            FindCommand find = new FindCommand(arguments);
            find.execute();
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
