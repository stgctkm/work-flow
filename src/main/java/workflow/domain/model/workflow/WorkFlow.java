package workflow.domain.model.workflow;

import workflow.domain.primitive.date.DateTime;

public class WorkFlow {
    ApplicationForm applicationForm;
    WorkFlowEvent workFlowEvent;
    WorkFlowStatus workFlowStatus;
    String assignedUser;
    String applicantUser;
    DateTime appliedDateTime;

    public ApplicationForm applicationForm() {
        return applicationForm;
    }

    public WorkFlowEvent workFlowEvent() {
        return workFlowEvent;
    }

    public WorkFlowStatus workFlowStatus() {
        return workFlowStatus;
    }

    public String assignedUser() {
        return assignedUser;
    }

    public String applicantUser() {
        return applicantUser;
    }

    public DateTime appliedDateTime() {
        return appliedDateTime;
    }
}
