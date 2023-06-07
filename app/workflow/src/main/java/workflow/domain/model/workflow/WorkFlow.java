package workflow.domain.model.workflow;

import workflow.domain.model.form.ApplicationForm;
import workflow.domain.model.user.User;
import workflow.domain.model.user.UserId;
import workflow.domain.primitive.date.DateTime;

public class WorkFlow {
    ApplicationForm applicationForm;
    WorkFlowEvent workFlowEvent;
    WorkFlowStatus workFlowStatus;
    User assignedUser;
    User applicantUser;
    DateTime appliedDateTime;
    DateTime assignedDateTime;

    public ApplicationForm applicationForm() {
        return applicationForm;
    }

    public WorkFlowEvent workFlowEvent() {
        return workFlowEvent;
    }

    public WorkFlowStatus workFlowStatus() {
        return workFlowStatus;
    }

    public User assignedUser() {
        return assignedUser;
    }

    public User applicantUser() {
        return applicantUser;
    }

    public DateTime appliedDateTime() {
        return appliedDateTime;
    }

    public DateTime assignedDateTime() {
        return assignedDateTime;
    }

    public boolean isAssignedUser(UserId assignedUserId) {
        return this.assignedUser.userId().isSame(assignedUserId);
    }

    public boolean isOnCreating() {
        return workFlowStatus.isOnCreating();
    }

    public boolean isOnApplied() {
        return workFlowStatus.isOnApplied();
    }
}
