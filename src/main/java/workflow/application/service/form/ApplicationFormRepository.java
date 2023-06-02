package workflow.application.service.form;

import workflow.domain.model.form.ApplicationForm;
import workflow.domain.model.form.ApplicationFormId;

public interface ApplicationFormRepository {

    void register(ApplicationForm applicationForm, ApplicationFormId applicationFormId);

    ApplicationForm applicationFormOf(ApplicationFormId applicationFormId);
}
