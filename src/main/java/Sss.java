import java.util.Scanner;
import java.util.Arrays;

public class Sss {
    public static void main(String[] args) {
        System.out.println("Hello from Sss");
        System.out.println("Nice to meet you");
        Task[] tasks = new Task[100];
        int counter = 0;
        boolean continueProgram = true ;
        int index;

        while(continueProgram){
            Scanner input = new Scanner(System.in);
            System.out.println("-------------------------");
            System.out.println("Enter Command\n");

            String inputString = input.nextLine();
            String[] inputArray = inputString.split(" ");
            String command = inputArray[0];
            
            switch(command){
            case ("bye"):
                System.out.println("Goodbye, see you next time");
                continueProgram = false;
                break;
            
            case ("list"):
                for (int i = 0; i<counter; i++){
                    System.out.println((i+1) + "." + tasks[i]);
                }
                System.out.println("-------------------------");
                break;
            
            case ("mark"):
                index = Integer.parseInt(inputArray[1]);
                tasks[index].setDoneStatus(true);
                System.out.println("Marked these:");
                System.out.println(tasks[index].getStatus());
                break;

            case ("unmark"):
                index = Integer.parseInt(inputArray[1]);
                tasks[index].setDoneStatus(false);
                System.out.println("Unmarked these:");
                System.out.println(tasks[index]);
                break;

            default:
                Task newTask = new Task(inputString);
                tasks[counter] = newTask;
                System.out.println("added: " + inputString);
                counter += 1;
                System.out.println("-------------------------");

            } 
        }
    }
}

