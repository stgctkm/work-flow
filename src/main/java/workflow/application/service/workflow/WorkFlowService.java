package workflow.application.service.workflow;

import org.springframework.stereotype.Service;
import workflow.domain.model.workflow.*;

@Service
public class WorkFlowService {

    WorkFlowRepository workFlowRepository;
    ApplicationFormService applicationFormService;

    WorkFlowService(
            WorkFlowRepository workFlowRepository,
            ApplicationFormService applicationFormService) {
        this.workFlowRepository = workFlowRepository;
        this.applicationFormService = applicationFormService;
    }

    public void create(ApplicationForm applicationForm, String applicantUserName) {
        applicationFormService.register(applicationForm);
        Work work = new Work(applicationForm.id(), applicantUserName);
        workFlowRepository.registerCreation(work, WorkFlowEvent.作成);
    }

    /**
     * 申請
     */
    public void apply(ApplicationFormId applicationFormId, String assignedUserName)  {
        Work work = new Work(applicationFormId, assignedUserName);
        workFlowRepository.register(work, WorkFlowEvent.申請);
    }

    /**
     * 承認
     */
    public void approve(ApplicationFormId applicationFormId) {
        workFlowRepository.register(applicationFormId, WorkFlowEvent.承認);
    }

    /**
     * 差戻し
     */
    public void reject(ApplicationFormId applicationFormId, String assignedUserName) {
        Work work = new Work(applicationFormId, assignedUserName);
        workFlowRepository.register(work, WorkFlowEvent.差戻し);
    }

    /**
     * 却下
     */
    public void cancel(ApplicationFormId applicationFormId) {
        // 却下のステータスを記録する
        workFlowRepository.register(applicationFormId, WorkFlowEvent.却下);
    }

    /**
     * ワークフローの一覧を取得する
     */
    public WorkFlows listOf(String username) {
        return workFlowRepository.listOf(username);
    }
}
