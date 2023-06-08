package workflow.application.service.form;

import org.springframework.stereotype.Service;
import workflow.domain.model.form.ApplicationForm;
import workflow.domain.model.form.ApplicationFormId;

/**
 * 申請書サービス
 */
@Service
public class ApplicationFormService {
    ApplicationFormRepository applicationFormRepository;

    ApplicationFormService(ApplicationFormRepository applicationFormRepository) {
        this.applicationFormRepository = applicationFormRepository;
    }

    /**
     * 申請書を作成する
     */
    public void register(ApplicationForm applicationForm, ApplicationFormId applicationFormId) {
        applicationFormRepository.register(applicationForm, applicationFormId);
    }

    /**
     * 申請書を取得する
     */
    public ApplicationForm applicationFormOf(ApplicationFormId applicationFormId) {
        return applicationFormRepository.applicationFormOf(applicationFormId);
    }
}
