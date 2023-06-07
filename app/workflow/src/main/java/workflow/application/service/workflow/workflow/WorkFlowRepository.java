package workflow.application.service.workflow.workflow;

import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.user.UserId;
import workflow.domain.model.workflow.*;

public interface WorkFlowRepository {
    void register(Work work, WorkFlowEvent workFlowEvent);
    void register(ApplicationFormId applicationFormId, WorkFlowEvent workFlowEvent);
    void registerCreation(Work work, WorkFlowEvent workFlowEvent);

    WorkFlows listOf(UserId userId, WorkFlowSearchCriteria workFlowSearchCriteria);

    WorkFlow workFlowOf(ApplicationFormId applicationFormId);

    WorkFlows list();
}
