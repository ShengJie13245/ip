public class InputParser {

    private String command;
    private String argumentString;
    private String[] arguments = new String[100];
    
    public InputParser(String input){
        String[] inputArray = input.split(" ", 2);
        this.command = inputArray[0];
        if (inputArray.length > 1){
            this.argumentString = inputArray[1];
        }
    }

    public String getCommand(){
        return command;
    }   

    public String[] getArguments(){
        switch(command){
        case ("mark"):
        case ("unmark"):
            arguments[0] = argumentString;
            break;

        case ("todo"):
            arguments[0] = argumentString;
            System.out.println(arguments[0]);
            break;
                
        case ("deadline"):  
            arguments = argumentString.split("/by");
            for (int i = 0; i <= 1; i++){
                arguments[i] = arguments[i].trim();
            }
            break;

        case("event"):
            this.arguments = argumentString.split("/from | /to");
            for (int i = 0; i <= 2; i++){
                arguments[i] = arguments[i].trim();
            }
            break;
        }

        return arguments;   
    }
}
