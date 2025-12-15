import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dates {
    public int dateAsInt () {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = date.format(formatter);
        return Integer.parseInt(formattedDate);
    }
}