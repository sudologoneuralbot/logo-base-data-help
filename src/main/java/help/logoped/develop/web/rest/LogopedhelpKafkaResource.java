package help.logoped.develop.web.rest;

import help.logoped.develop.service.LogopedhelpKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logopedhelp-kafka")
public class LogopedhelpKafkaResource {

    private final Logger log = LoggerFactory.getLogger(LogopedhelpKafkaResource.class);

    private LogopedhelpKafkaProducer kafkaProducer;

    public LogopedhelpKafkaResource(LogopedhelpKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
