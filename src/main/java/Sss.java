import java.util.Scanner;

public class Sss {
    public static void main(String[] args) {
        System.out.println("Hello from Sss");
        System.out.println("Nice to meet you");
        String[] tasks = new String[100];
        int counter = 0;
        boolean continueProgram = true ;

        while(continueProgram){
            Scanner input = new Scanner(System.in);
            System.out.println("-------------------------");
            System.out.println("Enter Command\n");
            
            String command = input.nextLine();
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

            default:   
                tasks[counter] = command;
                System.out.println("added: " + command);
                counter += 1;
                System.out.println("-------------------------");

            } 
        }
    }
}

