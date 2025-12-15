
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Date {

    private LocalDate date;

    public Date(String d) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.date = LocalDate.parse(d, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format!");
        }
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getStringDate() {
        return this.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}
