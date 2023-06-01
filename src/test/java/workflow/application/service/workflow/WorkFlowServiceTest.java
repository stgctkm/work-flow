package workflow.application.service.workflow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import workflow.domain.model.workflow.ApplicationForm;
import workflow.domain.model.workflow.ApplicationFormId;

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
        applicationFormService.register(new ApplicationForm(申請ID));

        sut.apply(申請ID, "user1");
    }
}