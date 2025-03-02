package command;

import tasks.TaskManager;

public class DeleteCommand extends Command {
    public DeleteCommand(String[] arguments){
        super(arguments);
    }

    @Override
    public void execute(){
        try {
            int deleteIndex = Integer.parseInt(arguments[0].trim()) - 1;
            String deletedTask = TaskManager.getTaskAtIndex(deleteIndex).getStatus();
            TaskManager.deleteTask(deleteIndex);
            System.out.println("Deleted these:");
            System.out.println(deletedTask);
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
