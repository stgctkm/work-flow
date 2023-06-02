package workflow.infrastructure.datasource.form;

import org.springframework.stereotype.Repository;
import workflow.application.service.form.ApplicationFormRepository;
import workflow.domain.model.form.ApplicationForm;
import workflow.domain.model.form.ApplicationFormId;

@Repository
public class ApplicationFormDataSource implements ApplicationFormRepository {

    ApplicationFormMapper applicationFormMapper;

    ApplicationFormDataSource(ApplicationFormMapper applicationFormMapper) {
        this.applicationFormMapper = applicationFormMapper;
    }


    @Override
    public void register(ApplicationForm applicationForm, ApplicationFormId applicationFormId) {
        applicationFormMapper.register(applicationForm, applicationFormId);
    }

    @Override
    public ApplicationForm applicationFormOf(ApplicationFormId applicationFormId) {
        return applicationFormMapper.applicationFormOf(applicationFormId);
    }
}
