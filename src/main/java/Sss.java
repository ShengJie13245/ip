import java.util.Scanner;

public class Sss {
    public static void main(String[] args) {
        System.out.println("Hello from Sss\n");
        System.out.println("Nice to meet you");

        while(true){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Command");
            System.out.println("-------------------------");


            String command = input.nextLine();
            if(command.equalsIgnoreCase("Bye")){
                System.out.println("Goodbye, see you next time");
                break;
            } else {
                System.out.println(command);
                System.out.println("-------------------------");
            }
        }
    }
}
