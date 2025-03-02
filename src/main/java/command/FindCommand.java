package command;

import java.util.ArrayList;

import tasks.Task;
import tasks.TaskManager;

public class FindCommand extends Command{

    public FindCommand(String[] arguments){
        super(arguments);
    }

    public void execute(){
        ArrayList<Task> matchingTasks = new ArrayList<>();

        int counter = TaskManager.getCounter();

        for (int i = 0; i<counter; i++){
            Task task = TaskManager.getTaskAtIndex(i);
            String taskDescription = task.getDescription();
            if(taskDescription.contains(arguments[0])){
                matchingTasks.add(task);
            }
        }

        System.out.println("Tasks with keyword \"" + arguments[0] + "\" are:");

        for (int i = 0; i<matchingTasks.size(); i++){
            System.out.println((i+1) + "." + matchingTasks.get(i));
        }

    }
}
