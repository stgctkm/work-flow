package workflow.application.service.workflow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import workflow.application.service.form.ApplicationFormService;
import workflow.application.service.workflow.workflow.WorkFlowService;
import workflow.domain.model.form.ApplicationForm;
import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.user.UserId;

@SpringBootTest
@Transactional
class WorkFlowServiceTest {

    @Autowired
    WorkFlowService sut;

    @Autowired
    ApplicationFormService applicationFormService;

    @Test
    void 申請() {

        ApplicationFormId 申請ID = ApplicationFormId.newId();
        applicationFormService.register(new ApplicationForm(), 申請ID);

        sut.apply(申請ID, new UserId(1));
    }
}