package notification.domain.model.workflow;

import workflow.domain.primitive.date.Date;

public class WorkFlowSearchCriteria {
    Date from;
    Date to;
    boolean assignedOnly;

    public WorkFlowSearchCriteria() {
        this(new Date(), new Date(), true);
    }

    public WorkFlowSearchCriteria(Date from, Date to, boolean assignedOnly) {
        this.from = from;
        this.to = to;
        this.assignedOnly = assignedOnly;
    }

    public Date from() {
        return from;
    }

    public Date to() {
        return to;
    }

    public boolean isAssignedOnly() {
        return assignedOnly;
    }
}
