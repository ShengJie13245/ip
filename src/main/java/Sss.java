import java.util.Scanner;

public class Sss {

    private static final String SEPERATOR = "-------------------------";
    public static void main(String[] args) {
        System.out.println("Hello from Sss");
        System.out.println("Nice to meet you");
        boolean continueProgram = true ;

        while(continueProgram){
            Scanner input = new Scanner(System.in);
            System.out.println(SEPERATOR);
            System.out.println("Enter Command\n");

            InputParser inputString = new InputParser(input.nextLine());
            String command  = inputString.getCommand();
            try {
                String arguments[] = inputString.getArguments();
                CommandHandler handler = new CommandHandler(command, arguments);
                continueProgram = handler.processCommand(); //return false with bye command else true
            } catch (MissingArgumentException e) {
                System.out.println(e.getMessage());
            }
        } 
    }
}
    
