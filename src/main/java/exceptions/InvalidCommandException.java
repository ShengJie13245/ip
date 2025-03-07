package exceptions;

/**
 * Signals that a invalid command has been provided to the chatbot
 */
public class InvalidCommandException extends Exception{
    public InvalidCommandException(String message){
        super(message);
    }
}