package amqp.domain.primitive.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTime {
    LocalDateTime value;

    public DateTime() {
    }

    public DateTime(LocalDateTime value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (value == null) return "";
        return value.format(DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss"));
    }


    public DateTime warningDateTime() {
        return new DateTime(value.plus(2, ChronoUnit.DAYS));
    }

    public static DateTime now() {
        return new DateTime(LocalDateTime.now());
    }

    public boolean isBefore(DateTime other) {
        return value.isBefore(other.value);
    }
}
