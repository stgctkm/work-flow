package workflow.infrastructure.datasource.workflow;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.workflow.*;
import workflow.domain.model.workflow.history.WorkFlowHistoryId;

import java.util.List;

@Mapper
interface WorkFlowMapper {

    void registerEvent(
            @Param("applicationFormId") ApplicationFormId applicationFormId,
            @Param("workFlowHistoryId") WorkFlowHistoryId workFlowHistoryId,
            @Param("workFlowEvent") WorkFlowEvent workFlowEvent);

    void registerAssignedUser(
            @Param("work") Work work,
            @Param("workFlowHistoryId") WorkFlowHistoryId workFlowHistoryId);

    void removeLatest(
            @Param("applicationFormId") ApplicationFormId applicationFormId);

    void registerLatest(
            @Param("applicationFormId") ApplicationFormId applicationFormId,
            @Param("workFlowHistoryId") WorkFlowHistoryId workFlowHistoryId,
            @Param("workFlowStatus") WorkFlowStatus workFlowStatus);

    List<WorkFlow> listOf(
            @Param("username") String username,
            @Param("criteria") WorkFlowSearchCriteria workFlowSearchCriteria);

    void registerApplicant(
            @Param("work") Work work,
            @Param("applicant") String applicant);

    WorkFlow workFlowOf(
            @Param("applicationFormId") ApplicationFormId applicationFormId);

}
