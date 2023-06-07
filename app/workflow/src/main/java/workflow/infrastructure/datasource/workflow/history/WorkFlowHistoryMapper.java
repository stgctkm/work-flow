package workflow.infrastructure.datasource.workflow.history;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.workflow.history.WorkFlowHistory;

import java.util.List;

@Mapper
interface WorkFlowHistoryMapper {
    List<WorkFlowHistory> histories(
            @Param("applicationFormId") ApplicationFormId applicationFormId);
}
