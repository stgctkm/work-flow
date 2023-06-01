package workflow.application.service.workflow;

import org.springframework.stereotype.Service;
import workflow.domain.model.workflow.ApplicationForm;

@Service
public class ApplicationFormService {
    ApplicationFormRepository applicationFormRepository;

    ApplicationFormService(ApplicationFormRepository applicationFormRepository) {
        this.applicationFormRepository = applicationFormRepository;
    }

    public void register(ApplicationForm applicationForm) {
        applicationFormRepository.register(applicationForm);
    }
}
