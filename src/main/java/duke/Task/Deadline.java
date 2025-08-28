package duke.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task{

    private LocalDateTime dline;

    public Deadline(String input){
        super("");
        String[] i = input.split(" /by ", 2);
        this.description = i[0];

        String dateTimeStr = i[1];
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            this.dline = LocalDateTime.parse(dateTimeStr, dateTimeFormat);
        } catch (DateTimeParseException e) {
            LocalDate date = LocalDate.parse(dateTimeStr, dateFormat);
            this.dline = date.atStartOfDay();
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter oFormat = DateTimeFormatter.ofPattern("MMM d yyyy, h:mm a");
        return " D " + super.toString() + " (by: " + dline.format(oFormat) + ")";
    }
}
