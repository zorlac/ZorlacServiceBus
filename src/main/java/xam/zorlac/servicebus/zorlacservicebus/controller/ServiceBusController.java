package xam.zorlac.servicebus.zorlacservicebus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xam.zorlac.servicebus.zorlacservicebus.messageio.ServiceBusSender;
import xam.zorlac.servicebus.zorlacservicebus.models.PlanDetails;

@RestController
@RequestMapping("servicebus")
@Slf4j
public class ServiceBusController {

    private ServiceBusSender senderService;

    public ServiceBusController(ServiceBusSender senderService) {
        this.senderService = senderService;
    }


    @PostMapping("/topic/send")
    public ResponseEntity<String> sendToTopic(@RequestBody PlanDetails planDetails) {
        log.info(">>>>>>>>>>> SENDING TO TOPIC");
        var result = this.senderService.sendToTopic(planDetails);
        var text = result ? "Success" : "Fail";
        return new ResponseEntity<>(text, HttpStatus.OK);
    }

    @PostMapping("/queue/send")
    public ResponseEntity<String> sendToQueue(@RequestBody PlanDetails planDetails) {
        log.info(">>>>>>>>>>> SENDING TO QUEUE");
        var result = this.senderService.sendToQueue(planDetails);
        var text = result ? "Success" : "Fail";
        return new ResponseEntity<>(text, HttpStatus.OK);
    }
}
