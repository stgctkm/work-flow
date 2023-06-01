package workflow.infrastructure.datasource.workflow;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import workflow.domain.model.workflow.ApplicationForm;

@Mapper
interface ApplicationFormMapper {

    void register(
            @Param("applicationForm") ApplicationForm applicationForm);
}
