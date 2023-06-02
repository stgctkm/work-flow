package workflow.application.service.workflow.workflow;

import org.springframework.stereotype.Service;
import workflow.application.service.form.ApplicationFormService;
import workflow.domain.model.form.ApplicationForm;
import workflow.domain.model.form.ApplicationFormId;
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

    public ApplicationFormId create(ApplicationForm applicationForm, String applicantUserName) {
        ApplicationFormId applicationFormId = ApplicationFormId.newId();
        applicationFormService.register(applicationForm, applicationFormId);
        Work work = new Work(applicationFormId, applicantUserName);
        workFlowRepository.registerCreation(work, WorkFlowEvent.作成);
        return applicationFormId;
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
    public void reject(ApplicationFormId applicationFormId) {
        WorkFlow workFlow = workFlowOf(applicationFormId);
        workFlowRepository.register(new Work(applicationFormId, workFlow.applicantUser()), WorkFlowEvent.差戻し);
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
    public WorkFlows listOf(String username, WorkFlowSearchCriteria workFlowSearchCriteria) {
        return workFlowRepository.listOf(username, workFlowSearchCriteria);
    }


    public WorkFlow workFlowOf(ApplicationFormId applicationFormId) {
        return workFlowRepository.workFlowOf(applicationFormId);
    }
}
