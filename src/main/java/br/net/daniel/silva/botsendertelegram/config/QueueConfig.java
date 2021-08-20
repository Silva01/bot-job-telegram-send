package br.net.daniel.silva.botsendertelegram.config;

import br.net.daniel.silva.botsendertelegram.receiver.Receiver;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class QueueConfig {

    @Bean
    public Queue send() {
        return new Queue("jarvis.send.telegram", true);
    }

    @Profile("receive")
    @Bean
    public Receiver receiver() {
        return new Receiver();
    }
}
