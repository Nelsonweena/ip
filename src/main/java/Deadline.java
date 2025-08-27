public class Deadline extends Task{

    private String dline;

    public Deadline(String input){
        super("");
        String[] i = input.split(" /by ", 2);
        this.description = i[0];
        this.dline =  i[1];
    }

    @Override
    public String toString() {
        return " D " + super.toString() + " (by: " + dline + ")";
    }
}
