package amqp.infrastructure.listner.expired;

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
public class ExpiredMessageAmqpConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(ExpiredMessageAmqpConfiguration.class);

    private final String topicExchangeName;
    private final String notificationQueueName;

    public ExpiredMessageAmqpConfiguration(
            @Value("${work-flow.expired.topic.exchange.name}") String topicExchangeName,
            @Value("${work-flow.expired.notification.queue.name}") String notificationQueueName) {
        this.topicExchangeName = topicExchangeName;
        this.notificationQueueName = notificationQueueName;
    }

    @Bean
    Queue notificationQueueName() {
        return new Queue(notificationQueueName, false);
    }

    @Bean
    TopicExchange expiredExchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue notificationQueueName, TopicExchange expiredExchange) {
        return BindingBuilder.bind(notificationQueueName).to(expiredExchange).with("routingKey.work-flow.expired.amqp");
    }

}
