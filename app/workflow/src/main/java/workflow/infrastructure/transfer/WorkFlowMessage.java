package workflow.infrastructure.transfer;

import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.user.UserId;
import workflow.domain.model.workflow.WorkFlowEvent;

public class WorkFlowMessage {

    WorkFlowEvent workFlowEvent;
    ApplicationFormId applicationFormId;
    UserId assignedUserId;

    WorkFlowMessage(WorkFlowEvent workFlowEvent, ApplicationFormId applicationFormId, UserId assignedUserId) {
        this.workFlowEvent = workFlowEvent;
        this.applicationFormId = applicationFormId;
        this.assignedUserId = assignedUserId;
    }

    public static WorkFlowMessage appliedMessage(ApplicationFormId applicationFormId, UserId assignedUserId) {
        return new WorkFlowMessage(WorkFlowEvent.申請, applicationFormId, assignedUserId);
    }
}
