package xam.zorlac.servicebus.zorlacservicebus.messageio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import xam.zorlac.servicebus.zorlacservicebus.models.PlanDetails;

@Service
public class ServiceBusSender {

    private final JmsTemplate jmsTemplate;

    @Value("${zorlac.service-bus.topic}")
    private String destinationTopic;

    @Value("${zorlac.service-bus.queue}")
    private String destinationQueue;

    public ServiceBusSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public boolean sendToQueue(PlanDetails planDetails) {
        jmsTemplate.convertAndSend(this.destinationQueue, planDetails);
        return true;
    }

    public boolean sendToTopic(PlanDetails planDetails) {
        jmsTemplate.convertAndSend(this.destinationTopic, planDetails);
        return true;
    }

}
