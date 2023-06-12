package amqp.infrastructure.listner.expired;

import amqp.application.service.NotificationService;
import amqp.domain.model.workflow.ExpiredWorkFlowEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ExpiredMessageListener {

    NotificationService notificationService;

    ExpiredMessageListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "${work-flow.expired.notification.queue.name}")
    void listen(ExpiredWorkFlowEvent expiredWorkFlowEvent) {
        notificationService.notifyExpired(expiredWorkFlowEvent);
    }
}
