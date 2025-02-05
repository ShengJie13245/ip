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

            String inputString = input.nextLine();
            String[] inputArray = inputString.split(" ");
            String command = inputArray[0];
            int firstSpaceIndex = inputString.indexOf(" ");
            
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
                int markIndex = Integer.parseInt(inputArray[1]) - 1;
                tasks[markIndex].setDoneStatus(true);
                System.out.println("Marked these:");
                System.out.println(tasks[markIndex].getStatus());
                break;

            case ("unmark"):
                int unmarkIndex = Integer.parseInt(inputArray[1]) - 1;
                tasks[unmarkIndex].setDoneStatus(false);
                System.out.println("Unmarked these:");
                System.out.println(tasks[unmarkIndex]);
                break;

            case ("todo"):
                String toDoTaskDescription = inputString.substring(firstSpaceIndex);
                Todo toDoTask = new Todo(toDoTaskDescription);
                tasks[counter] = toDoTask;
                counter++;
                System.out.println("Added this todo task:\n  " + toDoTask);
                break;
                
            case ("deadline"):
                int startByCommandIndex = inputString.indexOf("/by");
                int endByCommandIndex = startByCommandIndex + 4;
                String deadlineTaskDescription = inputString.substring(firstSpaceIndex, startByCommandIndex);
                String deadlineBy = inputString.substring(endByCommandIndex);
                Deadline deadlineTask = new Deadline(deadlineTaskDescription, deadlineBy);
                tasks[counter] = deadlineTask;
                counter++;
                System.out.println("Added this deadline task:\n  " + deadlineTask);
                break;

            case ("event"):
                int startFromCommandIndex = inputString.indexOf("/from");
                int endFromCommandIndex = startFromCommandIndex + 6;
                int startToCommandIndex = inputString.indexOf("/to");
                int endToCommandIndex = startToCommandIndex + 4;
                String eventTaskDescription = inputString.substring(firstSpaceIndex, startFromCommandIndex);
                String eventFrom = inputString.substring(endFromCommandIndex, startToCommandIndex);
                String eventTo = inputString.substring(endToCommandIndex);
                Event eventTask = new Event(eventTaskDescription, eventFrom, eventTo);
                tasks[counter] = eventTask;
                counter++;
                System.out.println("Added this event task:\n  " + eventTask);
                break;

            default:
                Task newTask = new Task(inputString);
                tasks[counter] = newTask;
                System.out.println("Added: " + inputString);
                counter += 1;
                System.out.println(SEPERATOR);
            } 
        }
    }
}

