package workflow.infrastructure.datasource.workflow;

import org.springframework.stereotype.Repository;
import workflow.application.service.workflow.WorkFlowRepository;
import workflow.domain.model.workflow.*;

@Repository
public class WorkFlowDataSource implements WorkFlowRepository {

    WorkFlowMapper workFlowMapper;

    WorkFlowDataSource(WorkFlowMapper workFlowMapper) {
        this.workFlowMapper = workFlowMapper;
    }

    @Override
    public void register(Work work, WorkFlowEvent workFlowEvent) {

        WorkFlowHistoryId workFlowHistoryId = WorkFlowHistoryId.newHistoryId();
        workFlowMapper.registerEvent(work, workFlowHistoryId, workFlowEvent);
        workFlowMapper.registerAssignedUser(work, workFlowHistoryId);
        workFlowMapper.removeLatest(work);
        workFlowMapper.registerLatest(work, workFlowHistoryId, workFlowEvent.nextStatus());
    }

    @Override
    public void register(ApplicationFormId applicationFormId, WorkFlowEvent workFlowEvent) {
        throw new RuntimeException();
    }

    @Override
    public WorkFlows listOf(String username) {
        return new WorkFlows(workFlowMapper.listOf(username));
    }

    @Override
    public void registerCreation(Work work, WorkFlowEvent workFlowEvent) {
        WorkFlowHistoryId workFlowHistoryId = WorkFlowHistoryId.newHistoryId();
        workFlowMapper.registerEvent(work, workFlowHistoryId, workFlowEvent);
        workFlowMapper.registerAssignedUser(work, workFlowHistoryId);
        workFlowMapper.registerApplicant(work, work.applicantUser());
        workFlowMapper.removeLatest(work);
        workFlowMapper.registerLatest(work, workFlowHistoryId, workFlowEvent.nextStatus());
    }

}
