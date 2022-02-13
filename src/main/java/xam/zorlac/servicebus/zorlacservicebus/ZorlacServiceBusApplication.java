package xam.zorlac.servicebus.zorlacservicebus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("xam.zorlac")
public class ZorlacServiceBusApplication {

    public static void main(String[] args) {

        SpringApplication.run(ZorlacServiceBusApplication.class, args);


    }

}
