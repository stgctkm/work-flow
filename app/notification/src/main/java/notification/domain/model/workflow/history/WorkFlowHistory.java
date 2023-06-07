package notification.domain.model.workflow.history;

import workflow.domain.model.user.User;
import workflow.domain.model.workflow.WorkFlowEvent;
import workflow.domain.primitive.date.DateTime;

public class WorkFlowHistory {

    DateTime datetime;
    WorkFlowEvent workFlowEvent;
    User assignedUser;

    public DateTime datetime() {
        return datetime;
    }

    public WorkFlowEvent workFlowEvent() {
        return workFlowEvent;
    }

    public User assignedUser() {
        return assignedUser;
    }
}
