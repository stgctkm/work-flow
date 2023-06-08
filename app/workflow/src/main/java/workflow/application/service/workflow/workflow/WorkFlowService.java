package workflow.application.service.workflow.workflow;

import org.springframework.stereotype.Service;
import workflow.application.service.form.ApplicationFormService;
import workflow.domain.model.form.ApplicationForm;
import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.user.UserId;
import workflow.domain.model.workflow.*;

/**
 * ワークフローサービス
 */
@Service
public class WorkFlowService {

    WorkFlowRepository workFlowRepository;
    WorkFlowTransfer workFlowTransfer;
    ApplicationFormService applicationFormService;


    WorkFlowService(
            WorkFlowRepository workFlowRepository,
            WorkFlowTransfer workFlowTransfer,
            ApplicationFormService applicationFormService) {
        this.workFlowRepository = workFlowRepository;
        this.workFlowTransfer = workFlowTransfer;
        this.applicationFormService = applicationFormService;
    }

    /**
     * 作成
     */
    public ApplicationFormId create(ApplicationForm applicationForm, UserId userId) {
        ApplicationFormId applicationFormId = ApplicationFormId.newId();
        applicationFormService.register(applicationForm, applicationFormId);
        Work work = new Work(applicationFormId, userId);
        workFlowRepository.registerCreation(work, WorkFlowEvent.作成);
        return applicationFormId;
    }

    /**
     * 申請
     */
    public void apply(ApplicationFormId applicationFormId, UserId userId)  {
        Work work = new Work(applicationFormId, userId);
        workFlowRepository.register(work, WorkFlowEvent.申請);
        workFlowTransfer.notifyApplied(work);
    }

    /**
     * 承認
     */
    public void approve(ApplicationFormId applicationFormId) {
        workFlowRepository.register(applicationFormId, WorkFlowEvent.承認);
        WorkFlow workFlow = workFlowOf(applicationFormId);
        workFlowTransfer.notifyApproved(applicationFormId, workFlow.applicantUser());
    }

    /**
     * 差戻し
     */
    public void reject(ApplicationFormId applicationFormId) {
        WorkFlow workFlow = workFlowOf(applicationFormId);
        Work work = new Work(applicationFormId, workFlow.applicantUser().userId());
        workFlowRepository.register(work, WorkFlowEvent.差戻し);
        workFlowTransfer.notifyRejected(work, workFlow.applicantUser());
    }

    /**
     * 却下
     */
    public void cancel(ApplicationFormId applicationFormId) {
        // 却下のステータスを記録する
        workFlowRepository.register(applicationFormId, WorkFlowEvent.却下);
        WorkFlow workFlow = workFlowOf(applicationFormId);
        workFlowTransfer.notifyCanceled(applicationFormId, workFlow.applicantUser());
    }

    /**
     * ワークフローの一覧を取得する
     */
    public WorkFlows listOf(UserId userId, WorkFlowSearchCriteria workFlowSearchCriteria) {
        return workFlowRepository.listOf(userId, workFlowSearchCriteria);
    }

    /**
     * ワークフロー一覧を取得する
     */
    public WorkFlows list() {
        return workFlowRepository.list();
    }

    /**
     * ワークフローを取得する
     */
    public WorkFlow workFlowOf(ApplicationFormId applicationFormId) {
        return workFlowRepository.workFlowOf(applicationFormId);
    }
}
