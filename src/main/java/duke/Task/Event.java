package duke.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//Event class for Tasks labelled as event
<<<<<<< HEAD
public class Event extends Task{
    private LocalDateTime from;
    private LocalDateTime to;

    //constructor method for event class
    public Event(String input){
=======
 public class Event extends Task{
    private LocalDateTime from;
    private LocalDateTime to;

    /**
     * constructor method for event class
     *
     * @param input description of event task 
     */
    public Event(String input) {
>>>>>>> branch-A-CodingStandard
        super("");
        String[] inputArr = input.split(" /from ", 2);
        this.description = inputArr[0];
        String temp = inputArr[1];
        String[] fromToArr = temp.split(" /to ", 2);

        String fromDateTimeStr = fromToArr[0];
        String toDateTimeStr = fromToArr[1];
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            this.from = LocalDateTime.parse(fromDateTimeStr, dateTimeFormat);
        } catch (DateTimeParseException e) {
            LocalDate date = LocalDate.parse(fromDateTimeStr, dateFormat);
            this.from = date.atStartOfDay();
        }

        try {
            this.to = LocalDateTime.parse(toDateTimeStr, dateTimeFormat);
        } catch (DateTimeParseException e) {
            LocalDate date = LocalDate.parse(toDateTimeStr, dateFormat);
            this.to = date.atStartOfDay();
        }

    }

    //toString method for event class 
    @Override
    public String toString() {
        DateTimeFormatter oFormat = DateTimeFormatter.ofPattern("MMM d yyyy, h:mm a");
        return " E " + super.toString() + " (from: " + from.format(oFormat) + " to: " + to.format(oFormat) + ")";
    }
}