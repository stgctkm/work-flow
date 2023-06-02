package workflow.application.service.workflow;

import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.workflow.*;

public interface WorkFlowRepository {
    void register(Work work, WorkFlowEvent workFlowEvent);
    void register(ApplicationFormId applicationFormId, WorkFlowEvent workFlowEvent);
    void registerCreation(Work work, WorkFlowEvent workFlowEvent);

    WorkFlows listOf(String username, WorkFlowSearchCriteria workFlowSearchCriteria);

    WorkFlow workFlowOf(ApplicationFormId applicationFormId);
}
