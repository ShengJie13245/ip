package tasks;

/**
 * An event task the stores the time of the event
 */
public class Event extends Task{

    private String from;
    private String to;

    /**
     * Constructs an event object with its description and the time of the event. from should
     * contain the starting time of the event. to should contain the ending time of the event
     * 
     * @param description A String the describe the event
     * @param from A String to represent the starting time of the event
     * @param to A String to represent the ending time of the event
     * @see #Event(String, String, String, boolean)
     */
    public Event(String description, String from, String to){
        super(description);
        this.from = from;
        this.to = to;
    }

    public Event(String description, String from, String to, boolean isDone){
        super(description, isDone);
        this.from = from;
        this.to = to;
    }
    /**
     * Returns the starting time of the event
     * @return starting time of the event
     */
    public String getFrom(){
        return from;
    }

    /**
     * Returns the ending time of the event
     * @return ending time of the event
     */
    public String getTo(){
        return to;
    }

    @Override
    public String getStatus(){
        return "[E]" + super.getStatus() + " (from: " + from + " to: " + to + ")";
    }
}