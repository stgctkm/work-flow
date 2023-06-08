package workflow.domain.model.user;

/**
 * ユーザーID
 */
public class UserId {
    long value;

    public UserId() {
    }

    public UserId(String value) {
        this.value = Long.parseLong(value);
    }

    public UserId(long value) {
        this.value = value;
    }

    public boolean isSame(UserId other) {
        return value == other.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
