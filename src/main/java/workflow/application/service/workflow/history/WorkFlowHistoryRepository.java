package workflow.application.service.workflow.history;

import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.workflow.history.WorkFlowHistories;

public interface WorkFlowHistoryRepository {
    WorkFlowHistories histories(ApplicationFormId applicationFormId);
}
