package workflow.application.service.workflow.workflow;

import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.user.User;
import workflow.domain.model.workflow.Work;

public interface WorkFlowTransfer {
    void notifyApplied(Work work);
    void notifyApproved(ApplicationFormId applicationFormId, User applicantUser);
    void notifyRejected(Work work, User applicantUser);
    void notifyCanceled(ApplicationFormId applicationFormId, User applicantUser);
}
