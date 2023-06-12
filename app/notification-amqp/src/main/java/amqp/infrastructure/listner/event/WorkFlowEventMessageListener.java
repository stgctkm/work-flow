package amqp.infrastructure.listner.event;

import amqp.application.service.NotificationService;
import amqp.domain.model.workflow.WorkFlowMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkFlowEventMessageListener {

    NotificationService notificationService;

    WorkFlowEventMessageListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "${work-flow.event.notification.queue.name}")
    void listen(WorkFlowMessage workFlowMessage) {
        notificationService.notifyMessage(workFlowMessage);
    }
}
