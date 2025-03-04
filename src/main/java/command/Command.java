package command;

public abstract class Command {
    protected String[] arguments;

    public Command(){}

    public Command(String[] arguments){
        this.arguments = arguments;
    }
    /**
     * Executes the command based on its type
     */
    public abstract void execute();
}