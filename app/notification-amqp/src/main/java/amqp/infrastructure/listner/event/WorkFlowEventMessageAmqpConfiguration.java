package amqp.infrastructure.listner.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class WorkFlowEventMessageAmqpConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(WorkFlowEventMessageAmqpConfiguration.class);

    private final String topicExchangeName;
    private final String notificationQueueName;

    public WorkFlowEventMessageAmqpConfiguration(
            @Value("${work-flow.event.topic.exchange.name}") String topicExchangeName,
            @Value("${work-flow.event.notification.queue.name}") String notificationQueueName) {
        this.topicExchangeName = topicExchangeName;
        this.notificationQueueName = notificationQueueName;
    }

    @Bean(name = "eventNotificationQueue")
    Queue notificationQueueName() {
        return new Queue(notificationQueueName, false);
    }

    @Bean
    TopicExchange workFlowEventExchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean(name = "work-flow.event.binding")
    Binding binding(Queue eventNotificationQueue, TopicExchange workFlowEventExchange) {
        return BindingBuilder.bind(eventNotificationQueue).to(workFlowEventExchange).with("routingKey.work-flow.event.amqp");
    }


}
