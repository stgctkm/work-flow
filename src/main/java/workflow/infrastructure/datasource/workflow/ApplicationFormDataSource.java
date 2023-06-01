package workflow.infrastructure.datasource.workflow;

import org.springframework.stereotype.Repository;
import workflow.application.service.workflow.ApplicationFormRepository;
import workflow.domain.model.workflow.ApplicationForm;

@Repository
public class ApplicationFormDataSource implements ApplicationFormRepository {

    ApplicationFormMapper applicationFormMapper;

    ApplicationFormDataSource(ApplicationFormMapper applicationFormMapper) {
        this.applicationFormMapper = applicationFormMapper;
    }


    @Override
    public void register(ApplicationForm applicationForm) {
        applicationFormMapper.register(applicationForm); // TODO ID以外の設定
    }
}
