package workflow.application.service.workflow.history;

import org.springframework.stereotype.Service;
import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.workflow.history.WorkFlowHistories;

/**
 * ワークフロー履歴サービス
 */
@Service
public class WorkFlowHistoryService {
    WorkFlowHistoryRepository workFlowHistoryRepository;

    WorkFlowHistoryService(WorkFlowHistoryRepository workFlowHistoryRepository) {
        this.workFlowHistoryRepository = workFlowHistoryRepository;
    }

    /**
     * ワークフロー履歴を取得する
     */
    public WorkFlowHistories histories(ApplicationFormId applicationFormId) {
        return workFlowHistoryRepository.histories(applicationFormId);
    }
}
