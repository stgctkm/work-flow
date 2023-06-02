package workflow.domain.model.workflow.history;

import workflow.domain.model.workflow.WorkFlowEvent;
import workflow.domain.primitive.date.DateTime;

public class WorkFlowHistory {

    DateTime datetime;
    WorkFlowEvent workFlowEvent;
    String assignedUser;

    public DateTime datetime() {
        return datetime;
    }

    public WorkFlowEvent workFlowEvent() {
        return workFlowEvent;
    }

    public String assignedUser() {
        return assignedUser;
    }
}
