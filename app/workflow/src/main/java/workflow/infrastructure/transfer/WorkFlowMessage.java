package workflow.infrastructure.transfer;

import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.user.UserId;
import workflow.domain.model.workflow.WorkFlowEvent;

public record WorkFlowMessage(
    WorkFlowEvent workFlowEvent,
    ApplicationFormId applicationFormId,
    UserId assignedUserId
) {

    public static WorkFlowMessage appliedMessage(ApplicationFormId applicationFormId, UserId assignedUserId) {
        return new WorkFlowMessage(WorkFlowEvent.申請, applicationFormId, assignedUserId);
    }

    public static WorkFlowMessage approvedMessage(ApplicationFormId applicationFormId, UserId assignedUserId) {
        return new WorkFlowMessage(WorkFlowEvent.承認, applicationFormId, assignedUserId);
    }

    public static WorkFlowMessage rejectedMessage(ApplicationFormId applicationFormId, UserId assignedUserId) {
        return new WorkFlowMessage(WorkFlowEvent.差戻し, applicationFormId, assignedUserId);
    }

    public static WorkFlowMessage canceledMessage(ApplicationFormId applicationFormId, UserId assignedUserId) {
        return new WorkFlowMessage(WorkFlowEvent.却下, applicationFormId, assignedUserId);
    }
}
