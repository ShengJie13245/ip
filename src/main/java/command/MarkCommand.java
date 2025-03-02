package command;

import tasks.TaskManager;

public class MarkCommand extends Command {
    public MarkCommand(String[] arguments){
        super(arguments);
    }

    @Override
    public void execute(){
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
    }
}
