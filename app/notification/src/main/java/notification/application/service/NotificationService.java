package notification.application.service;

import notification.infrastructure.message.WorkFlowMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    Logger logger = LoggerFactory.getLogger(NotificationService.class);

    public void apply(WorkFlowMessage workFlowMessage) {
        logger.info("payload = {} ", workFlowMessage);
        logger.info(workFlowMessage.toMessage());
    }
}
