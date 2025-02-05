public class Event extends Task{

    private String from;
    private String to;

    public Event(String description, String from, String to){
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getStatus(){
        return "[E]" + super.getStatus() + " (from: " + from + "to: " + to + ")";
    }
}