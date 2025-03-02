package command;

public abstract class Command {
    public String[] arguments;

    public Command(){}

    public Command(String[] arguments){
        this.arguments = arguments;
    }

    public abstract void execute();
}