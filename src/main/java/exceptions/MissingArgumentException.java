package exceptions;

/**
 * Signals that there is an invalid or missing argument for the command
 */
public class MissingArgumentException extends Exception{

    public MissingArgumentException(String string) {
        super(string);
    }
    
}
