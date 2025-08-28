import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null) return null;
        try {
            return LocalDateTime.parse(stringDate);
        } catch (Exception e) {
            return null;
        }
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null) return null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", Locale.FRANCE);
            return LocalDate.parse(stringDate, formatter);
        } catch (Exception e) {
            return null;
        }
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null) return null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh 'heures' B, mm 'minutes et' ss 'secondes'", Locale.FRANCE);
            return LocalTime.parse(stringDate, formatter);
        } catch (Exception e) {
            return null;
        }
    }

}