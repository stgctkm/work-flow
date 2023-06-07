package workflow.domain.primitive.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 日付
 */
public class Date {
    LocalDate value;

    public Date() {
    }

    public Date(LocalDate value) {
        this.value = value;
    }

    public Date(String value) {
        if (value.isEmpty()) return;
        this.value = LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public LocalDate value() {
        return value;
    }

    public boolean isEmpty() {
        return value == null;
    }

    @Override
    public String toString() {
        if (value == null) return "";
        return value.format(DateTimeFormatter.ofPattern("uuuu-MM-dd"));
    }

    public boolean isBefore(Date other) {
        if (value == null) return false;
        return value.isBefore(other.value);
    }
}
