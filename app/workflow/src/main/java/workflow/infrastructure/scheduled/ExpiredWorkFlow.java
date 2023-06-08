package workflow.infrastructure.scheduled;

import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.user.User;
import workflow.domain.primitive.date.DateTime;

public record ExpiredWorkFlow(
        User assignedUser,
        ApplicationFormId applicationFormId,
        DateTime assignedDateTime
) {

}
