package workflow.domain.model.workflow;

import java.util.UUID;

public class ApplicationFormId {
    UUID value;

    ApplicationFormId() {
    }

    public ApplicationFormId(String value) {
        this(UUID.fromString(value));
    }

    public ApplicationFormId(UUID value) {
        this.value = value;
    }

    public static ApplicationFormId newId() {
        return new ApplicationFormId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
