package notification.infrastructure.listener;

import notification.application.service.NotificationService;
import notification.domain.model.workflow.ExpiredWorkFlowEvent;
import notification.infrastructure.message.WorkFlowMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
public class NotificationListener {
    static Logger logger = LoggerFactory.getLogger(NotificationListener.class);

    @Bean
    public Consumer<Message<WorkFlowMessage>> receiveWorkFlowEvent(NotificationService notificationService) {
        return message -> {
            logger.info("message receive: {}", message);
            WorkFlowMessage payload = message.getPayload();
            notificationService.apply(payload);
        };
    }

    @Bean
    public Consumer<Message<ExpiredWorkFlowEvent>> receiveExpired(NotificationService notificationService) {
        return message -> {
            logger.info("message receive: {}", message);
            ExpiredWorkFlowEvent payload = message.getPayload();
            notificationService.notifyExpired(payload);
        };
    }
}
