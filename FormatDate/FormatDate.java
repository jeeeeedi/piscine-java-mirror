import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'Le' dd MMM 'de l''an' yyyy 'à' HH'h'mm'm et' ss's'", Locale.FRANCE);
            return dateTime.format(formatter);
        } catch (Exception e) {
            return null;
        }
    }

    public static String formatSimple(LocalDate date) {
        if (date == null) return null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd yy", Locale.ITALY);
            return date.format(formatter);
        } catch (Exception e) {
            return null;
        }
    }

    public static String formatIso(LocalTime time) {
        if (time == null) return null;
        try {
            return time.format(DateTimeFormatter.ISO_LOCAL_TIME);
        } catch (Exception e) {
            return null;
        }
    }

}