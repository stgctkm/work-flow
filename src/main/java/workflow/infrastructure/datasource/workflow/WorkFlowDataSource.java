package workflow.infrastructure.datasource.workflow;

import org.springframework.stereotype.Repository;
import workflow.application.service.workflow.workflow.WorkFlowRepository;
import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.workflow.*;
import workflow.domain.model.workflow.history.WorkFlowHistoryId;

@Repository
public class WorkFlowDataSource implements WorkFlowRepository {

    WorkFlowMapper workFlowMapper;

    WorkFlowDataSource(WorkFlowMapper workFlowMapper) {
        this.workFlowMapper = workFlowMapper;
    }

    @Override
    public void register(Work work, WorkFlowEvent workFlowEvent) {

        WorkFlowHistoryId workFlowHistoryId = WorkFlowHistoryId.newHistoryId();
        workFlowMapper.registerEvent(work.applicationFormId(), workFlowHistoryId, workFlowEvent);
        workFlowMapper.registerAssignedUser(work, workFlowHistoryId);
        workFlowMapper.removeLatest(work.applicationFormId());
        workFlowMapper.registerLatest(work.applicationFormId(), workFlowHistoryId, workFlowEvent.nextStatus());
    }

    @Override
    public void register(ApplicationFormId applicationFormId, WorkFlowEvent workFlowEvent) {
        WorkFlowHistoryId workFlowHistoryId = WorkFlowHistoryId.newHistoryId();
        workFlowMapper.registerEvent(applicationFormId, workFlowHistoryId, workFlowEvent);

        workFlowMapper.removeLatest(applicationFormId);
        workFlowMapper.registerLatest(applicationFormId, workFlowHistoryId, workFlowEvent.nextStatus());
    }

    @Override
    public WorkFlows listOf(String username, WorkFlowSearchCriteria workFlowSearchCriteria) {
        return new WorkFlows(workFlowMapper.listOf(username, workFlowSearchCriteria));
    }

    @Override
    public WorkFlow workFlowOf(ApplicationFormId applicationFormId) {
        return workFlowMapper.workFlowOf(applicationFormId);
    }

    @Override
    public void registerCreation(Work work, WorkFlowEvent workFlowEvent) {
        WorkFlowHistoryId workFlowHistoryId = WorkFlowHistoryId.newHistoryId();
        workFlowMapper.registerEvent(work.applicationFormId(), workFlowHistoryId, workFlowEvent);
        workFlowMapper.registerAssignedUser(work, workFlowHistoryId);
        workFlowMapper.registerApplicant(work, work.applicantUser());
        workFlowMapper.removeLatest(work.applicationFormId());
        workFlowMapper.registerLatest(work.applicationFormId(), workFlowHistoryId, workFlowEvent.nextStatus());
    }

}
