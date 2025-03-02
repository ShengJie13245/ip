package command;

public class ByeCommand extends Command {
    public ByeCommand(){
        super();
    }

    @Override
    public void execute(){
        System.out.println("Goodbye, see you next time");
    }
}
