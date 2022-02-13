package xam.zorlac.servicebus.messageio;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import xam.zorlac.servicebus.models.PlanDetails;

@Service
@Slf4j
public class ServiceBusReceiver {


    @JmsListener(destination = "${zorlac.servicebus.topic}",
            containerFactory = "topicJmsListenerContainerFactory",
            subscription = "${zorlac.servicebus.subscriptions}")
    public void receivedFromTopic(PlanDetails planDetails) {
        log.info("############## Received from TOPIC " + planDetails);
    }

    @JmsListener(destination = "${zorlac.servicebus.queue}",
            containerFactory = "jmsListenerContainerFactory")
    public void receivedFromQueue(PlanDetails planDetails) {
        log.info("############### Received from QUEUE " + planDetails);
    }
}
