package workflow.infrastructure.datasource.form;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import workflow.domain.model.form.ApplicationForm;
import workflow.domain.model.form.ApplicationFormId;

@Mapper
interface ApplicationFormMapper {

    void register(
            @Param("applicationForm") ApplicationForm applicationForm,
            @Param("applicationFormId") ApplicationFormId applicationFormId);

    ApplicationForm applicationFormOf(
            @Param("applicationFormId") ApplicationFormId applicationFormId);
}
