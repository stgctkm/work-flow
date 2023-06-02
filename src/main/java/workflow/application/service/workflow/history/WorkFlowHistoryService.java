package workflow.application.service.workflow.history;

import org.springframework.stereotype.Service;
import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.workflow.history.WorkFlowHistories;

@Service
public class WorkFlowHistoryService {
    WorkFlowHistoryRepository workFlowHistoryRepository;

    WorkFlowHistoryService(WorkFlowHistoryRepository workFlowHistoryRepository) {
        this.workFlowHistoryRepository = workFlowHistoryRepository;
    }

    public WorkFlowHistories histories(ApplicationFormId applicationFormId) {
        return workFlowHistoryRepository.histories(applicationFormId);
    }
}
