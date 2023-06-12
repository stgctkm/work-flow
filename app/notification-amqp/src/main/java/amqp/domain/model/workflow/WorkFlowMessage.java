package amqp.domain.model.workflow;


import amqp.domain.model.form.ApplicationFormId;
import amqp.domain.model.user.UserId;

public record WorkFlowMessage(
        WorkFlowEvent workFlowEvent,
        ApplicationFormId applicationFormId,
        UserId assignedUserId
) {

    @Override
    public String toString() {
        return "WorkFlowMessage{" +
               "workFlowEvent=" + workFlowEvent +
               ", applicationFormId=" + applicationFormId +
               ", assignedUserId=" + assignedUserId +
               '}';
    }

    public String toMessage() {
        return switch (workFlowEvent) {
            case 申請 -> "申請（申請ID: %s) が ユーザー(ユーザーID %s) 申請されました".formatted(applicationFormId, assignedUserId);
            case 承認 -> "ユーザー(ユーザーID %s)の申請（申請ID: %s) が 承認されました".formatted(applicationFormId, assignedUserId);
            case 差戻し -> "ユーザー(ユーザーID %s)の申請（申請ID: %s) が 差し戻されました".formatted(applicationFormId, assignedUserId);
            case 却下 -> "ユーザー(ユーザーID %s)の申請（申請ID: %s) が 却下されました".formatted(applicationFormId, assignedUserId);
        };
    }
}
