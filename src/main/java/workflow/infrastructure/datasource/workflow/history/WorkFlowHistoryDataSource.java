package workflow.infrastructure.datasource.workflow.history;

import org.springframework.stereotype.Repository;
import workflow.application.service.workflow.history.WorkFlowHistoryRepository;
import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.workflow.history.WorkFlowHistories;

@Repository
public class WorkFlowHistoryDataSource implements WorkFlowHistoryRepository {

    WorkFlowHistoryMapper workFlowHistoryMapper;

    WorkFlowHistoryDataSource(WorkFlowHistoryMapper workFlowHistoryMapper) {
        this.workFlowHistoryMapper = workFlowHistoryMapper;
    }

    @Override
    public WorkFlowHistories histories(ApplicationFormId applicationFormId) {
        return new WorkFlowHistories(workFlowHistoryMapper.histories(applicationFormId));
    }
}
