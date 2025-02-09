import java.util.Scanner;
import java.util.Arrays;

public class Sss {

    private static final String SEPERATOR = "-------------------------";

    public static void main(String[] args) {
        System.out.println("Hello from Sss");
        System.out.println("Nice to meet you");
        Task[] tasks = new Task[100];
        int counter = 0;
        boolean continueProgram = true ;

        while(continueProgram){
            Scanner input = new Scanner(System.in);
            System.out.println(SEPERATOR);
            System.out.println("Enter Command\n");

            InputParser inputString = new InputParser(input.nextLine());
            String command  = inputString.getCommand();
            String arguments[] = inputString.getArguments();
            
            switch(command){
            case ("bye"):
                System.out.println("Goodbye, see you next time");
                continueProgram = false;
                break;
            
            case ("list"):
                for (int i = 0; i<counter; i++){
                    System.out.println((i+1) + "." + tasks[i]);
                }
                System.out.println(SEPERATOR);
                break;
            
            case ("mark"):
                int markIndex = Integer.parseInt(arguments[0].trim()) - 1;
                tasks[markIndex].setDoneStatus(true);
                System.out.println("Marked these:");
                System.out.println(tasks[markIndex].getStatus());
                break;

            case ("unmark"):
                int unmarkIndex = Integer.parseInt(arguments[0].trim()) - 1;
                tasks[unmarkIndex].setDoneStatus(false);
                System.out.println("Unmarked these:");
                System.out.println(tasks[unmarkIndex]);
                break;

            case ("todo"):
                String toDoTaskDescription = arguments[0].trim();
                Todo toDoTask = new Todo(toDoTaskDescription);
                tasks[counter] = toDoTask;
                counter++;
                System.out.println("Added this todo task:\n  " + toDoTask);
                break;
                
            case ("deadline"):
                String deadlineTaskDescription = arguments[0];
                String deadlineBy = arguments[1];
                Deadline deadlineTask = new Deadline(deadlineTaskDescription, deadlineBy);
                tasks[counter] = deadlineTask;
                counter++;
                System.out.println("Added this deadline task:\n  " + deadlineTask);
                break;

            case ("event"):
                String eventTaskDescription = arguments[0];
                String eventFrom = arguments[1];
                String eventTo = arguments[2];
                Event eventTask = new Event(eventTaskDescription, eventFrom, eventTo);
                tasks[counter] = eventTask;
                counter++;
                System.out.println("Added this event task:\n  " + eventTask);
                break;
            } 
        }
    }
}

