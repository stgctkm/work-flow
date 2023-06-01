package workflow.domain.primitive.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        return value.format(DateTimeFormatter.ofPattern("uuuu-MM-dd hh:mm:ss"));
    }
}
