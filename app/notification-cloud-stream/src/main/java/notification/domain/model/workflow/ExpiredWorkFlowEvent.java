package notification.domain.model.workflow;

import notification.domain.model.form.ApplicationFormId;
import notification.domain.model.user.User;
import notification.domain.primitive.date.DateTime;

public record ExpiredWorkFlowEvent(
        User assignedUser,
        ApplicationFormId applicationFormId,
        DateTime assignedDateTime
) {

    @Override
    public String toString() {
        return "ExpiredWorkFlowEvent{" +
               "assignedUser=" + assignedUser +
               ", applicationFormId=" + applicationFormId +
               ", assignedDateTime=" + assignedDateTime +
               '}';
    }

    public String toMessage() {
        return "ユーザー %s (ユーザーID = %s) にアサインされたワークフロー（申請ID = %s）が期限を過ぎています.アサイン日時 = %s".formatted(
                assignedUser.name(), assignedUser.userId(), applicationFormId, assignedDateTime
        );
    }
}
