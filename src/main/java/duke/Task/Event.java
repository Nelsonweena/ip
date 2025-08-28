package duke.Task;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task{
    private LocalDateTime from;
    private LocalDateTime to;

    public Event(String input){
        super("");
        String[] i = input.split(" /from ", 2);
        this.description = i[0];
        String s = i[1];
        String[] si = s.split(" /to ", 2);

        String fromDateTimeStr = si[0];
        String toDateTimeStr = si[1];
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

    @Override
    public String toString() {
        DateTimeFormatter oFormat = DateTimeFormatter.ofPattern("MMM d yyyy, h:mm a");
        return " E " + super.toString() + " (from: " + from.format(oFormat) + " to: " + to.format(oFormat) + ")";
    }
}
