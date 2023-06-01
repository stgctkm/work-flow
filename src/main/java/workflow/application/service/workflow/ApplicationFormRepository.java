package workflow.application.service.workflow;

import workflow.domain.model.workflow.ApplicationForm;

public interface ApplicationFormRepository {

    void register(ApplicationForm applicationForm);
}
