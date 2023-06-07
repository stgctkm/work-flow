package notification.infrastructure.transfer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import workflow.application.service.workflow.workflow.WorkFlowTransfer;
import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.user.User;
import workflow.domain.model.workflow.Work;

@Repository
public class WorkFlowPublisher implements WorkFlowTransfer {

    Logger logger = LoggerFactory.getLogger(WorkFlowPublisher.class);

    @Override
    public void notifyApplied(Work work) {
        logger.info("申請（申請ID: {}) が ユーザー(ユーザーID {}) アサインされました", work.applicationFormId(), work.applicantUserId());
    }

    @Override
    public void notifyApproved(ApplicationFormId applicationFormId, User applicantUser) {
        logger.info("ユーザー(ユーザーID {})の申請（申請ID: {}) が 承認されました", applicationFormId, applicantUser.userId());
    }

    @Override
    public void notifyRejected(Work work, User applicantUser) {
        logger.info("ユーザー(ユーザーID {})の申請（申請ID: {}) が 差し戻されました", work.applicationFormId(), applicantUser.userId());
    }

    @Override
    public void notifyCanceled(ApplicationFormId applicationFormId, User applicantUser) {
        logger.info("ユーザー(ユーザーID {})の申請（申請ID: {}) が 却下されました", applicationFormId, applicantUser.userId());
    }
}
