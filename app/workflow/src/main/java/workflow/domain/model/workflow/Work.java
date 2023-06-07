package workflow.domain.model.workflow;

import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.user.UserId;

public class Work {
    ApplicationFormId applicationFormId;
    UserId assignedUserId;

    public Work(ApplicationFormId applicationFormId, UserId assignedUserId) {
        this.applicationFormId = applicationFormId;
        this.assignedUserId = assignedUserId;
    }

    public ApplicationFormId applicationFormId() {
        return applicationFormId;
    }

    public UserId assignedUserId() {
        return assignedUserId;
    }

}

