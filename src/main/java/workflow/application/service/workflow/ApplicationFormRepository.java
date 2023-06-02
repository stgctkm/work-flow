package workflow.application.service.workflow;

import workflow.domain.model.workflow.ApplicationForm;
import workflow.domain.model.workflow.ApplicationFormId;

public interface ApplicationFormRepository {

    void register(ApplicationForm applicationForm, ApplicationFormId applicationFormId);

    ApplicationForm applicationFormOf(ApplicationFormId applicationFormId);
}
