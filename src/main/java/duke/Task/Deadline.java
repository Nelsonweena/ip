package duke.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//deadline class for Tasks labelled as deadline
public class Deadline extends Task{

    private LocalDateTime dline;

    /**
     * constructor method for deadline class
     *
     * @param input description of deadline task 
     */
    public Deadline(String input) {
        super("");
        String[] inputArr = input.split(" /by ", 2);
        this.description = inputArr[0];

        String dateTimeStr = inputArr[1];
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            this.dline = LocalDateTime.parse(dateTimeStr, dateTimeFormat);
        } catch (DateTimeParseException e) {
            LocalDate date = LocalDate.parse(dateTimeStr, dateFormat);
            this.dline = date.atStartOfDay();
        }
    }

    //toString method for deadline classes
    @Override
    public String toString() {
        DateTimeFormatter oFormat = DateTimeFormatter.ofPattern("MMM d yyyy, h:mm a");
        return " D " + super.toString() + " (by: " + dline.format(oFormat) + ")";
    }
}