package workflow.domain.model.workflow.history;

import java.util.UUID;

public class WorkFlowHistoryId {
    UUID value;

    public WorkFlowHistoryId(UUID value) {
        this.value = value;
    }

    public static WorkFlowHistoryId newHistoryId() {
        return new WorkFlowHistoryId(UUID.randomUUID());
    }
}
