package workflow.infrastructure.datasource.workflow;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import workflow.domain.model.workflow.*;

import java.util.List;

@Mapper
interface WorkFlowMapper {

    void registerEvent(
            @Param("work") Work work,
            @Param("workFlowHistoryId") WorkFlowHistoryId workFlowHistoryId,
            @Param("workFlowEvent") WorkFlowEvent workFlowEvent);

    void registerAssignedUser(
            @Param("work") Work work,
            @Param("workFlowHistoryId") WorkFlowHistoryId workFlowHistoryId);

    void removeLatest(@Param("work") Work work);

    void registerLatest(
            @Param("work") Work work,
            @Param("workFlowHistoryId") WorkFlowHistoryId workFlowHistoryId,
            @Param("workFlowStatus") WorkFlowStatus workFlowStatus);

    List<WorkFlow> listOf(
            @Param("username") String username);

    void registerApplicant(
            @Param("work") Work work,
            @Param("applicant") String applicant);
}
