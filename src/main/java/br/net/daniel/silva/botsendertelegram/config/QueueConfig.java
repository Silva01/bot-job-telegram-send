package br.net.daniel.silva.botsendertelegram.config;

import br.net.daniel.silva.botsendertelegram.receiver.Receiver;
import br.net.daniel.silva.botsendertelegram.send.SendService;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class QueueConfig {

    private SendService sendService;

    @Value("${queue.url.send}")
    private String queueNameUrl;

    @Autowired
    public QueueConfig(SendService sendService) {
        this.sendService = sendService;
    }

    @Bean
    public Queue send() {
        return new Queue(queueNameUrl, true);
    }

    @Profile("receive")
    @Bean
    public Receiver receiver() {
        return new Receiver(sendService);
    }
}
