package workflow.infrastructure.datasource.workflow;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import workflow.domain.model.workflow.ApplicationForm;
import workflow.domain.model.workflow.ApplicationFormId;

@Mapper
interface ApplicationFormMapper {

    void register(
            @Param("applicationForm") ApplicationForm applicationForm,
            @Param("applicationFormId") ApplicationFormId applicationFormId);

    ApplicationForm applicationFormOf(
            @Param("applicationFormId") ApplicationFormId applicationFormId);
}
