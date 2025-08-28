import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class DifferenceBetweenDate {

    public static Duration durationBetweenTime(LocalTime localTime1, LocalTime localTime2) {
        if (localTime1 == null || localTime2 == null) {
            return null;
        }
        // Ensure we always compute from the earlier to the later to keep it positive
        if (localTime1.isAfter(localTime2)) {
            LocalTime tmp = localTime1;
            localTime1 = localTime2;
            localTime2 = tmp;
        }
        return Duration.between(localTime1, localTime2);
    }

    public static Period periodBetweenDate(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) {
            return null;
        }
        if (date1.isAfter(date2)) {
            LocalDate tmp = date1;
            date1 = date2;
            date2 = tmp;
        }
        return Period.between(date1, date2);
    }

    public static Long numberOfHoursBetweenDateTime(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        if (dateTime1 == null || dateTime2 == null) {
            return null;
        }
        if (dateTime1.isAfter(dateTime2)) {
            LocalDateTime tmp = dateTime1;
            dateTime1 = dateTime2;
            dateTime2 = tmp;
        }
        return Duration.between(dateTime1, dateTime2).toHours();
    }

}