package workflow.application.service.workflow;

import org.springframework.stereotype.Service;
import workflow.domain.model.workflow.ApplicationForm;
import workflow.domain.model.workflow.ApplicationFormId;

@Service
public class ApplicationFormService {
    ApplicationFormRepository applicationFormRepository;

    ApplicationFormService(ApplicationFormRepository applicationFormRepository) {
        this.applicationFormRepository = applicationFormRepository;
    }

    public void register(ApplicationForm applicationForm, ApplicationFormId applicationFormId) {
        applicationFormRepository.register(applicationForm, applicationFormId);
    }

    public ApplicationForm applicationFormOf(ApplicationFormId applicationFormId) {
        return applicationFormRepository.applicationFormOf(applicationFormId);
    }
}
