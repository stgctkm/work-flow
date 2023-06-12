package amqp.application.service;

import amqp.domain.model.workflow.ExpiredWorkFlowEvent;
import amqp.domain.model.workflow.WorkFlowMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    Logger logger = LoggerFactory.getLogger(NotificationService.class);

    public void notifyMessage(WorkFlowMessage workFlowMessage) {
        logger.info("payload = {} ", workFlowMessage);
        logger.info(workFlowMessage.toMessage());
    }

    public void notifyExpired(ExpiredWorkFlowEvent ExpiredWorkFlowEvent) {
        logger.info("ExpiredWorkFlowEvent payload = {} ", ExpiredWorkFlowEvent);
        logger.info(ExpiredWorkFlowEvent.toMessage());
    }
}
