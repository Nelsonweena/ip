public class Event extends Task{
    private String from;
    private String to;

    public Event(String input){
        super("");
        String[] i = input.split(" /from ", 2);
        this.description = i[0];
        String s = i[1];
        String[] si = s.split(" /to ", 2);
        this.from = si[0];
        this.to = si[1];
    }

    @Override
    public String toString() {
        return " E " + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
