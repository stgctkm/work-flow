package workflow.infrastructure.transfer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Repository;
import workflow.application.service.workflow.workflow.WorkFlowTransfer;
import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.user.User;
import workflow.domain.model.workflow.Work;

@Repository
public class WorkFlowPublisher implements WorkFlowTransfer {

    Logger logger = LoggerFactory.getLogger(WorkFlowPublisher.class);
    RabbitTemplate rabbitTemplate;

    WorkFlowPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @Override
    public void notifyApplied(Work work) {
        rabbitTemplate.convertAndSend("work-flow-topic", "routingKey.work-flow.event",  WorkFlowMessage.appliedMessage(work.applicationFormId(), work.assignedUserId()));
    }

    @Override
    public void notifyApproved(ApplicationFormId applicationFormId, User applicantUser) {
        rabbitTemplate.convertAndSend("work-flow-topic", "routingKey.work-flow.event",  WorkFlowMessage.approvedMessage(applicationFormId, applicantUser.userId()));
    }

    @Override
    public void notifyRejected(Work work, User applicantUser) {
        rabbitTemplate.convertAndSend("work-flow-topic", "routingKey.work-flow.event",  WorkFlowMessage.rejectedMessage(work.applicationFormId(), applicantUser.userId()));
    }

    @Override
    public void notifyCanceled(ApplicationFormId applicationFormId, User applicantUser) {
        rabbitTemplate.convertAndSend("work-flow-topic", "routingKey.work-flow.event",  WorkFlowMessage.canceledMessage(applicationFormId, applicantUser.userId()));
    }
}
