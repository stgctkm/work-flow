package workflow.infrastructure.datasource.workflow;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.user.UserId;
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
            @Param("userId") UserId userId,
            @Param("criteria") WorkFlowSearchCriteria workFlowSearchCriteria);

    List<WorkFlow> list();

    void registerApplicant(
            @Param("work") Work work,
            @Param("applicantUserId") UserId applicantUserId);

    WorkFlow workFlowOf(
            @Param("applicationFormId") ApplicationFormId applicationFormId);

}
