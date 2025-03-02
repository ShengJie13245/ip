package command;

import tasks.TaskManager;

public class ListCommand extends Command {

    private static final String SEPERATOR = "-------------------------";

    public ListCommand(){}

    @Override
    public void execute(){
        TaskManager.printTasks();
        System.out.println(SEPERATOR);
    }
}
