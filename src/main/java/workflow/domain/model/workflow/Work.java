package workflow.domain.model.workflow;

import workflow.domain.model.form.ApplicationFormId;

public class Work {
    ApplicationFormId applicationFormId;
    // TODO UserIDにする
    String assignedUser;

    public Work(ApplicationFormId applicationFormId, String assignedUserName) {
        this.applicationFormId = applicationFormId;
        this.assignedUser= assignedUserName;
    }

    public ApplicationFormId applicationFormId() {
        return applicationFormId;
    }

    public String applicantUser() {
        return assignedUser;
    }
}

