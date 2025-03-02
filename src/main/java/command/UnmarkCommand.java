package command;

import tasks.TaskManager;

public class UnmarkCommand extends Command{

    public UnmarkCommand(String[] arguments){
        super(arguments);
    }

    @Override
    public void execute(){
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
    }
}

