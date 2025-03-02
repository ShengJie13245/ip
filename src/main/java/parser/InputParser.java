package parser;
import exceptions.MissingArgumentException;
import java.util.ArrayList;
import java.util.Arrays;

public class InputParser {

    private String command;
    private String argumentString;
    private ArrayList<String> arguments = new ArrayList<>();
    
    public InputParser(String input){
        String[] inputArray = input.split(" ", 2);
        this.command = inputArray[0].toLowerCase();
        if (inputArray.length > 1){
            this.argumentString = inputArray[1];
        }
    }

    public String getCommand(){
        return command;
    }   

    public String[] getArguments() throws MissingArgumentException{
        switch(command){
        case ("mark"):
        case ("unmark"):
        case ("delete"):
            arguments.add(argumentString);
            if (argumentString == null){
                throw new MissingArgumentException("Please use format  \"<command> <integer>\"");
            }
            break;

        case ("todo"):
            arguments.add(argumentString);
            if (argumentString == null){
                throw new MissingArgumentException("Please use format  \"todo <description>\"");
            }
            break;
                
        case ("deadline"):  
            if (argumentString == null){
                throw new MissingArgumentException("Please use format  \"deadline <decription> /by <date>\"");
            }
            arguments.addAll(Arrays.asList(argumentString.split("/by")));
            if (arguments.size() != 2){
                throw new MissingArgumentException("Please use format \"deadline <decription> /by <date>\"");
            }
            for (int i = 0; i <= 1; i++){
                arguments.set(i, arguments.get(i).trim());
            }
            break;

        case("event"):
            if (argumentString == null){
                throw new MissingArgumentException("Please use format  \"event <decription> /by <date>\"");
            }
            arguments.addAll(Arrays.asList(argumentString.split("/from | /to")));
            if (arguments.size() != 3){
                throw new MissingArgumentException("Please use format \"event <decription> /from <date> /to <date> \"");
            }
            for (int i = 0; i <= 2; i++){
                arguments.set(i, arguments.get(i).trim());
            }
            break;
        }
        String[] argumentArray = new String[arguments.size()];
        return arguments.toArray(argumentArray);   
    }
}
