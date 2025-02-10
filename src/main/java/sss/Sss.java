package sss;

import java.util.Scanner;

import exceptions.InvalidCommandException;
import exceptions.MissingArgumentException;

public class Sss {

    private static final String SEPERATOR = "-------------------------";
    public static void main(String[] args) {
        System.out.println("Hello from Sss");
        System.out.println("Nice to meet you");
        boolean continueProgram = true ;

        while(continueProgram) {
            Scanner input = new Scanner(System.in);
            System.out.println(SEPERATOR);
            System.out.println("Enter Command\n");

            InputParser inputString = new InputParser(input.nextLine());
            try {
                String command  = inputString.getCommand();
                String arguments[] = inputString.getArguments();
                CommandHandler handler = new CommandHandler(command, arguments);
                continueProgram = handler.processCommand(); //return false with bye command else true
            } catch (MissingArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InvalidCommandException e) {
                System.out.println(e.getMessage());
                System.out.println("Some valid commands are deadline, todo, event, list, mark, unmark, bye");
            } 
        } 
    }
}

